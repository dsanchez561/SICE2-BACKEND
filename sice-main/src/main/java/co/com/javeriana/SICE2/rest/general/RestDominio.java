package co.com.javeriana.SICE2.rest.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.implement.DominioImpl;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Dominio;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
import jxl.write.WriteException;

@RestController
public class RestDominio {
	@Log
	private Logger log;
	
	@Autowired
	private DominioImpl dominioImpl;
	
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
	public ResponseEntity<byte[]> uploadImage(@PathVariable("id") String id) {
		try {
			if (seguridad.isAdministrador()){
				return ResponseEntity.status(HttpStatus.OK).body(dominioImpl.uploadImage(Long.valueOf(id)));
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
	public void exportarExcelInscritos(@PathVariable("id") Long id, HttpServletResponse response) throws IOException, WriteException{
		dominioImpl.exportarExcelInscritos(id);
		String fileName = "Inscritos "+eventoRepository.findById(id).get().getTitulo();
		File file = new File("/var/lib/tomcat8/webapps/"+fileName+".xls");
		FileInputStream inputStream = new FileInputStream(file);
		if(file.exists()) {
//			ResponseBuilder response1 = Response.ok((Object)file);
//			response.setContentType("application/ms-excel");
//		    response1.header("Content-Disposition", 
//		    		"attachment; filename="+fileName+".xls");
//		    return response1.build();
			response.setContentType("MIME type: application/octet-stream");
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", 
		    		"attachment; filename="+fileName+".xls");
			OutputStream outStream = response.getOutputStream();
			 
	        byte[] buffer = new byte[BUFFER_SIZE];
	        int bytesRead = -1;
	 
	        // write bytes read from the input stream into the output stream
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	 
	        inputStream.close();
	        outStream.close();
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
