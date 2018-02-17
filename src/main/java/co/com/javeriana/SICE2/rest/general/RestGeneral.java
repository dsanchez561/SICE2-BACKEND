package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SICE2.entidades.Usuario;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.repositories.UsuarioRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;

@CrossOrigin(allowCredentials="true")
@RestController
public class RestGeneral {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Metodo que permite retornar el usuario que acaba de iniciar sesión
	 * 
	 * @return devuelve el usuario actual en sesión
	 * @throws IOException
	 */
	@RequestMapping(value="/retornarUsuario",method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Usuario> retornarUsuario() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findOne(seguridad.getCurrentUser().getId()));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
