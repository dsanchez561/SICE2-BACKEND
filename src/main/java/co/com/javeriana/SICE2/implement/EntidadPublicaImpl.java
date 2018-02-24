/**
 * 
 */
package co.com.javeriana.SICE2.implement;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.javeriana.SICE2.entidades.EntidadPublica;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.repositories.EntidadPublicaRepository;

/**
 * @author Javeriana
 *
 */
public class EntidadPublicaImpl {

	@Log
	private Logger log;
	
	@Autowired
	private EntidadPublicaRepository entidadPublicaRepository;

	public List<EntidadPublica> listarEntidadesPublicas() {
		try {
			return entidadPublicaRepository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
}
