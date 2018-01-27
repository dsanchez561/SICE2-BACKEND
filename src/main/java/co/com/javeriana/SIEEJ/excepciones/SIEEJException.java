/**
 * 
 */
package co.com.javeriana.SIEEJ.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author WORLD OFFICE
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public abstract class SIEEJException extends RuntimeException{
	
	public SIEEJException(String message, Throwable cause) {
		super(message, cause);
	}

	public SIEEJException(String message) {
		super(message);
	}

	public SIEEJException(Throwable cause) {
		super(cause);
	}
}
