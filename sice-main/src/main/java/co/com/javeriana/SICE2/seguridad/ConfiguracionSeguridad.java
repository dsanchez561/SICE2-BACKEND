package co.com.javeriana.SICE2.seguridad;

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
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;




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
        		.cors().and()
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
       
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.applyPermitDefaultValues();
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info(auth.toString());
			auth.authenticationProvider(authenticationProvider);
	}
	
	/**
	 * Metodo que permite obtener el usuario guardado en la sesion
	 * 
	 * @return usuario en la sesion
	 */
	public UsuarioJaveriana getCurrentUser() {
		try {
			final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				return (UsuarioJaveriana) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			}
			return null;
		}catch(RuntimeException e){
			throw new SeguridadException("Error al acceder al usuario actual");	
		}
	}
	 /**
	 * Metodo que permite verificar si el usuario es administrador
	 * @return booleano verdadero si es admnistrador, de lo contrario es false
	 */
   public boolean isAdministrador() {
    	return this.getCurrentUser().getAdministrador();
    }
		
	
    @Bean
    public FiltroSeguridad filtroSeguridad() {
        return new FiltroSeguridad();
    }
}
