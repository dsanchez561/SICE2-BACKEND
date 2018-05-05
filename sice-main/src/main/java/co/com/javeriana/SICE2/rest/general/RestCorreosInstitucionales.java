package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.CorreosInstitucionales;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.CorreosInstitucionalesRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestCorreosInstitucionales {	
	@Log
	private Logger log;

	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private CorreosInstitucionalesRepository correosInstitucionalesRepository;
	
	@Autowired
	private UsuarioJaverianaRepository usuarioJaverianaRepository;
	/**
	 * Metodo que permite listar todos los correos de los departamentos asociados a ecosistema de emprendimiento javeriano
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarCorreosInstitucionales",method=RequestMethod.GET)
	public ResponseEntity<List<CorreosInstitucionales>> listarCorreosInstitucionales() {
		try {
			if (seguridad.isAdministrador()) {
				return ResponseEntity.status(HttpStatus.OK).body(correosInstitucionalesRepository.findAll());
			}else {
				throw new SeguridadException("No tiene permisos para acceder a esta funcionalidad");
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite crear correo institucional
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/crearCorreoInstitucional",method=RequestMethod.POST)
	public ResponseEntity<Boolean> crearCorreoInstitucional(@RequestBody CorreosInstitucionales correosInstitucionales) {
		try {
			if (seguridad.isAdministrador()) {
				UsuarioJaveriana usuarioJaveriana = usuarioJaverianaRepository.findUsuarioById(seguridad.getCurrentUser().getId());
				correosInstitucionales.setCreador(usuarioJaveriana);
				correosInstitucionalesRepository.save(correosInstitucionales);
				return ResponseEntity.status(HttpStatus.OK).body(true);
			}else {
				throw new SeguridadException("No tiene permisos para acceder a esta funcionalidad");
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
