package co.com.javeriana.SICE2.comandos.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.javeriana.SICE2.comandos.mensaje.Comando;
import co.com.javeriana.SICE2.comandos.mensaje.Mensaje;
import co.com.javeriana.SICE2.excepciones.ComandoException;


/**
 * Clase encargada de la creación de cualquier entidad del sistema
 * @author Javeriana
 *
 * @param <T>
 */
@Component("eliminar")
public class Eliminar<T> extends Comando<T> {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private Map<String,JpaRepository> repositorios;
	
	public Eliminar() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Mensaje> ejecutar(JSONObject mensaje)  {
		List<Mensaje> mensajes= new ArrayList<>();
		try {
			String clase = mensaje.getString("clase");
			Long id = mensaje.getLong("id");
			repositorios.get(clase).deleteById(id);
			mensajes.add(new Mensaje(id,"eliminar",clase, null));
			return mensajes;
		}catch (JSONException e) {
			throw new ComandoException("Error leyendo el JSON para la eliminación de la entidad ", e);
		}
	}

}
