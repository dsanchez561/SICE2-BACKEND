/**
 * This file was generated by the Jeddict
 */
package co.com.javeriana.SICE2.pojo;

import java.util.List;

import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;

/**
 * @author Javeriana
 */
public class NotificacionEventoPojo {

    private List<UsuarioJaveriana> usuario;

    private String asunto;
    
    private String descripcion;

	/**
	 * @return the usuario
	 */
	public List<UsuarioJaveriana> getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(List<UsuarioJaveriana> usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
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
}