/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Etiqueta;

/**
 * @author Javeriana
 *
 */
@Repository("Etiqueta")
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {

}
