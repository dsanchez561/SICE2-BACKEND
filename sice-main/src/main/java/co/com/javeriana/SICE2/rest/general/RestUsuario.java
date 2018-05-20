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
import co.com.javeriana.SICE2.model.general.Etiqueta;
import co.com.javeriana.SICE2.model.general.Evento;
import co.com.javeriana.SICE2.model.general.Idea;
import co.com.javeriana.SICE2.model.general.Solicitud;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.pojo.IdeaPojo;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.IdeaRepository;
import co.com.javeriana.SICE2.repositories.SolicitudRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
import co.com.javeriana.SICE2.utils.ProcesadorSMTP;


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
	
	@Autowired
	private IdeaRepository ideaRepository;
	
	@Autowired
	private ProcesadorSMTP correo;
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	
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
	
	/**
	 * Metodo que permite listar todos los servicios creados por el usuario actual
	 * 
	 * @return lista de eventos
	 * @throws IOException
	 */
	@Transactional
	@RequestMapping(value="/listarSolicitudesPorUsuario",method=RequestMethod.GET)
	public ResponseEntity<List<Solicitud>> listarSolicitudesPorUsuario() {
		try {
			UsuarioJaveriana usuario = usuarioRepository.findUsuarioById(seguridad.getCurrentUser().getId());
			return ResponseEntity.status(HttpStatus.OK).body(solicitudRepository.findByCreador(usuario));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite listar todos las ideas creadas por el usuario
	 * 
	 * @return lista de eventos
	 * @throws IOException
	 */
	@Transactional
	@RequestMapping(value="/listarIdeasPorUsuario",method=RequestMethod.GET)
	public ResponseEntity<List<Idea>> listarIdeasPorUsuario() {
		try {
			UsuarioJaveriana usuario = usuarioRepository.findUsuarioById(seguridad.getCurrentUser().getId());
			return ResponseEntity.status(HttpStatus.OK).body(usuario.getIdeas());
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite añadir las preferencias a un administrador
	 * 
	 * @return booleano que identifica si fue satisfactoreo el proceso
	 * @throws IOException
	 */
	@Transactional
	@RequestMapping(value="/asignarEtiquetas",method=RequestMethod.POST)
	public ResponseEntity<Boolean> asignarEtiquetas(@RequestBody List<Etiqueta> etiquetas) {
		try {
			if (seguridad.isAdministrador()) {
				UsuarioJaveriana usuarioJaveriana = usuarioRepository.findUsuarioById(seguridad.getCurrentUser().getId());
				List<Etiqueta> preferencias = usuarioJaveriana.getPreferencias();
				if (preferencias == null) {
					usuarioJaveriana.setPreferencias(new ArrayList<>());
				}
				for (Etiqueta etiqueta : etiquetas) {
					usuarioJaveriana.getPreferencias().add(etiqueta);
				}
				usuarioRepository.save(usuarioJaveriana);
				return ResponseEntity.status(HttpStatus.OK).body(true);
			}else {
				throw new SeguridadException("No tiene permisos para acceder a esta funcionalidad");
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite guardar una idea con su respectiva etiqueta
	 * 
	 * @return booleano que identifica si fue satisfactoreo el proceso
	 * @throws IOException
	 */
	@Transactional
	@RequestMapping(value="/guardarIdea",method=RequestMethod.POST)
	public ResponseEntity<Boolean> guardarIdea(@RequestBody IdeaPojo ideaPojo) {
		try {
			UsuarioJaveriana usuarioJaveriana = usuarioRepository.findUsuarioById(seguridad.getCurrentUser().getId());
			if (usuarioJaveriana.getIdeas().size()<5) {
				List<UsuarioJaveriana> usuarios = usuarioRepository.findUsuarioByAdministrador(true);
				Idea idea = new Idea();
				idea.setEtiquetas(new ArrayList<>());
				idea.setUsuarioJaveriana(usuarioJaveriana);
				idea.setTitulo(ideaPojo.getNombre());
				idea.setDescripcion(ideaPojo.getDescripcion());
				idea.setEtapa(ideaPojo.getEtapa());
				for (UsuarioJaveriana usuario : usuarios) {
					Boolean coincidencia = false;
					List<Etiqueta> etiquetasCoincidencia = new ArrayList<>();
					List<Etiqueta> etiquetas = usuario.getPreferencias();
					for (Etiqueta etiquetaRecibida : ideaPojo.getEtiquetas()) {
						idea.getEtiquetas().add(etiquetaRecibida);
						if (etiquetas!=null) {
							for (Etiqueta etiqueta : etiquetas){
								if(etiqueta.getNombre().equals(etiquetaRecibida.getNombre()) ) {
									coincidencia = true;
									etiquetasCoincidencia.add(etiqueta);
								}
							}
						}
					}
					if (coincidencia) {
						correo.emailNotificarIdea("¡Nueva Idea!", usuario, usuarioJaveriana, idea, etiquetasCoincidencia);
					}
					
				}
				ideaRepository.save(idea);
				return ResponseEntity.status(HttpStatus.OK).body(true);
			}else {
				return ResponseEntity.status(HttpStatus.OK).body(false);
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
}
