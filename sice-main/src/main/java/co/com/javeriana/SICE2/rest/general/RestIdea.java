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

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Idea;
import co.com.javeriana.SICE2.repositories.IdeaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestIdea {	
	@Log
	private Logger log;
	
	@Autowired
	private IdeaRepository ideaRepository;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	/**
	 * Metodo que permite listar todas las ideas de los usuarios
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarIdeas",method=RequestMethod.GET)
	public ResponseEntity<List<Idea>> listarIdeas() {
		try {
			if (seguridad.isAdministrador()) {
				return ResponseEntity.status(HttpStatus.OK).body(ideaRepository.findAll());
			}else {
				throw new SeguridadException("No tiene permisos para acceder a esta funcionalidad");
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
