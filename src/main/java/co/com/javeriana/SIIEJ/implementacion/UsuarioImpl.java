/**
 * 
 */
package co.com.javeriana.SIIEJ.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.javeriana.SIIEJ.entidades.Etiqueta;
import co.com.javeriana.SIIEJ.entidades.Usuario;
import co.com.javeriana.SIIEJ.excepciones.BaseDatosException;
import co.com.javeriana.SIIEJ.log.Log;
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

	/**
	 * Método que asocia las etiquetas a un usuario
	 * @param id
	 * @param etiquetas
	 * @return
	 */
	public Usuario asociarEtiquetas(String id, List<Etiqueta> etiquetas) {
		try {
			Usuario usuario = usuarioRepository.findOne(Long.valueOf(id));
			usuario.setPreferencias(null);
			usuario.setPreferencias(etiquetas);
			return usuarioRepository.save(usuario);
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new BaseDatosException("Error al asociar etiquetas al usuario",e);
		}
	}
	
}
