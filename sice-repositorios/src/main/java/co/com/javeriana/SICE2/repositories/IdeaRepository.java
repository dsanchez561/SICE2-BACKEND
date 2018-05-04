/**
 * 
 */
package co.com.javeriana.SICE2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.SICE2.model.general.Idea;


/**
 * @author Javeriana
 *
 */

@Repository(value="Idea")
public interface IdeaRepository extends JpaRepository<Idea, Long> {


}
