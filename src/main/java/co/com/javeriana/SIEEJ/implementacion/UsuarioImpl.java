/**
 * 
 */
package co.com.javeriana.SIEEJ.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.javeriana.SIEEJ.entidades.Etiqueta;
import co.com.javeriana.SIEEJ.entidades.Usuario;
import co.com.javeriana.SIEEJ.excepciones.BaseDatosException;
import co.com.javeriana.SIEEJ.repositories.UsuarioRepository;
import co.com.javeriana.SIEEJ.rest.RestUsuario;

/**
 * Clase que implementa la lógica del usuario
 * @author Javeriana
 *
 */
@Component
public class UsuarioImpl {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(RestUsuario.class);

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
			LOG.error(e.getMessage(), e);
			throw new BaseDatosException("Error al asociar etiquetas al usuario",e);
		}
	}

}
