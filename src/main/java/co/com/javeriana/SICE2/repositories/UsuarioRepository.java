/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.entidades.Usuario;


/**
 * @author Javeriana
 *
 */

@Repository(value="Usuario")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findByUsernameAndPassword(String username,String password);
	public Usuario findUsuarioById(Long idUsuario);
	public Usuario findUsuarioByUsername(String username);
}
