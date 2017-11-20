package co.com.javeriana.SIEEJ.seguridad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@CrossOrigin
@Component
public class CustomFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ConfiguracionSeguridad seguridad;
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init::called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("doFilter::called");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Principal userPrincipal = request.getUserPrincipal();
      //  logger.info(seguridad.currentUserName()+"::"+userPrincipal);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy::called");

    }
}
