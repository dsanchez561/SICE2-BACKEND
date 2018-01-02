package co.com.javeriana.SIEEJ.rest;

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

import co.com.javeriana.SIEEJ.entidades.Usuario;
import co.com.javeriana.SIEEJ.repositories.UsuarioRepository;
import co.com.javeriana.SIEEJ.seguridad.ConfiguracionSeguridad;

@CrossOrigin(allowCredentials="true")
@RestController
public class RestUsuario {	

	private static final Logger LOG = LoggerFactory.getLogger(RestUsuario.class);
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Metodo que permite listar los usuarios
	 * 
	 * @return devuelve el usuario actual en sesión
	 * @throws IOException
	 */
	@RequestMapping(value="/retornarUsuario",method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Usuario> retornarUsuario() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findOne(seguridad.currentUser().getId()));
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite asociar tipos de proyectos que le interesan al usuario
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/asociarTipoProyecto",method=RequestMethod.POST, consumes="application/json")
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
	}
	
	
}
