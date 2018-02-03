package co.com.javeriana.SIIEJ.rest;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SIIEJ.entidades.Usuario;
import co.com.javeriana.SIIEJ.log.Log;
import co.com.javeriana.SIIEJ.repositories.UsuarioRepository;
import co.com.javeriana.SIIEJ.seguridad.ConfiguracionSeguridad;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestUsuario {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
