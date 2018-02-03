/**
 * 
 */
package co.com.javeriana.SIIEJ.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.javeriana.SIIEJ.entidades.Etiqueta;
import co.com.javeriana.SIIEJ.entidades.Evento;
import co.com.javeriana.SIIEJ.entidades.Usuario;
import co.com.javeriana.SIIEJ.excepciones.BaseDatosException;
import co.com.javeriana.SIIEJ.log.Log;
import co.com.javeriana.SIIEJ.repositories.EventoRepository;
import co.com.javeriana.SIIEJ.repositories.UsuarioRepository;

/**
 * @author Javeriana
 *
 */
@Component
public class UsuarioImpl {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Log
	private Logger log;
	
	@Autowired
	private EventoRepository eventoRepository;

	/**
	 * Método que asocia las etiquetas a un usuario
	 * @param id
	 * @param etiquetas
	 * @return
	 */
	public Usuario asociarEtiquetas(String id, List<Etiqueta> etiquetas) {
		try {
			Usuario usuario = usuarioRepository.findOne(Long.valueOf(id));
			usuario.setPreferencias(etiquetas);
			return usuarioRepository.save(usuario);
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new BaseDatosException("Error al asociar etiquetas al usuario",e);
		}
	}

	public Usuario asociarEventoCreado(String idUsuario, String idEvento) {
		try {
			Usuario usuario = usuarioRepository.findOne(Long.valueOf(idUsuario));
			Evento eventoAsociar = eventoRepository.findOne(Long.valueOf(idEvento));
			usuario.getEventosCreados().add(eventoAsociar);
			eventoAsociar.setUsuarioCreador(usuario);
			eventoRepository.save(eventoAsociar);
			return usuarioRepository.save(usuario);
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new BaseDatosException("Error al asociar un evento creado al usuario",e);
		}
	}

	public Usuario asociarEventoSuscrito(String idUsuario, String idEvento) {
		try {
			Usuario usuario = usuarioRepository.findOne(Long.valueOf(idUsuario));
			Evento eventoSuscribir = eventoRepository.findOne(Long.valueOf(idEvento));
			if(!usuario.getEventosSuscritos().contains(eventoSuscribir)) {
				usuario.getEventosSuscritos().add(eventoSuscribir);
				eventoSuscribir.getUsuariosSuscritos().add(usuario);
				eventoRepository.save(eventoSuscribir);
			}
			return usuarioRepository.save(usuario);
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new BaseDatosException("Error al asociar un evento suscrito al usuario",e);
		}
	}

//	public List<Evento> obtenerEventosDisponibles(String id) {
//		try {
//			return usuarioRepository.
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//			throw new BaseDatosException("Error al asociar un evento al usuario",e);
//		}
//	}
	
}
