/**
 * 
 */
package co.com.javeriana.SIEEJ.comando.mensajes;

/**
 * @author Javeriana
 *
 */
public class MensajeDocumento extends Mensaje{
	
	/**
	 * @param id
	 * @param accion
	 * @param atributo
	 * @param valor
	 */
	public MensajeDocumento(Long id, String accion, String atributo, Object valor) {
		super(id, accion, atributo , valor);
	}

}
