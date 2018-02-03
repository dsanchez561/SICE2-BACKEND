package co.com.javeriana.SIIEJ.seguridad;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import org.reflections.Reflections;

/**
 * 
 * @author Javeriana
 */
public class SeguridadInfo {
	
	private Map<String,Class<?>> entidadesSistema = new HashMap<>();

	private static SeguridadInfo instance = new SeguridadInfo();

	/**
	 * 
	 */
	private SeguridadInfo() {
		final Reflections reflections = new Reflections("co.com.javeriana.SIIEJ.entidades");
		llenarMapaEntidadesSistema(reflections);
	}

	/**
	 * @param reflections
	 */
	private void llenarMapaEntidadesSistema(final Reflections reflections) {
		for (Class<?> clazz: reflections.getTypesAnnotatedWith(Entity.class)) {
			entidadesSistema.put(clazz.getSimpleName(), clazz);
		}
	}

	/**
	 * 
	 * @return
	 */
	public static SeguridadInfo getInstance() {
		return instance;
	}


	/**
	 * @return the entidadesSistema
	 */
	public Map<String, Class<?>> getEntidadesSistema() {
		return entidadesSistema;
	}

	/**
	 * @return the entidadesSistema
	 */
	public Class<?> getEntidad(String nombre) {
		return entidadesSistema.get(nombre);
	}

}
