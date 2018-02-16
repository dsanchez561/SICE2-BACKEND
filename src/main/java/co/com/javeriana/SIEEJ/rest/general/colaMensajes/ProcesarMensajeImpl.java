/**
 * 
 */
package co.com.javeriana.SIEEJ.rest.general.colaMensajes;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import co.com.javeriana.SIEEJ.comandos.mensaje.Mensaje;
import co.com.javeriana.SIEEJ.log.Log;
import co.com.javeriana.SIEEJ.utils.ProcesadorMensajes;

/**
 * @author Javeriana
 *
 */
@Component
public class ProcesarMensajeImpl {
	
	@Log
	private Logger log;
	
	/**
	 * El procesador de los mensajes
	 */
	@Autowired
	private ProcesadorMensajes procesador;
	
	/**
	 * Metodo encargado de procesar una cola de mensajes para documentos
	 * 
	 * @param mensajeStr
	 *            La cola de mensajes para procesar con formato JSON
	 * @return Retorna una lista de respuestas de los atributos modificados
	 * @throws JSONException 
	 */
	public List<Mensaje> procesarMensaje(String mensajes) throws JSONException{	
		
		final List<Mensaje> response = new ArrayList<>();
		final JSONArray colaMensajes = new JSONArray(mensajes);
		
		for (int i = 0; i < colaMensajes.length(); i++) {
			final JSONObject mensaje = colaMensajes.getJSONObject(i);
			log.info(mensaje.toString());
			final List<Mensaje> obj = procesador.procesarMensaje(mensaje);
			response.addAll(obj);
		}

		return response;

	}
}
