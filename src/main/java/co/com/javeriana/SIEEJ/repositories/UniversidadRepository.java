/**
 * 
 */
package co.com.javeriana.SIEEJ.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIEEJ.entidades.Universidad;


/**
 * @author Javeriana
 *
 */

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {
	public List<Universidad> findByactivo(Boolean activo);
}
