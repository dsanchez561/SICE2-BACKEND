package co.com.javeriana.SIIEJ.rest;

import java.util.List;

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

import co.com.javeriana.SIIEJ.entidades.Etiqueta;
import co.com.javeriana.SIIEJ.entidades.Usuario;
import co.com.javeriana.SIIEJ.implementacion.UsuarioImpl;
import co.com.javeriana.SIIEJ.log.Log;


@CrossOrigin(allowCredentials="true")
@RestController
@RequestMapping("usuario")
public class RestUsuario {	
	
	@Log
	private Logger log;
	
	@Autowired
	private UsuarioImpl usuarioImpl;
	
	/**
	 * Método que expone el servicio de asociar etiquetas a un usuario
	 * @param id del usuario
	 * @param etiquetas lista de etiquetas
	 * @return la entidad usuario
	 */
	@RequestMapping(value="/asociarEtiquetas/{id}",method=RequestMethod.POST)
	public ResponseEntity<Usuario> asociarEtiquetas(@PathVariable("id") String id, @RequestBody List<Etiqueta> etiquetas){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioImpl.asociarEtiquetas(id, etiquetas));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Método que expone el servicio de asociar evento creado a un usuario
	 * @param id del usuario
	 * @param evento evento creado
	 * @return la entidad usuario
	 */
	@RequestMapping(value="/asociarEventoCreado/{idUsuario}/{idEvento}",method=RequestMethod.POST)
	public ResponseEntity<Usuario> asociarEvento(@PathVariable("idUsuario") String idUsuario, @PathVariable("idEvento") String idEvento){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioImpl.asociarEventoCreado(idUsuario, idEvento));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Método que expone el servicio de asociar evento suscrito a un usuario
	 * @param id del usuario
	 * @param Evento evento a suscibir
	 * @return la entidad usuario
	 */
	@RequestMapping(value="/asociarEventoSuscrito/{idUsuario}/{idEvento}",method=RequestMethod.POST)
	public ResponseEntity<Usuario> asociarEventoSuscrito(@PathVariable("idUsuario") String idUsuario, @PathVariable("idEvento") String idEvento){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioImpl.asociarEventoSuscrito(idUsuario, idEvento	));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Método que expone el servicio de listar eventos disponibles por usuario
	 * @param id del usuario
	 * @return lista de eventos
	 */
//	@RequestMapping(value="/obtenerEventosDisponibles/{id}",method=RequestMethod.POST)
//	public ResponseEntity<Usuario> obtenerEventosDisponibles(@PathVariable("id") String id){
//		try {
//			return ResponseEntity.status(HttpStatus.OK).body(usuarioImpl.obtenerEventosDisponibles(id));
//		}catch(Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//		}
//	}
	
	/**
	 * Metodo que permite asociar tipos de proyectos que le interesan al usuario
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	/*@RequestMapping(value="/asociarTipoProyecto",method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Usuario> asociarTipoProyecto(@RequestBody Usuario usuario) {
		try {
			Usuario usuarioActual = usuarioRepository.findOne(seguridad.currentUser().getId());
			usuarioActual.setTipoProyecto(usuario.getTipoProyecto());
			usuarioActual.setNuevo(false);
			usuarioRepository.save(usuarioActual);
			return ResponseEntity.status(HttpStatus.OK).body(usuarioActual);
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}*/
	
	
}
