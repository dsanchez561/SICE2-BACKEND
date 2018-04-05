package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.com.javeriana.SICE2.comandos.mensaje.Mensaje;
import co.com.javeriana.SICE2.entidades.Dominio;
import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.implement.DominioImpl;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;

@RestController
public class RestDominio {
	@Log
	private Logger log;
	
	@Autowired
	private DominioImpl dominioImpl;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	private static String SINPERMISOS = "No tiene permisos para acceder a esta funcionalidad";
	
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
	 * Metodo que permite listar todos los dominios nacionales dado el tipo (Universidad, Entidad Publica, Empresa...etc)
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
	 * Método que expone el servicio de subir una imagen
	 * 
	 * @param file
	 *            archivo
	 * @param id
	 *            de universidad
	 * @return nada
	 */
	@RequestMapping(value = "/imagen/upload/{id}", method = RequestMethod.POST)
	public ResponseEntity<Object> uploadImage(@RequestBody MultipartFile file, @PathVariable("id") String id) {
		if (seguridad.isAdministrador()){
			try {
				Mensaje mensaje = dominioImpl.validarImagen(file);
				if (mensaje == null) {
					dominioImpl.uploadImage(file, Long.valueOf(id));
					return ResponseEntity.status(HttpStatus.OK).body(null);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensaje);
				}
			}catch (Exception e) {
				log.error(e.getMessage(), e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else{
			throw new SeguridadException(SINPERMISOS);
		}
	}
	
	/**
	 * Método que expone el servicio de obetener las imágenes
	 * @param id de universidad
	 */
	@RequestMapping(value="/imagenes/download/{id}", method=RequestMethod.POST)
	public ResponseEntity<Object> downloadImage(@PathVariable("id") String id){
		if (seguridad.isAdministrador()){
			try {
				dominioImpl.downloadImage(id);
				return ResponseEntity.status(HttpStatus.OK).body(null);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else{
			throw new SeguridadException(SINPERMISOS);
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

}
