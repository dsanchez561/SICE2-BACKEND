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
import co.com.javeriana.SIIEJ.entidades.Actividad;
import co.com.javeriana.SIIEJ.excepciones.ComandoException;
import co.com.javeriana.SIIEJ.log.Log;
import co.com.javeriana.SIIEJ.repositories.ActividadRepository;

/**
 * @author Javeriana
 *
 */
@Component("editarActividad")
public class EditarActividad extends Comando<Actividad> {
	
	@Log
	private Logger log;
	
	@Autowired
	private ActividadRepository actividadRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Mensaje> ejecutar(JSONObject mensaje) {
		List<Mensaje> mensajesRespuesta = new ArrayList<>();
		Long id = null;
		String atributo = null;
		try {
			id = mensaje.getLong("id");
			atributo = mensaje.getString("atributo");
			Actividad obj = actividadRepository.findOne(id);
			modificarAtributo(obj, mensaje);
			actividadRepository.save(obj);
		}catch (JSONException e) {
			log.error(e.getMessage(), e);
			Mensaje men = new Mensaje(id, "editarActividad" , atributo , false, CodigosError.ERROR_001);
			mensajesRespuesta.add(men);
		}catch (ComandoException e) {
			log.error(e.getMessage(), e);
			Mensaje men = new Mensaje(id, "editarActividad" , atributo , false , CodigosError.ERROR_002);
			mensajesRespuesta.add(men);
		}
		return mensajesRespuesta; 
	}

}
