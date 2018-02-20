/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.entidades.Universidad;


/**
 * @author Javeriana
 *
 */

@Repository(value="Universidad")
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {
	public List<Universidad> findByactivo(Boolean activo);
}
