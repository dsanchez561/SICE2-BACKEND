/**
 * 
 */
package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SICE2.entidades.EntidadPublica;
import co.com.javeriana.SICE2.implement.EntidadPublicaImpl;
import co.com.javeriana.SICE2.log.Log;

/**
 * @author Javeriana
 *
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("entidadPublica")
public class RestEntidadPublica {
	
	@Log
	private Logger log;

	@Autowired
	private EntidadPublicaImpl entidadPublicaImpl;
	
	/**
	 * Metodo que permite listar todas las entidades publicas
	 * 
	 * @return devuelve la lista de entidades publicas
	 * @throws IOException
	 */
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<EntidadPublica>> listarEntidadesPublicas() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(entidadPublicaImpl.listarEntidadesPublicas());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
