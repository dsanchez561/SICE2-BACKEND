package co.com.javeriana.SIEEJ.comandos;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import co.com.javeriana.SIEEJ.enumeracion.TipoDatoEnum;
import co.com.javeriana.SIEEJ.excepciones.ComandoException;

/**
 * 
 * @author Javeriana
 *
 * @param <T> Tipo de la clase sobre la cual se ejecuta el comando
 */
@Component
public abstract class Comando<T> {	

	/**
	 * Multimapa cuya llave es un campo que puede ser modificado por un comando y como valor una accion que se debe ejecutar
	 */
	protected Multimap<String, Accion<T>> acciones = HashMultimap.create();
	
	
	public Comando() {
	}
	
	/**
	 * Metodo que implementa la accion a ejecutar
	 * 
	 * @param mensaje
	 *            Mensaje que debe ser interpretado
	 * @return Retorna una lista de mensajes producto de las acciones
	 */
	public abstract List<Mensaje> ejecutar(JSONObject mensaje);
	
	/**
	 * Metodo encargado de modificar un atributo
	 * 
	 * @param obj
	 *            Objeto que debe ser cambiado
	 * @param mensaje
	 *            Mensaje con el atributo a modificar
	 */
	protected void modificarAtributo(Object obj,JSONObject mensaje){
		final String valorAtr = "valor";
		try {			
			Class<?> clase = obj.getClass();
			String nombAtr = mensaje.getString("atributo");
			Field atr = clase.getDeclaredField(nombAtr);
			atr.setAccessible(true);
			
			TipoDatoEnum tipo = TipoDatoEnum.valueOf(mensaje.getString("tipoDato"));
			Object valor = mensaje.get(valorAtr);
			
			switch (tipo) {
			case BOOLEAN:
				Boolean valorBoolean = mensaje.getBoolean(valorAtr);
				atr.set(obj, valorBoolean);
				break;
				
			case FECHA:
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = dateFormat.parse((String)valor);
				atr.set(obj, fecha);
				break;
				
			case NUMERIC:
				BigDecimal val = new BigDecimal(String.valueOf(valor));
				atr.set(obj, val);
				break;
				
			case STRING:
				atr.set(obj, valor);
				break;
				
			case LONG:
				Long val1 = new Long(String.valueOf(valor));
				atr.set(obj, val1);
				break;
			}
			
		} catch (ParseException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | JSONException | NullPointerException e) {
			throw new ComandoException(e);
		}
	}
	

}
