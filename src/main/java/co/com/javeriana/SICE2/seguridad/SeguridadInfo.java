package co.com.javeriana.SICE2.seguridad;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import org.reflections.Reflections;

/**
 * Clase Singleton que contiene información de las entidades del sistema que han
 * sido marcadas con la anotación de Seguridad.
 * 
 * @author Javeriana
 */
public class SeguridadInfo {

	private static SeguridadInfo instance = new SeguridadInfo();

	/** Mapa que contiene las clases para todas las entidades del sistema */
	private Map<String,Class<?>> entidadesSistema;

	/**
	 * Método constructor privado
	 */
	private SeguridadInfo() {
		final Reflections reflections = new Reflections("co.com.javeriana.SICE2.entidades");
		llenarMapas(reflections);
	}

	/**
	 * Método encargado de llenar el mapa de las entidades del sistema y el
	 * subconjunto de ellas que han sido marcadas con la anotación de seguridad
	 * 
	 * @param reflections
	 *            Objeto <code>Reflections</code> creado sobre el paquete que
	 *            contiene las entidades
	 */
	private void llenarMapas(final Reflections reflections) {
		entidadesSistema = new HashMap<>();
		for (Class<?> clazz: reflections.getTypesAnnotatedWith(Entity.class)) {
			entidadesSistema.put(clazz.getSimpleName(), clazz);
		}
	}

	/**
	 * Retorna la unica instancia de la clase <code>SeguridadInfo</code> que existe
	 * en el sistema
	 * 
	 * @return la instancia
	 */
	public static SeguridadInfo getInstance() {
		return instance;
	}

	/**
	 * Retorna la clase para la entidad cuyo nombre ha sido pasado por parametro
	 * 
	 * @param nombreEntidad
	 *            el nombre simple de la entidad
	 * @return La clase para esta entidad
	 */
	public Class<?> getEntidad(String nombreEntidad) {
		return entidadesSistema.get(nombreEntidad);
	}
}
