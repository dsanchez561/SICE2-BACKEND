/**
 * 
 */
package co.com.javeriana.SIIEJ.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SIIEJ.entidades.Etiqueta;
import co.com.javeriana.SIIEJ.entidades.Evento;
import co.com.javeriana.SIIEJ.implementacion.EventoImpl;

/**
 * @author Javeriana
 *
 */

@CrossOrigin
@RestController
@RequestMapping("evento")
public class RestEvento {
	
	@Autowired
	private EventoImpl eventoImpl;
	
	/**
	 * Método que expone el servicio de asociar etiquetas a un evento
	 * @param id del evento
	 * @param etiquetas lista de etiquetas
	 * @return la entidad evento
	 */
	@RequestMapping(value="/asociarEtiquetas/{id}",method=RequestMethod.POST)
	public ResponseEntity<Evento> asociarEtiquetas(@PathVariable("id") String id, @RequestBody List<Etiqueta> etiquetas){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(eventoImpl.asociarEtiquetas(id, etiquetas));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
