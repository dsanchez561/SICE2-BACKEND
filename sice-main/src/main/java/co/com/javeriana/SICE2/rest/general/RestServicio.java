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

import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Servicio;
import co.com.javeriana.SICE2.repositories.ServicioRepository;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestServicio {	
	@Log
	private Logger log;
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	/**
	 * Metodo que permite listar todos los servicios de la Javeriana
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarServicios",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> listarServicios() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicioRepository.findAll());
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
}
