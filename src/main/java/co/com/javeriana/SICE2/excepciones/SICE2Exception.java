/**
 * 
 */
package co.com.javeriana.SICE2.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author WORLD OFFICE
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public abstract class SICE2Exception extends RuntimeException{
	
	public SICE2Exception(String message, Throwable cause) {
		super(message, cause);
	}

	public SICE2Exception(String message) {
		super(message);
	}

	public SICE2Exception(Throwable cause) {
		super(cause);
	}
}
