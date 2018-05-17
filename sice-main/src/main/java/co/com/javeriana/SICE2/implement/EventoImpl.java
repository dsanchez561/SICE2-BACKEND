/**
 * 
 */
package co.com.javeriana.SICE2.implement;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;

/**
 * @author Javeriana
 *
 */
@Component
public class EventoImpl {
	
	@Log
	private Logger log;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private UsuarioJaverianaRepository usuarioJaverianaRepository;

	public List<UsuarioJaveriana> listarOrdenadosUsuarios(Long idEvento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
