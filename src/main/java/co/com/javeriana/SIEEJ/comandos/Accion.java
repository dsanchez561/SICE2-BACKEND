/**
 * 
 */
package co.com.javeriana.SIEEJ.comandos;

/**
 * @author Javeriana
 * Interfaz de una accion que debe ser realizada al cambiar un atributo
 */
@FunctionalInterface
public interface Accion<T> {
	/**
	 * 
	 * @param T Entidad sobre la cual se realiza la accion
	 * @return Un mensaje con el cambio realizado
	 */
	public Mensaje ejecutar(T clase);
	
}
