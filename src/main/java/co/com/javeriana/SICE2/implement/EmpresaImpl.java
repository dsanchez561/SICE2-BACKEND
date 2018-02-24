/**
 * 
 */
package co.com.javeriana.SICE2.implement;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.javeriana.SICE2.entidades.Empresa;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.repositories.EmpresaRepository;

/**
 * @author Javeriana
 *
 */
public class EmpresaImpl {
	
	@Log
	private Logger log;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public List<Empresa> listarEmpresas() {
		try {
			return empresaRepository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

}
