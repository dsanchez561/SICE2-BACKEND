/**
 * 
 */
package co.com.javeriana.SIEEJ.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase encargada de administrar las excepciones generadas cuando el usuario no tiene permisos para acceder a cierta funcionalidad.
 * @author Javeriana
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class SeguridadException extends SIEEJException {

	public SeguridadException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeguridadException(String message) {
		super(message);
	}

	public SeguridadException(Throwable cause) {
		super(cause);
	}
}
