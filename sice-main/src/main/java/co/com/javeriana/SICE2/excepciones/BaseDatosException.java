/**
 * 
 */

package co.com.javeriana.SICE2.excepciones;

/**
 * Excepción personalizada que será lanzada para enmascarar los errores
 * generados en el acceso a la Base de Datos.
 * 
 * @author WORLD OFFICE
 */
@SuppressWarnings("serial")
public class BaseDatosException extends SICE2Exception{

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
