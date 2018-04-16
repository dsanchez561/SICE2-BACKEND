/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.AtrPersonalizado;


/**
 * @author Javeriana
 *
 */

@Repository(value="AtrPersonalizado")
public interface AtrPersonalizadoRepository extends JpaRepository<AtrPersonalizado, Long> {
	
}
