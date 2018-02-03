package co.com.javeriana.SIIEJ.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("co.com.javeriana.siiej.entidades")
@EnableJpaRepositories("co.com.javeriana.siiej.repositories")
@ComponentScan("co.com.javeriana.siiej.seguridad")
@ComponentScan("co.com.javeriana.siiej.rest")
@ComponentScan("co.com.javeriana.siiej.log")
@ComponentScan("co.com.javeriana.siiej.implementacion")
public class SiiejApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiiejApplication.class, args);
	}
}
