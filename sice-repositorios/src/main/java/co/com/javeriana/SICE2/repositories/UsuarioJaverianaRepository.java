/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;


/**
 * @author Javeriana
 *
 */

@Repository(value="UsuarioJaveriana")
public interface UsuarioJaverianaRepository extends JpaRepository<UsuarioJaveriana, Long> {
	public UsuarioJaveriana findByUsernameAndPassword(String username,String password);
	public UsuarioJaveriana findUsuarioById(Long idUsuario);
	public UsuarioJaveriana findUsuarioByUsername(String username);
}
