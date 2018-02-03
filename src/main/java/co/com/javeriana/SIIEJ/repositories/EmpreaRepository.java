/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Empresa;

/**
 * @author Javeriana
 *
 */
@Repository("Empresa")
public interface EmpreaRepository extends JpaRepository<Empresa, Long> {

}
