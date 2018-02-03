/**
 * 
 */
package co.com.javeriana.SIIEJ.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author WORLD OFFICE
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public abstract class SIIEJException extends RuntimeException{
	
	public SIIEJException(String message, Throwable cause) {
		super(message, cause);
	}

	public SIIEJException(String message) {
		super(message);
	}

	public SIIEJException(Throwable cause) {
		super(cause);
	}
}
