package co.com.javeriana.SIEEJ.rest.general;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SIEEJ.entidades.Universidad;
import co.com.javeriana.SIEEJ.log.Log;
import co.com.javeriana.SIEEJ.repositories.UniversidadRepository;

@RestController
public class RestUniversidad {	
	@Log
	private Logger log;
	
	@Autowired
	private UniversidadRepository universidadRepository;
	
	/**
	 * Metodo que permite listar todas las entidades del usuario
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarUniversidades",method=RequestMethod.GET)
	public ResponseEntity<List<Universidad>> listarUniversidades() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(universidadRepository.findByactivo(true));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
}
