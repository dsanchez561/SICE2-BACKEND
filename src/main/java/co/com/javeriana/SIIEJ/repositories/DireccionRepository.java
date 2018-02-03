/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Direccion;

/**
 * @author Javeriana
 *
 */
@Repository("Direccion")
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
