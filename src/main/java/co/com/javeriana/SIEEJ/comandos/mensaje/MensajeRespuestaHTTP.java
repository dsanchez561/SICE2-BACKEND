package co.com.javeriana.SIEEJ.comandos.mensaje;

/**
 * @author WORLD OFFICE
 *
 */
public class MensajeRespuestaHTTP extends Mensaje{


	private String descripcion;
	private org.springframework.http.HttpStatus estado;
	

	/**
	 * @param id
	 * @param accion
	 * @param estado
	 */
	public MensajeRespuestaHTTP(Long id, String descripcion, org.springframework.http.HttpStatus estado) {
		super(id);
		this.descripcion = descripcion;
		this.estado = estado;
	}

	/**
	 * @param id
	 */
	public MensajeRespuestaHTTP(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estado
	 */
	public org.springframework.http.HttpStatus getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(org.springframework.http.HttpStatus estado) {
		this.estado = estado;
	}

}
