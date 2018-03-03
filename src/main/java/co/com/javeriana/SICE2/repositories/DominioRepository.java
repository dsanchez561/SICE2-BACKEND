/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.entidades.Dominio;
import co.com.javeriana.SICE2.enumeracion.TipoDominioEnum;


/**
 * @author Javeriana
 *
 */

@Repository(value="Dominio")
public interface DominioRepository extends JpaRepository<Dominio, Long> {
	public List<Dominio> findByActivoAndTipoAndNacional(Boolean activo,TipoDominioEnum tipo,Boolean nacional);
}
