/**
 * 
 */
package co.com.javeriana.SIEEJ.comandos;

/**
 * @author Javeriana
 *
 */
public class Mensaje {
	
	private Long id;
	private String accion;
	private String atributo;
	private Object valor;
	private String codError;
	
	public Mensaje(Long id, String accion, String atributo, Object valor) {
		super();
		this.id = id;
		this.accion = accion;
		this.atributo = atributo;
		this.valor = valor;
		this.codError = "";
	}
	
	public Mensaje(Long id, String accion, String atributo, Object valor, String codError) {
		super();
		this.id = id;
		this.accion = accion;
		this.atributo = atributo;
		this.valor = valor;
		this.codError = codError;
	}
	
	
	public Mensaje(Long id) {
		super();
		this.id = id;
	}
	public Mensaje() {

	}
	/**
	 * @return the id
	 */ 
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}
	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}
	/**
	 * @return the atributo
	 */
	public String getAtributo() {
		return atributo;
	}
	/**
	 * @param atributo the atributo to set
	 */
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	/**
	 * @return the valor
	 */
	public Object getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Object valor) {
		this.valor = valor;
	}

	public String getCodError() {
		return codError;
	}

	public void setCodError(String codError) {
		this.codError = codError;
	}
}