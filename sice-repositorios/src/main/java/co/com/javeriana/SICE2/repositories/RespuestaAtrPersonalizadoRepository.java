/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.AtrPersonalizado;
import co.com.javeriana.SICE2.model.general.RespuestaAtrPersonalizado;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;


/**
 * @author Javeriana
 *
 */
@Repository(value="RespuestaAtrPersonalizado")
public interface RespuestaAtrPersonalizadoRepository extends JpaRepository<RespuestaAtrPersonalizado, Long> {
	public RespuestaAtrPersonalizado findByAtrPersonalizadoAndUsuarioJaveriana(AtrPersonalizado atrPersonalizado,UsuarioJaveriana usuarioJaveriana);
}
