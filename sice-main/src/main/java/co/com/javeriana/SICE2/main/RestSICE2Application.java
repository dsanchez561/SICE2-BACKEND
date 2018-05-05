package co.com.javeriana.SICE2.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
@EntityScan("co.com.javeriana.SICE2.model")
@EnableJpaRepositories("co.com.javeriana.SICE2.repositories")
@ComponentScan("co.com.javeriana.SICE2.seguridad")
@ComponentScan("co.com.javeriana.SICE2.implement")
@ComponentScan("co.com.javeriana.SICE2.rest")
@ComponentScan("co.com.javeriana.SICE2.log")
@ComponentScan("co.com.javeriana.SICE2.comandos.general")
@EnableScheduling
public class RestSICE2Application extends SpringBootServletInitializer{

	/*
	 * (non-Javadoc)
	 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestSICE2Application.class);
	}

	/**
	 * Método main de la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestSICE2Application.class, args);
	}
}
