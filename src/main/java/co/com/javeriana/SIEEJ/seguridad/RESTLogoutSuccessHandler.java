package co.com.javeriana.SIEEJ.seguridad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import co.com.javeriana.SIEEJ.entidades.Usuario;


@Component
@CrossOrigin
public class RESTLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements
LogoutSuccessHandler {

	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	// Just for setting the default target URL
	public RESTLogoutSuccessHandler() {
	        this.setDefaultTargetUrl("/");
	   }

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException, NullPointerException {
		Usuario u = (Usuario)authentication.getPrincipal();
		String targetUrl = determineTargetUrl(request, response);
		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}else {
			logger.info("El usuario "+u.getUsername()+" cerro sesión");
			response.sendError(HttpServletResponse.SC_OK, "Se ha cerrado la sesión de "+u.getUsername());
		}

		
	}
}
