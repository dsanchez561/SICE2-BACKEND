/**
 * 
 */
package co.com.javeriana.SICE2.comandos.general;

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
import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Dominio;
import co.com.javeriana.SICE2.repositories.DominioRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;

/**
 * @author Javeriana
 *
 */
@Component("editarDominio")
public class EditarDominio extends Comando<Dominio> {
	
	@Autowired
	private DominioRepository dominioRepository;
	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Mensaje> ejecutar(JSONObject mensaje) {
		Long id = null;
		String atributo = null;
		List<Mensaje> mensajesRespuesta = new ArrayList<>();
		try {
			id = mensaje.getLong("id");
			atributo = mensaje.getString("atributo");
			Dominio obj = dominioRepository.findById(id).get();
			if (seguridad.isAdministrador() ||seguridad.getCurrentUser().getId()==obj.getIdUsuarioCreador()) {	
				modificarAtributo(obj, mensaje);
				dominioRepository.save(obj);
			}else {
				throw new SeguridadException("No tiene permisos para acceder a esta funcionalidad");
			}
		}catch (JSONException e) {
			log.error(e.getMessage(), e);
			mensajesRespuesta.add(new Mensaje(id, "editarDominio" , atributo , false , CodigosError.ERROR_001));
		}
		return mensajesRespuesta;		
	}

}
