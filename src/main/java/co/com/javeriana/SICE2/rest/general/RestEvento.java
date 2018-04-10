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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SICE2.entidades.Evento;
import co.com.javeriana.SICE2.entidades.UsuarioJaveriana;
import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.UsuarioRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
import co.com.javeriana.SICE2.utils.Util;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestEvento {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static String SINPERMISOS = "No tiene permisos para acceder a esta funcionalidad";
	
	/**
	 * Metodo que permite inscribir a un usuario a un evento
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@Transactional
	@RequestMapping(value="/inscribirse/{id}",method=RequestMethod.GET)
	public ResponseEntity<Boolean> asociarTipoProyecto(@PathVariable("id") Long idEvento) {
		try {
			Evento evento = eventoRepository.findOne(idEvento);
			UsuarioJaveriana usuario = usuarioRepository.findOne(seguridad.getCurrentUser().getId());
			if (!evento.getInscritos().contains(usuario)){
				Util.emailEventos("Se ha suscrito correctamente a "+evento.getTitulo(),seguridad.getCurrentUser().getEmail(),evento);
				evento.getInscritos().add(usuario);
				usuario.getEventosSuscritos().add(evento);
				return ResponseEntity.status(HttpStatus.OK).body(true);
			}else{
				evento.getInscritos().remove(usuario);
				usuario.getEventosSuscritos().remove(evento);
				return ResponseEntity.status(HttpStatus.OK).body(false);
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite asociar tipos de proyectos que le interesan al usuario
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarInscritos/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioJaveriana>> listarIncritos(@PathVariable("id") Long idEvento) {
		if (seguridad.isAdministrador()){
			try {
				Evento evento = eventoRepository.findOne(idEvento);
				return ResponseEntity.status(HttpStatus.OK).body(evento.getInscritos());
			}catch (Exception e) {
				log.error(e.getMessage(), e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else{
			throw new SeguridadException(SINPERMISOS);
		}
	}
	
	/**
	 * Metodo que permite listar todos los eventos registrados en el sistema
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarTodosEventos",method=RequestMethod.GET)
	public ResponseEntity<List<Evento>> listarTodosEventos() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(eventoRepository.findAll());
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite crear un evento
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/crearEvento",method=RequestMethod.POST)
	public ResponseEntity<Evento> listarTodosEventos(@RequestBody Evento evento) {
		if (seguridad.isAdministrador()){
			try {
				evento.setCreador(seguridad.getCurrentUser());
				return ResponseEntity.status(HttpStatus.OK).body(eventoRepository.save(evento));
			}catch (Exception e) {
				log.error(e.getMessage(), e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else{
			throw new SeguridadException(SINPERMISOS);
		}
	}
	
}
