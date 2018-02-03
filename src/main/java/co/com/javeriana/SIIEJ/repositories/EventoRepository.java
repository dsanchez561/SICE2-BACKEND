/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Evento;

/**
 * @author Javeriana
 *
 */
@Repository("Evento")
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
