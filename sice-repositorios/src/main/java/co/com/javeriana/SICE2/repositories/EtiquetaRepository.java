/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.Etiqueta;


/**
 * @author Javeriana
 *
 */

@Repository(value="Etiqueta")
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
	public Etiqueta findEtiquetaByNombre(String nombre);

}
