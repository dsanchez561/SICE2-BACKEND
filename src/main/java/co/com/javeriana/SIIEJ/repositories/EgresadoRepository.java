/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Egresado;

/**
 * @author Javeriana
 *
 */
@Repository("Egresado")
public interface EgresadoRepository extends JpaRepository<Egresado, Long> {

}
