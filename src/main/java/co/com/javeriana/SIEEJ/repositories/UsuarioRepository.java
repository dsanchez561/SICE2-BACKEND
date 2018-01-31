/**
 * 
 */
package co.com.javeriana.SIEEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIEEJ.entidades.Usuario;


/**
 * @author Javeriana
 *
 */

@Repository("Usuario")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findByUsernameAndPassword(String username,String password);
	public Usuario findUsuarioById(Long idUsuario);
}
