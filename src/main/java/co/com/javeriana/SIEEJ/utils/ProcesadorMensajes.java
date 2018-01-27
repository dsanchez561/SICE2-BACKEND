/**
 * 
 */
package co.com.javeriana.SIEEJ.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionSystemException;

import co.com.javeriana.SIEEJ.comandos.Comando;
import co.com.javeriana.SIEEJ.comandos.Mensaje;

/**
 * Clase encargada de procesar un mensaje
 * 
 * @author Javeriana
 */
@Component
@ComponentScan("co.com.javeriana.sieej.comandos")
public class ProcesadorMensajes {

	/**
	 * Mapa con todas las acciones del sistema
	 */
	@Autowired
	private Map<String,Comando<?>> map;	
	
	/**
	 * Metodo encargado de procesar un mensaje ejecutando el comando asociado
	 * 
	 * @param mensaje
	 *            Mensaje que debe ser procesado
	 * @return Retorna una lista de mensajes de atributos cambiados
	 * @throws JSONException 
	 */
	public List<Mensaje> procesarMensaje(JSONObject mensaje) throws JSONException {
		String accion = null;
		try {
			accion = mensaje.getString("accion");
			return map.get(accion).ejecutar(mensaje);
		} catch (DataIntegrityViolationException e) {
			Long id = mensaje.getLong("id");
			String atributo = mensaje.getString("atributo");
			List<Mensaje> listaMensajes = new ArrayList<>();
			listaMensajes.add(new Mensaje(id, accion, atributo, false, CodigosError.ERROR_004));
			return listaMensajes;
		} catch (TransactionSystemException e) {
			Long id = mensaje.getLong("id");
			String atributo = mensaje.getString("atributo");
			List<Mensaje> listaMensajes = new ArrayList<>();
			listaMensajes.add(new Mensaje(id, accion, atributo, false, CodigosError.ERROR_003));
			return listaMensajes;
		}
	}

}
