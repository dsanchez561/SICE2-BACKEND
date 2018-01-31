package co.com.javeriana.SIEEJ.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("co.com.javeriana.sieej.entidades")
@EnableJpaRepositories("co.com.javeriana.sieej.repositories")
@ComponentScan("co.com.javeriana.sieej.seguridad")
@ComponentScan("co.com.javeriana.sieej.impl")
@ComponentScan("co.com.javeriana.sieej.rest")
@ComponentScan("co.com.javeriana.sieej.log")
public class SieejApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		   return application.sources(SieejApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SieejApplication.class, args);
	}
}
