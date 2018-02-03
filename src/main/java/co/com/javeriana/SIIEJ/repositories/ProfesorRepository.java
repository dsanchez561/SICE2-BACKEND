/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Profesor;

/**
 * @author Javeriana
 *
 */
@Repository("Profesor")
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
