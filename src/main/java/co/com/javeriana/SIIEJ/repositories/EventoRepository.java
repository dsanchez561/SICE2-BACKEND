/**
 * 
 */
package co.com.javeriana.SIIEJ.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SIIEJ.entidades.Evento;
import co.com.javeriana.SIIEJ.entidades.Usuario;

/**
 * @author Javeriana
 *
 */
@Repository("Evento")
public interface EventoRepository extends JpaRepository<Evento, Long> {

	List<Evento> findByUsuarioCreadorNot(Usuario usuarioCreador);

}
