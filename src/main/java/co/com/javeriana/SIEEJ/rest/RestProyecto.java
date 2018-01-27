/**
 * 
 */
package co.com.javeriana.SIEEJ.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SIEEJ.entidades.Proyecto;
import co.com.javeriana.SIEEJ.implementacion.ProyectoImpl;

/**
 * @author Javeriana
 *
 */
@RestController
@CrossOrigin
@RequestMapping("proyecto")
public class RestProyecto {

	private static final Logger LOG = LoggerFactory.getLogger(RestUsuario.class);
	
	@Autowired
	private ProyectoImpl proyectoImpl;
	
	@RequestMapping(value="/crear",method=RequestMethod.POST ,produces="applicacion/json")
	public ResponseEntity<Proyecto> crear(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(proyectoImpl.crear());
		}catch(Exception e) {
			LOG.error(e.getMessage(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@RequestMapping(value="/listar",method=RequestMethod.POST ,produces="applicacion/json")
	public ResponseEntity<List<Proyecto>> listar(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(proyectoImpl.listar());
		}catch(Exception e) {
			LOG.error(e.getMessage(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@RequestMapping(value="/eliminar/{id}",method=RequestMethod.POST)
	public ResponseEntity<Boolean> eliminar(@PathVariable("id") String id){
		try {
			proyectoImpl.eliminar(id);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}catch(Exception e) {
			LOG.error(e.getMessage(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
		}
	}
	
}
