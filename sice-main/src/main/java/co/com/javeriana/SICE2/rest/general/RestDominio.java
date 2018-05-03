package co.com.javeriana.SICE2.rest.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.implement.DominioImpl;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Dominio;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
import co.com.javeriana.SICE2.seguridad.Seguridad;
import co.com.javeriana.SICE2.seguridad.SeguridadInfo;
import jxl.write.WriteException;

@RestController
public class RestDominio {
	@Log
	private Logger log;
	
	@Autowired
	private DominioImpl dominioImpl;
	
	@Autowired
	private Seguridad user;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	private static String SINPERMISOS = "No tiene permisos para acceder a esta funcionalidad";
	
	private static final int BUFFER_SIZE = 4096;
	
	/**
	 * Metodo que permite listar todos los dominios nacionales dado el tipo (Universidad, Entidad Publica, Empresa...etc)
	 * 
	 * @return devuelve la lista de dominios
	 * @throws IOException
	 */
	@RequestMapping(value = "/listarDominiosNacionales", method = RequestMethod.POST)
	public ResponseEntity<List<Dominio>> listarDominioNacionales(@RequestBody String tipo) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(dominioImpl.listarDominiosNacionales(tipo));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	

	/**
	 * Metodo que permite listar todos los dominios internacionales dado el tipo (Universidad, Entidad Publica, Empresa...etc)
	 * 
	 * @return devuelve la lista de dominios
	 * @throws IOException
	 */
	@RequestMapping(value = "/listarDominiosInternacionales", method = RequestMethod.POST)
	public ResponseEntity<List<Dominio>> listarDominiosInternacionales(@RequestBody String tipo) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(dominioImpl.listarDominiosInternacionales(tipo));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite listar todos los dominios ausjal dado el tipo (Universidad, Entidad Publica, Empresa...etc)
	 * 
	 * @return devuelve la lista de dominios
	 * @throws IOException
	 */
	@RequestMapping(value = "/listarDominiosAusjal", method = RequestMethod.POST)
	public ResponseEntity<List<Dominio>> listarDominiosAusjal(@RequestBody String tipo) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(dominioImpl.listarDominiosInternacionales(tipo));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Método que expone el servicio de subir una imagen
	 * 
	 * @param file
	 *            archivo
	 * @param id
	 *            de universidad
	 * @return nada
	 */
	@RequestMapping(value = "/imagen/upload/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> uploadImage(@RequestBody MultipartFile file, @PathVariable("id") String id) {
		try {
			if (seguridad.isAdministrador()){
				dominioImpl.uploadImage(file, Long.valueOf(id));
				return ResponseEntity.status(HttpStatus.OK).body(null);
			}else{
				throw new SeguridadException(SINPERMISOS);
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Método que expone el servicio de obetener las imágenes
	 * @param id de universidad
	 */
	@RequestMapping(value="/imagenes/download", method=RequestMethod.POST)
	public ResponseEntity<Object> downloadImage(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Método que expone el servicio de obetener las imágenes
	 * @param id de universidad
	 * @return nada
	 */
	@RequestMapping(value="/obtenerURL/{id}/{pagina}", method=RequestMethod.GET)
	public ResponseEntity<String> obtenerURL(@PathVariable("id") Long id, @PathVariable("pagina") String pagina){
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(dominioImpl.obtenerURL(id, pagina));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Método que expone el servicio de exportar excel de inscritos
	 * @param id del evento
	 * @return nada
	 * @throws IOException 
	 * @throws WriteException 
	 */
	@RequestMapping(value="/exportarExcelInscritos/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> exportarExcelInscritos(@PathVariable("id") Long id) throws WriteException, IOException {
		try {
			System.out.println("EEEEEEEEE                EEEE");
			dominioImpl.exportarExcelInscritos(id);
			String fileName = "Inscritos "+eventoRepository.findById(id).get().getTitulo()+" "+user.getCurrentUser().getUsername();
//			File fileToDownload = new File("/var/lib/tomcat8/webapps/"+fileName+".xls");
			File fileToDownload = new File("archivos/"+fileName+".xls");
			InputStreamResource resource = new InputStreamResource(new FileInputStream(fileToDownload));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", fileToDownload.getName()));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");
			
			ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(fileToDownload.length()).contentType(org.springframework.http.MediaType.parseMediaType("application/txt")).body(resource);
			System.out.println("EEEEEEEEE                EEEE");
			return responseEntity;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Error Ocurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}		 
	}
	
	/**
	 * Método que expone el servicio de exportar pdf de inscritos
	 * @param id del evento
	 * @return nada
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws URISyntaxException 
	 * @throws DocumentException 
	 */
	@RequestMapping(value="/exportarPdfInscritos/{id}", method=RequestMethod.GET, produces="application/pdf")
	public javax.ws.rs.core.Response exportarPdfInscritos(@PathVariable("id") Long id, HttpServletResponse response) throws IOException, WriteException, DocumentException, URISyntaxException{
		dominioImpl.exportarPdfInscritos(id, response);
		String fileName = "Inscritos "+eventoRepository.findById(id).get().getTitulo();
		File file = new File("archivos/"+fileName+".pdf");
	    FileInputStream fileInputStream = new FileInputStream(file);
	    javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.ok((Object) fileInputStream);
	    responseBuilder.type("application/pdf");
	    responseBuilder.header("Content-Disposition", "filename="+fileName+".pdf");
	    return responseBuilder.build();
	}

}
