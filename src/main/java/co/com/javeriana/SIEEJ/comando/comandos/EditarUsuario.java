/**
 * 
 */
package co.com.javeriana.SIEEJ.comando.comandos;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.javeriana.SIEEJ.comando.mensajes.Mensaje;
import co.com.javeriana.SIEEJ.constantes.CodigosError;
import co.com.javeriana.SIEEJ.entidades.Usuario;
import co.com.javeriana.SIEEJ.excepciones.ComandoException;
import co.com.javeriana.SIEEJ.log.Log;
import co.com.javeriana.SIEEJ.repositories.UsuarioRepository;

/**
 * @author Javeriana
 *
 */
@Component("editarUsuario")
public class EditarUsuario extends Comando<Usuario> {

	@Autowired
	private UsuarioRepository usuariorep;
	
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
			Usuario obj = usuariorep.findOne(id);
			modificarAtributo(obj, mensaje);
			usuariorep.save(obj);
		}catch (JSONException e) {
			log.error(e.getMessage(), e);
			Mensaje men = new Mensaje(id, "editarUsuario" , atributo , false, CodigosError.ERROR_001);
			mensajesRespuesta.add(men);
		}catch (ComandoException e) {
			log.error(e.getMessage(), e);
			Mensaje men = new Mensaje(id, "editarUsuario" , atributo , false , CodigosError.ERROR_002);
			mensajesRespuesta.add(men);
		}
		return mensajesRespuesta; 
	}

}
