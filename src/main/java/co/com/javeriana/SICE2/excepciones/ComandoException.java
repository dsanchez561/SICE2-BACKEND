package co.com.javeriana.SICE2.excepciones;



/**
 * Excepción personalizada que será lanzada para enmascarar los errores
 * generados en la ejecución de los comandos.
 * 
 * @author Javeriana
 */
@SuppressWarnings("serial")
public class ComandoException extends SIEEJException {

	public ComandoException(String message) {
		super(message);
	}

	public ComandoException(Throwable cause) {
		super(cause);
	}
	
	public ComandoException(String message, Throwable cause) {
		super(message, cause);
	}

}
