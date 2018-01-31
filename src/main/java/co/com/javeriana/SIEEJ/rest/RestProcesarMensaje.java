package co.com.javeriana.SIEEJ.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SIEEJ.comandos.mensaje.Mensaje;
import co.com.worldoffice.wo.excepciones.SeguridadException;
import co.com.worldoffice.wo.log.Log;
import co.com.worldoffice.wo.seguridad.permisos.Seguridad;
import co.com.worldoffice.wo.utils.ProcesadorMensajes;

/**
 * Clase encargada de exponer servicio REST asociado a Cola_de_mensajes
 * 
 * @author Javeriana
 */
@CrossOrigin
@RestController
@ComponentScan("co.com.worldoffice.wo.utils")
public class RestProcesarMensaje {
	@Log
	private Logger log;
	/**
	 * El procesador de los mensajes
	 */
	@Autowired
	private ProcesadorMensajes procesador;

	@Autowired
	private Seguridad seguridad;
 
	/**
	 * Metodo encargado de procesar una cola de mensajes para documentos
	 * 
	 * @param mensajeStr
	 *            La cola de mensajes para procesar con formato JSON
	 * @return Retorna una lista de respuestas de los atributos modificados
	 */
	@RequestMapping(value="/mensaje",method=RequestMethod.POST,consumes="text/plain",produces="application/json")
	public ResponseEntity<Object> procesarMensaje(@RequestBody String mensajeStr){	
		final List<Mensaje> response = new ArrayList<>();
		try {
			final JSONArray colaMensajes = new JSONArray(mensajeStr);
			for (int i = 0; i < colaMensajes.length(); i++) {
				final JSONObject mensaje = colaMensajes.getJSONObject(i);
				if(seguridad.getCurrentUser().isSuperAdministrador() || seguridad.verificaPermisoFino(mensaje)) {
					log.info(mensaje.toString());
					
					final List<Mensaje> obj = procesador.procesarMensaje(mensaje);
					response.addAll(obj);
				}else {
					throw new SeguridadException("No tiene permisos finos");
				}
			}
	
				return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (SeguridadException e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

}

