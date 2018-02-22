package co.com.javeriana.SICE2.seguridad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import co.com.javeriana.SICE2.entidades.UsuarioJaveriana;
import co.com.javeriana.SICE2.excepciones.SeguridadException;



@Component
@CrossOrigin
public class RESTLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements
LogoutSuccessHandler {
	
	// Just for setting the default target URL
	public RESTLogoutSuccessHandler() {
	        this.setDefaultTargetUrl("/");
	   }

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException, NullPointerException {
		String targetUrl = determineTargetUrl(request, response);
		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}else {
			if (authentication != null) {
				final UsuarioJaveriana principal = (UsuarioJaveriana) authentication.getPrincipal();
				logger.info("El usuario " + principal.getUsername() + " cerro sesión");
			} else {
				throw new SeguridadException("No hay sesión activa");
			}
		}

		
	}
}
