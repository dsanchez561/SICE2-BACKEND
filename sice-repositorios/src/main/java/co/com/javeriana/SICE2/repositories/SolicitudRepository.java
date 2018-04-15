/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.Solicitud;


/**
 * @author Javeriana
 *
 */

@Repository(value="Solicitud")
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
	List<Solicitud> findByActiva(Boolean activa);
}
