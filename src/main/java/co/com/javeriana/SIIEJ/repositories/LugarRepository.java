/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Lugar;

/**
 * @author Javeriana
 *
 */
@Repository("Lugar")
public interface LugarRepository extends JpaRepository<Lugar, Long> {

}
