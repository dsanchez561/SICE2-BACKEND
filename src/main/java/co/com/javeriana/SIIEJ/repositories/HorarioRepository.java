/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Horario;

/**
 * @author Javeriana
 *
 */
@Repository("Horario")
public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
