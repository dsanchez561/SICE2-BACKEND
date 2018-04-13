package co.com.javeriana.SICE2.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;


@Service
public class RESTUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioJaverianaRepository usuarioRepository;
	
	@Override
	public UsuarioJaveriana loadUserByUsername(String username) {
		return usuarioRepository.findUsuarioByUsername(username);
	}

}
