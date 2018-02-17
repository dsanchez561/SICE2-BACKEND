package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.com.javeriana.SICE2.comandos.mensaje.Mensaje;
import co.com.javeriana.SICE2.entidades.Universidad;
import co.com.javeriana.SICE2.implement.UniversidadImpl;
import co.com.javeriana.SICE2.log.Log;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("universidad")
public class RestUniversidad {
	@Log
	private Logger log;

	@Autowired
	private UniversidadImpl universidadImpl;
	
	/**
	 * Metodo que permite listar todas las universidades
	 * 
	 * @return devuelve la lista de universidades
	 * @throws IOException
	 */
	@RequestMapping(value = "/listarUniversidades", method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> listarUniversidades() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(universidadImpl.listarUniversidades());
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
		try {
			Mensaje mensaje = universidadImpl.validarImagen(file);
			if (mensaje == null) {
				universidadImpl.uploadImage(file, Long.valueOf(id));
				return ResponseEntity.status(HttpStatus.OK).body(null);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensaje);
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Método que expone el servicio de obetener las imágenes
	 * @param id de universidad
	 * @return nada
	 */
	@RequestMapping(value="/imagenes/download/{id}", method=RequestMethod.POST)
	public ResponseEntity<Object> downloadImage(@PathVariable("id") String id){
		try {
			universidadImpl.downloadImage(id);
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
