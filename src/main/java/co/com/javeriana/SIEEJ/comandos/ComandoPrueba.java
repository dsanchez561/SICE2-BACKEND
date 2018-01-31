/**
 * 
 */
package co.com.javeriana.SIEEJ.comandos;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.javeriana.SIEEJ.entidades.Usuario;


/**
 * PRUEBA PRUEBA PRUEBA PRUEBA
 * @author Javeriana
 *
 */
@Component("asociarDocMovInvCentroCosto")
class ComandoPrueba extends Comando<Usuario> {

	
	
	/*
	 * (non-Javadoc)
	 * @see co.com.worldoffice.wo.comandos.Comando#ejecutar(org.json.JSONObject)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Mensaje> ejecutar(JSONObject mensaje) {

		List<Mensaje> mensajesRespuesta = new ArrayList<>();
		
		return mensajesRespuesta;
	}
}
