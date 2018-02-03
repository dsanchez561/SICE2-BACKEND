/**
 * 
 */
package co.com.javeriana.SIIEJ.comando.comandos;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.javeriana.SIIEJ.comando.mensajes.Mensaje;
import co.com.javeriana.SIIEJ.constantes.CodigosError;
import co.com.javeriana.SIIEJ.entidades.Evento;
import co.com.javeriana.SIIEJ.excepciones.ComandoException;
import co.com.javeriana.SIIEJ.log.Log;
import co.com.javeriana.SIIEJ.repositories.EventoRepository;

/**
 * @author Javeriana
 *
 */
@Component("editarEvento")
public class EditarEvento extends Comando<Evento>{
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Log
	private Logger log;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Mensaje> ejecutar(JSONObject mensaje) {
		List<Mensaje> mensajesRespuesta = new ArrayList<>();
		Long id = null;
		String atributo = null;
		try {
			id = mensaje.getLong("id");
			atributo = mensaje.getString("atributo");
			Evento obj = eventoRepository.findOne(id);
			modificarAtributo(obj, mensaje);
			eventoRepository.save(obj);
		}catch (JSONException e) {
			log.error(e.getMessage(), e);
			Mensaje men = new Mensaje(id, "editarEvento" , atributo , false, CodigosError.ERROR_001);
			mensajesRespuesta.add(men);
		}catch (ComandoException e) {
			log.error(e.getMessage(), e);
			Mensaje men = new Mensaje(id, "editarEvento" , atributo , false , CodigosError.ERROR_002);
			mensajesRespuesta.add(men);
		}
		return mensajesRespuesta; 
	}
	
}
