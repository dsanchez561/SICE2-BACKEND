/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.javeriana.SICE2.entidades.Dominio;
import co.com.javeriana.SICE2.entidades.Servicio;

/**
 * @author Javeriana
 *
 */
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

	Servicio findByDominioAndNombre(Dominio dominio, String pagina);
	
}
