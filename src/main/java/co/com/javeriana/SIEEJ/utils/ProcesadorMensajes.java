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
@ComponentScan("co.com.javeriana.SIEEJ.comandos")
public class ProcesadorMensajes {

	/**
	 * Mapa con todas las acciones del sistema
	 */
	@Autowired
	private Map<String, Comando<?>> map;

	/**
	 * Metodo encargado de procesar un mensaje ejecutando el comando asociado
	 * 
	 * @param mensaje
	 *            Mensaje que debe ser procesado
	 * @return Retorna una lista de mensajes de atributos cambiados
	 * @throws JSONException
	 */
	public List<Mensaje> procesarMensaje(final JSONObject mensaje) throws JSONException {
		String accion = null;

		try {
			accion = mensaje.getString("accion");
			return map.get(accion).ejecutar(mensaje);

		} catch (DataIntegrityViolationException e) {
			// Excepción generada por el motor de Base de Datos
			final PostgreSQLErrorCode errorCode = ProcesarExcepcion.procesar(e);
			
			return getMensajeError(mensaje, accion, errorCode != null ? errorCode.getCodigo() : CodigosError.ERROR_004);

		} catch (TransactionSystemException e) {
			return getMensajeError(mensaje, accion, CodigosError.ERROR_003);
		}
	}

	/**
	 * Método encargado de generar el mensaje de error para ser retornado a la capa
	 * de presentación
	 * 
	 * @param mensaje
	 *            objeto mensaje que llega desde la capa de presentación
	 * @param accion
	 *            la acción que se ejecuto
	 * @param errorCode
	 *            codigo del error ocurrido
	 * @return el mensaje construido para notificar a la GUI el error ocurrido
	 * @throws JSONException
	 */
	private List<Mensaje> getMensajeError(final JSONObject mensaje, final String accion, final String errorCode)
			throws JSONException {
		
		final Long id = mensaje.getLong("id");
		final String atributo = mensaje.getString("atributo");
		
		final List<Mensaje> listaMensajes = new ArrayList<>();
		listaMensajes.add(new Mensaje(id, accion, atributo, false, errorCode));
		return listaMensajes;
	}

}
