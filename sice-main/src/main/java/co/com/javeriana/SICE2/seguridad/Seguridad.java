/**
 * 
 */
package co.com.javeriana.SICE2.seguridad;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;

/**
 * @author javeriana
 *
 */
@Component
public class Seguridad {
	
	public UsuarioJaveriana getCurrentUser() {
		try {
			final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				return (UsuarioJaveriana) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			}
			return null;
		} catch (RuntimeException e) {
			System.out.println("Error al acceder al usuario actual");
			return null;
		}
	}

}
