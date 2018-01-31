/**
 * 
 */
package co.com.javeriana.SIEEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIEEJ.entidades.Proyecto;

/**
 * @author Javeriana
 *
 */
@Repository("Proyecto")
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}
