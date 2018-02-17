/**
 * 
 */
package co.com.javeriana.SICE2.comandos;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.javeriana.SICE2.comandos.mensaje.Comando;
import co.com.javeriana.SICE2.comandos.mensaje.Mensaje;
import co.com.javeriana.SICE2.constantes.CodigosError;
import co.com.javeriana.SICE2.entidades.Universidad;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.repositories.UniversidadRepository;

/**
 * @author Javeriana
 *
 */
@Component("editarUniversidad")
public class EditarUniversidad extends Comando<Universidad> {
	
	@Autowired
	private UniversidadRepository universidadRepository;
	
	@Log
	private Logger log;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Mensaje> ejecutar(JSONObject mensaje) {
		Long id = null;
		String atributo = null;
		List<Mensaje> mensajesRespuesta = new ArrayList<>();
		try {
			id = mensaje.getLong("id");
			atributo = mensaje.getString("atributo");
			Universidad obj = universidadRepository.findOne(id);
			modificarAtributo(obj, mensaje);
			universidadRepository.save(obj);
		}catch (JSONException e) {
			log.error(e.getMessage(), e);
			mensajesRespuesta.add(new Mensaje(id, "editarUniversidad" , atributo , false , CodigosError.ERROR_001));
		}
		return mensajesRespuesta;		
	}

}
