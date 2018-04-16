/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.AtrPersonalizado;
import co.com.javeriana.SICE2.model.general.DatoPersonalizado;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;


/**
 * @author Javeriana
 *
 */
@Repository(value="DatoPersonalizado")
public interface DatoPersonalizadoRepository extends JpaRepository<DatoPersonalizado, Long> {
	public DatoPersonalizado findByAtrPersonalizadoAndUsuarioJaveriana(AtrPersonalizado atrPersonalizado,UsuarioJaveriana usuarioJaveriana);
}
