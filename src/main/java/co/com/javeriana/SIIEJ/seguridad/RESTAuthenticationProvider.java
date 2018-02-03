package co.com.javeriana.SIIEJ.seguridad;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import co.com.javeriana.SIIEJ.entidades.Usuario;
import co.com.javeriana.SIIEJ.repositories.UsuarioRepository;


@CrossOrigin
@Component
public class RESTAuthenticationProvider implements AuthenticationProvider {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UsuarioRepository Usuariorepositorio;

	/**
	 * Metodo que verifica los datos de ingreso del usuario que esta intentando ingresar al sistema
	 * @param Authentication: sesion en la que se va a guardar el usuario en caso de tener un log in exitoso
	 * @return una token de acceso en caso de ser el log in exitoso, de lo contrario null
	 */
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName().trim();
		String password = authentication.getCredentials().toString();
		logger.info("Name = " + name + " ,Password = " + password);
		Usuario usuario = Usuariorepositorio.findByUsernameAndPassword(name, password);
		if (usuario != null && password.equals(usuario.getPassword())) {
			logger.info("Autenticación exitosa!");
			return new UsernamePasswordAuthenticationToken(usuario, usuario.getPassword(), new ArrayList<>());
		} else {
			logger.info("Login fail!");
			return null;
		}
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
