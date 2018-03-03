package co.com.javeriana.SICE2.comandos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import co.com.javeriana.SICE2.comandos.mensaje.Comando;
import co.com.javeriana.SICE2.comandos.mensaje.Mensaje;
import co.com.javeriana.SICE2.excepciones.ComandoException;
import co.com.javeriana.SICE2.seguridad.SeguridadInfo;


/**
 * Clase encargada de la creación de cualquier entidad del sistema
 * @author Javeriana
 *
 * @param <T>
 */
@Component("crear")
public class Crear<T> extends Comando<T> {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private Map<String,JpaRepository> repositorios;
	
	public Crear() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mensaje> ejecutar(JSONObject mensaje)  {
		List<Mensaje> mensajes= new ArrayList<>();
		try {
			String clase = mensaje.getString("clase");
			Class<?> clazz = SeguridadInfo.getInstance().getEntidad(clase);
			Object obj = clazz.newInstance();
			obj=repositorios.get(clase).save(obj);
			mensajes.add(new Mensaje(null,"crear",clazz.getSimpleName(), obj));
			return mensajes;
		}catch (JSONException e) {
			throw new ComandoException("Error leyendo el JSON para la creación de la entidad ", e);
		}
		catch (InstantiationException | IllegalAccessException  e) {
			throw new ComandoException("Error creando la entidad ", e);
		}
	}

}
