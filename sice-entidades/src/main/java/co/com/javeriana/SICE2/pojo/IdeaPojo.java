/**
 * This file was generated by the Jeddict
 */
package co.com.javeriana.SICE2.pojo;

import java.util.List;

import co.com.javeriana.SICE2.model.general.Etiqueta;

/**
 * @author Javeriana
 */
public class IdeaPojo {

    private String descripcion;

    private String nombre;
    
    private String etapa;
    
    private List<Etiqueta> etiquetas;

	/**
	 * @return the etapa
	 */
	public String getEtapa() {
		return etapa;
	}

	/**
	 * @param etapa the etapa to set
	 */
	public void setEtapa(String etapa) {
		this.etapa = etapa;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the etiquetas
	 */
	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	/**
	 * @param etiquetas the etiquetas to set
	 */
	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	
}