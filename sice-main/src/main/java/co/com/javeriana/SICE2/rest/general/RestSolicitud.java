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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Solicitud;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.pojo.SolicitudPojo;
import co.com.javeriana.SICE2.repositories.SolicitudRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
import co.com.javeriana.SICE2.utils.ProcesadorSMTP;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestSolicitud {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private UsuarioJaverianaRepository usuarioRepository;
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Autowired
	private ProcesadorSMTP correo;
	
	private static String SINPERMISOS = "No tiene permisos para acceder a esta funcionalidad";
	
	/**
	 * Metodo que permite crear una solicitud para un servicio de la Javeriana
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/crearSolicitud",method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Boolean> asociarTipoProyecto(@RequestBody SolicitudPojo solicitudPojo) {
		try {
			Solicitud solicitud = new Solicitud();
			UsuarioJaveriana usuarioActual = usuarioRepository.findById(seguridad.getCurrentUser().getId()).get();
			solicitud.setCreador(usuarioActual);
			solicitud.setActiva(true);
			solicitud.setFecha(new java.util.Date());
			solicitud.setDescripcion(solicitudPojo.getDescripcion());
			solicitud.setNombre(solicitudPojo.getNombre());
			solicitudRepository.save(solicitud);
			for (UsuarioJaveriana admin : usuarioRepository.findUsuarioByAdministrador(true)){
				correo.emailServicios("Nueva solicitud de servicio", admin, solicitud);
			}
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite listar todas las solicitudes creadas por los usuarios
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarSolicitudes/{num}",method=RequestMethod.GET)
	public ResponseEntity<List<Solicitud>> asociarTipoProyecto(@RequestParam int num) {
		if (seguridad.isAdministrador()) {
			try {
				if (num == 0) {
					return ResponseEntity.status(HttpStatus.OK).body(solicitudRepository.findAll());
				}
				if (num == 1) {
					return ResponseEntity.status(HttpStatus.OK).body(solicitudRepository.findByActiva(true));
				}
				if (num == 2) {
					return ResponseEntity.status(HttpStatus.OK).body(solicitudRepository.findByActiva(false));
				}
			}catch (Exception e) {
				log.error(e.getMessage(), e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else {
			throw new SeguridadException(SINPERMISOS);
		}
		return null;
	}
}
