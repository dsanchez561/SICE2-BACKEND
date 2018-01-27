package co.com.javeriana.SIEEJ.seguridad;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import co.com.javeriana.SIEEJ.entidades.Usuario;

@CrossOrigin
@Component
public class FiltroSeguridad implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ConfiguracionSeguridad seguridad;
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	logger.info("Inicio");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        parametrosLogger(servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
	 * @param servletRequest
	 */
	private void parametrosLogger(ServletRequest servletRequest) {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final Usuario currentUser = seguridad.getCurrentUser();
		
        MDC.put("IP Cliente", request.getRemoteAddr());
        MDC.put("Servidor", servletRequest.getServerName());
		MDC.put("Usuario", currentUser != null ? currentUser.getUsername() : "");
	}
	
    @Override
    public void destroy() {
    	logger.info("Fin");

    }
}
