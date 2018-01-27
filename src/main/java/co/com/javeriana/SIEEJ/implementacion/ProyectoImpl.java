/**
 * 
 */
package co.com.javeriana.SIEEJ.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.javeriana.SIEEJ.entidades.Proyecto;
import co.com.javeriana.SIEEJ.excepciones.BaseDatosException;
import co.com.javeriana.SIEEJ.repositories.ProyectoRepository;

/**
 * @author Javeriana
 *
 */
@Component
public class ProyectoImpl {
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	public Proyecto crear() {
		try {
			Proyecto proyecto = new Proyecto();
			return proyectoRepository.save(proyecto);
		}catch(Exception e) {
			throw new BaseDatosException("Error al crear un proyecto",e);
		}
	}

	public List<Proyecto> listar() {
		try {
			return proyectoRepository.save(proyectoRepository.findAll());
		}catch(Exception e) {
			throw new BaseDatosException("Error al listar los proyectos",e);
		}
	}

	public void eliminar(String id) {
		try {
			proyectoRepository.delete(Long.valueOf(id));
		}catch(Exception e) {
			throw new BaseDatosException("Error al listar los proyectos",e);
		}
	}
	
}
