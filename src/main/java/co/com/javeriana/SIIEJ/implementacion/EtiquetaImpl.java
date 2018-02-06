/**
 * 
 */
package co.com.javeriana.SIIEJ.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.javeriana.SIIEJ.entidades.Etiqueta;
import co.com.javeriana.SIIEJ.excepciones.BaseDatosException;
import co.com.javeriana.SIIEJ.repositories.EtiquetaRepository;

/**
 * Clase que implementa las operaciones relacionadas con Etiqueta
 * @author Javeriana
 *
 */
@Component
public class EtiquetaImpl{
	
	@Autowired
	private EtiquetaRepository etiquetaRepository;

	/**
	 * Método que consulta las etiquetas
	 * @return la lista de etiquetas
	 */
	public List<Etiqueta> listar() {
		try {
			return etiquetaRepository.findAll();
		}catch(Exception e) {
			throw new BaseDatosException("Error al listar etiquetas", e);
		}
	}
	
	
}
