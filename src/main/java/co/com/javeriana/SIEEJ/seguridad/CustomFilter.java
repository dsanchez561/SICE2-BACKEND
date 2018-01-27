package co.com.javeriana.SIEEJ.seguridad;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Component
public class CustomFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ConfiguracionSeguridad seguridad;
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	logger.info("Init::called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Principal userPrincipal = request.getUserPrincipal();
        logger.info(seguridad.getCurrentUser().getUsername()+"::"+userPrincipal);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    	logger.info("Destroy::called");

    }
}
