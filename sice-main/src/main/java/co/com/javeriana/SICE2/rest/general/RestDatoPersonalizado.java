package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.AtrPersonalizado;
import co.com.javeriana.SICE2.model.general.RespuestaAtrPersonalizado;
import co.com.javeriana.SICE2.model.general.Evento;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.pojo.InscripcionPojo;
import co.com.javeriana.SICE2.repositories.AtrPersonalizadoRepository;
import co.com.javeriana.SICE2.repositories.RespuestaAtrPersonalizadoRepository;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
import co.com.javeriana.SICE2.utils.ProcesadorSMTP;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestDatoPersonalizado {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private UsuarioJaverianaRepository usuarioRepository;
	
	@Autowired
	private AtrPersonalizadoRepository atrPersonalizadoRepository;
	
	@Autowired
	private RespuestaAtrPersonalizadoRepository datoPersonalizadoRepository;
	
	@Autowired
	private ProcesadorSMTP correo;
	
	private static String SINPERMISOS = "No tiene permisos para acceder a esta funcionalidad";

	
	/**
	 * Metodo que permite guardar los datos personalizados a la hora de inscribirse a un evento
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarDatosPersonalizadosPorUsuario",method=RequestMethod.POST)
	//TODO:: toca crear un pojo para recibir id de usuario y id de evento
	public ResponseEntity<List<RespuestaAtrPersonalizado>> guardarDatosPersonalizados(@RequestBody List<InscripcionPojo> inscripcionesPojos) {
		if (seguridad.getCurrentUser().getAdministrador()) {
			try {
				return ResponseEntity.status(HttpStatus.OK).body(datoPersonalizadoRepository.findAll());
			}catch (Exception e) {
				log.error(e.getMessage(), e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else {
			throw new SeguridadException(SINPERMISOS);
		}
	}
}
