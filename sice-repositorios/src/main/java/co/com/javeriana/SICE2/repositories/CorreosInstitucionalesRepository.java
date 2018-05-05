/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.CorreosInstitucionales;


/**
 * @author Javeriana
 *
 */

@Repository(value="CorreosInstitucionales")
public interface CorreosInstitucionalesRepository extends JpaRepository<CorreosInstitucionales, Long> {
}
