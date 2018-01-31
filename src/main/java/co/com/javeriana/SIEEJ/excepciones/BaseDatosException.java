/**
 * 
 */

package co.com.javeriana.SIEEJ.excepciones;

/**
 * Excepción personalizada que será lanzada para enmascarar los errores
 * generados en el acceso a la Base de Datos.
 * 
 * @author Javeriana
 */
@SuppressWarnings("serial")
public class BaseDatosException extends SIEEJException{

	public BaseDatosException(String message) {
		super(message);
	}
	
	public BaseDatosException(Throwable cause) {
		super(cause);
	}
	
	public BaseDatosException(String message, Throwable cause) {
		super(message, cause);
	}

}
