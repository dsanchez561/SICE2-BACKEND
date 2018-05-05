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
import co.com.javeriana.SICE2.model.general.Evento;
import co.com.javeriana.SICE2.model.general.RespuestaAtrPersonalizado;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.pojo.InscripcionPojo;
import co.com.javeriana.SICE2.pojo.NotificacionEventoPojo;
import co.com.javeriana.SICE2.repositories.AtrPersonalizadoRepository;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.RespuestaAtrPersonalizadoRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
import co.com.javeriana.SICE2.utils.ProcesadorSMTP;


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
	private UsuarioJaverianaRepository usuarioRepository;
	
	@Autowired
	private AtrPersonalizadoRepository atrPersonalizadoRepository;
	
	@Autowired
	private RespuestaAtrPersonalizadoRepository datoPersonalizadoRepository;
	
	@Autowired
	private ProcesadorSMTP correo;
	
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
			Evento evento = eventoRepository.findById(idEvento).get();
			UsuarioJaveriana usuario = usuarioRepository.findById(seguridad.getCurrentUser().getId()).get();
			if (evento.getInscritos().size()<evento.getCapacidad_maxima() || evento.getCapacidad_maxima()==-1) {
				if (!evento.getInscritos().contains(usuario)){
					correo.emailEventos("Se ha suscrito correctamente a "+evento.getTitulo(),seguridad.getCurrentUser().getEmail(),evento);
					evento.getInscritos().add(usuario);
					usuario.getEventosSuscritos().add(evento);
					return ResponseEntity.status(HttpStatus.OK).body(true);
				}else{
					for (AtrPersonalizado atrPersonalizado : evento.getAtrPersonalizados()) {
						RespuestaAtrPersonalizado datoPersonalizado =datoPersonalizadoRepository.findByAtrPersonalizadoAndUsuarioJaveriana(atrPersonalizado, usuario);
						datoPersonalizadoRepository.delete(datoPersonalizado);
					}
					evento.getInscritos().remove(usuario);
					usuario.getEventosSuscritos().remove(evento);
					return ResponseEntity.status(HttpStatus.OK).body(false);
				}
			}else {
				return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(false);
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite listar los incritos dado un id de un evento
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarInscritos/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioJaveriana>> listarIncritos(@PathVariable("id") Long idEvento) {
		if (seguridad.isAdministrador()){
			try {
				Evento evento = eventoRepository.findById(idEvento).get();
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
				if (evento.getAtrPersonalizados()!=null) {
					List<AtrPersonalizado> atrPersonalizados = evento.getAtrPersonalizados();
					for (AtrPersonalizado atr : atrPersonalizados) {
						atr.setId(null);
						atrPersonalizadoRepository.save(atr);
					}
				}else {
					evento.setAtrPersonalizados(new ArrayList<>());
				}
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
	
	/**
	 * Metodo que permite guardar los datos personalizados a la hora de inscribirse a un evento
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/guardarDatosPersonalizados",method=RequestMethod.POST)
	public ResponseEntity<Boolean> guardarDatosPersonalizados(@RequestBody List<InscripcionPojo> inscripcionesPojos) {
		try {
			for (InscripcionPojo inscripcion:inscripcionesPojos) {
				RespuestaAtrPersonalizado datosPersonalizados = new RespuestaAtrPersonalizado();
				AtrPersonalizado atrPersonalizado = atrPersonalizadoRepository.findById(inscripcion.getId()).get();
				UsuarioJaveriana usuario = seguridad.getCurrentUser();
				datosPersonalizados.setAtrPersonalizado(atrPersonalizado);
				datosPersonalizados.setUsuarioJaveriana(usuario);
				datosPersonalizados.setDato(inscripcion.getDato());
				datoPersonalizadoRepository.save(datosPersonalizados);
			}
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}
	
	
	/**
	 * Metodo que permite notificar a multiples usuarios por medio de un correo de novedades sobre un evento al cual se inscribieron
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/notificarUsuarios",method=RequestMethod.POST)
	public ResponseEntity<Boolean> notificarUsuarios(@RequestBody NotificacionEventoPojo notificacionEventoPojo) {
		try {
			for (UsuarioJaveriana usuario : notificacionEventoPojo.getUsuario()) {
				correo.emailNotificarEvento(notificacionEventoPojo.getAsunto(), notificacionEventoPojo.getDescripcion(), usuario);
			}
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
