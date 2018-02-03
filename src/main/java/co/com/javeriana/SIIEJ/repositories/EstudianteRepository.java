/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Estudiante;


/**
 * @author Javeriana
 *
 */

@Repository(value="Estudiante")
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
