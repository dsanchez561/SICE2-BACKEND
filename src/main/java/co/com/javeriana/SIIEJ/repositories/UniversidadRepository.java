/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Universidad;

/**
 * @author Javeriana
 *
 */
@Repository("Universidad")
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {

}
