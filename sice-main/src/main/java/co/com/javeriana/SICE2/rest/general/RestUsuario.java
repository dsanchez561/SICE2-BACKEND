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

import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Evento;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestUsuario {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private UsuarioJaverianaRepository usuarioRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	/**
	 * Metodo que permite listar los eventos a los que esta suscrito el usuario actual
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarEventosPorUsuario",method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<List<Evento>> asociarTipoProyecto() {
		try {
			UsuarioJaveriana usuarioActual = usuarioRepository.findById(seguridad.getCurrentUser().getId()).get();
			return ResponseEntity.status(HttpStatus.OK).body(usuarioActual.getEventosSuscritos());
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite determinar si un usuario está inscrito a un evento o no
	 * 
	 * @return devuelve un booleano que determina si está inscrito
	 * @throws IOException
	 */
	@Transactional
	@RequestMapping(value="/inscrito/{id}",method=RequestMethod.GET)
	public ResponseEntity<Boolean> inscrito(@PathVariable("id") Long idEvento) {
		try {
			Evento evento = eventoRepository.findById(idEvento).get();
			UsuarioJaveriana usuario = usuarioRepository.findUsuarioById(seguridad.getCurrentUser().getId());
			return ResponseEntity.status(HttpStatus.OK).body(evento.getInscritos().contains(usuario));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite listar todos los eventos a los que se encuentra inscrito el usuario actual
	 * 
	 * @return lista de eventos
	 * @throws IOException
	 */
	@Transactional
	@RequestMapping(value="/listarEventosPorUsuario",method=RequestMethod.GET)
	public ResponseEntity<List<Evento>> listarEventosPorUsuario() {
		try {
			UsuarioJaveriana usuario = usuarioRepository.findUsuarioById(seguridad.getCurrentUser().getId());
			return ResponseEntity.status(HttpStatus.OK).body(usuario.getEventosSuscritos());
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
}
