/**
 * 
 */
package co.com.javeriana.SIEEJ.utils;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 * Clase encargada de procesar las Excepciones generadas por acceso a la Base de
 * Datos.
 * 
 * @author Javeriana
 */
public final class ProcesarExcepcion {

	private static final Logger LOG = Logger.getLogger(ProcesarExcepcion.class);
	
	/**
	 * Constructor privado
	 */
	private ProcesarExcepcion() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Método encargado de procesar la excepción y encontrar la causa raiz de la
	 * excepción para informar al usuario de una manera clara el error ocurrido.
	 * 
	 * @param e
	 *            la expeción ocurrida
	 * @return el objeto <code>PostgreSQLErrorCode</code> que encapsula el codigo de
	 *         error generado por el motor de la Base de Datos
	 */
	public static PostgreSQLErrorCode procesar(final Exception e) {
		final Throwable cause = e.getCause();
		PostgreSQLErrorCode postgreSQLErrorCode = null;

		if (cause instanceof ConstraintViolationException) {
			postgreSQLErrorCode = processPSQLException(((ConstraintViolationException) cause).getSQLException());

		} else if (cause instanceof DataException) {
			postgreSQLErrorCode = processPSQLException(((DataException) cause).getSQLException());

		} else {
			LOG.error("Excepcion no soportada");
		}
		
		return postgreSQLErrorCode;
	}

	/**
	 * Método encargado de procesar la excepción <code>SQLException</code> y
	 * retornar el codigo de error generado por el motor de Base de Datos
	 * 
	 * @param psqlException
	 *            objeto <code>PostgreSQLErrorCode</code> que contiene el codigo del
	 *            error generado por el motor de Base de Datos
	 */
	public static PostgreSQLErrorCode processPSQLException(final SQLException psqlException) {
		LOG.info("Codigo: " + psqlException.getErrorCode());
		LOG.info("SQLSTATE: " + psqlException.getSQLState());
		LOG.info("Mensaje: " + psqlException.getMessage());

		final PostgreSQLErrorCode postgreSQLErrorCode = PostgreSQLErrorCode.valueof(psqlException.getSQLState());
		LOG.info(postgreSQLErrorCode);
		
		return postgreSQLErrorCode;
	}
}