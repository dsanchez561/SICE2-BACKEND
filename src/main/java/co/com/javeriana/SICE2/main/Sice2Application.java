package co.com.javeriana.SICE2.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("co.com.javeriana.sice2.entidades")
@EnableJpaRepositories("co.com.javeriana.sice2.repositories")
@ComponentScan("co.com.javeriana.sice2.seguridad")
@ComponentScan("co.com.javeriana.sice2.rest")
@ComponentScan("co.com.javeriana.sice2.log")
@ComponentScan("co.com.javeriana.sice2.implement")
@ComponentScan("co.com.javeriana.sice2.comandos")
public class Sice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sice2Application.class, args);
	}
}
