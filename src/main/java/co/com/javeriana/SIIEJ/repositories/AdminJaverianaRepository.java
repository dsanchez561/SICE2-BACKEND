/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.AdminJaveriana;

/**
 * @author Javeriana
 *
 */
@Repository("AdminJaveriana")
public interface AdminJaverianaRepository extends JpaRepository<AdminJaveriana, Long> {

}
