/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.javeriana.SICE2.model.general.Dominio;
import co.com.javeriana.SICE2.model.general.Servicio;

/**
 * @author Javeriana
 *
 */
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

	Servicio findByDominioAndNombre(Dominio dominio, String pagina);
	
}
