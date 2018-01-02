package co.com.javeriana.SIEEJ.seguridad;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;

import co.com.javeriana.SIEEJ.entidades.Usuario;


@EnableWebSecurity
@Configuration
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RESTAuthenticationProvider authenticationProvider;
	
	@Autowired
	private RESTAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private RESTLogoutSuccessHandler logoutSuccessHandler;
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

       httpSecurity
        		.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
        		.and()
        		.csrf().disable()  // TODO Activar CSRF más adelante
        		.exceptionHandling()
					.authenticationEntryPoint(authenticationEntryPoint)
				.and()
					.authorizeRequests()
						.antMatchers("/public/**", "/login/**").permitAll()
						.anyRequest().authenticated()
				.and()
					.formLogin()
						.successHandler(authenticationSuccessHandler)
						.failureHandler(new SimpleUrlAuthenticationFailureHandler())
				.and()
					.logout()
						.logoutSuccessHandler(logoutSuccessHandler);
                //.antMatchers("**/rest/*")
                //.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)

    }
       
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info(auth.toString());
			auth.authenticationProvider(authenticationProvider);
	}
	
	/**
	 * Metodo que permite obtener el nombre del usuario guardado en la sesion
	 * @return nombre del usuario
	 */
	/* public String currentUserName() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 if (!(authentication instanceof AnonymousAuthenticationToken)) {
			 Usuario user = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		     String currentUserName = user.getEmail();
		     return currentUserName;
		 }
		 return null;
	 }
	 */
	 /**
		 * Metodo que permite obtener el usuario guardado en la sesion
		 * @return usuario en la sesion
		 */
	 public Usuario currentUser() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 if (!(authentication instanceof AnonymousAuthenticationToken)) {
			 return (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 }
		 return null;
	 }
	 
	 /**
		 * Metodo que permite verificar el permiso del usuario
		 * @param String: permiso que se desea verificar con respecto a los permisos que tiene el usuario en sesion
		 * @return booleano verdadero si tiene permiso, de lo contrario es false
		 */
   /* public boolean verificaPermiso(String permiso) {
    	List<URD> urds= urdRepository.findByUsuario(this.currentUser());
		for (int i=0;i<urds.size();i++) {
			List<Permiso> permisos = urds.get(i).getRol().getPermisos();
			for (int j=0;j<permisos.size();j++) {
				if(urds.get(i).getRol().getPermisos().get(j).getCadena().equals(permiso)) {	
					return true;
				}
			}
		}
		return false;
    }
		*/
    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }
}
