/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Usuario;


/**
 * @author Javeriana
 *
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findByUsernameAndPassword(String username,String password);
	public Usuario findUsuarioById(Long idUsuario);
}
