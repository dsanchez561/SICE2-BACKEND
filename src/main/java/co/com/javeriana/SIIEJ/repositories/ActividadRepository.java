/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Actividad;

/**
 * @author Javeriana
 *
 */
@Repository("Actividad")
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

}
