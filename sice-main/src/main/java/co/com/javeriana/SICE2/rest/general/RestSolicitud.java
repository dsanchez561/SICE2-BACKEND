package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Evento;
import co.com.javeriana.SICE2.model.general.Solicitud;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;


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
	private EventoRepository eventoRepository;
	
	/**
	 * Metodo que permite crear una solicitud para un servicio de la Javeriana
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/crearSolicitud",method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<List<Evento>> asociarTipoProyecto() {
		try {
			Solicitud solicitud = new Solicitud();
			UsuarioJaveriana usuarioActual = usuarioRepository.findById(seguridad.getCurrentUser().getId()).get();
			solicitud.setCreador(usuarioActual);
			solicitud.setActiva(true);
			return ResponseEntity.status(HttpStatus.OK).body(usuarioActual.getEventosSuscritos());
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
	
	
}
