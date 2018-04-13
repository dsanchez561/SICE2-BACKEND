/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.Evento;


/**
 * @author Javeriana
 *
 */

@Repository(value="Evento")
public interface EventoRepository extends JpaRepository<Evento, Long> {
	
}
