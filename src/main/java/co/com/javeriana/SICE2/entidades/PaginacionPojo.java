/**
 * 
 */
package co.com.javeriana.SICE2.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * POJO que permite transportar la información relativa a la paginación y los
 * filtros para ser aplicados a los registros que serán mostrados en la GUI.
 * 
 * @author Javeriana
 */
public class PaginacionPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer pagina;
	private Integer registrosPagina = 5;
	private String columnaOrdenar;
	private DireccionOrdenamiento orden;
	private List<FiltroPojo> filtros;
	
	/**
	 * @return the pagina
	 */
	public Integer getPagina() {
		return pagina;
	}

	/**
	 * @param pagina
	 *            the pagina to set
	 */
	public PaginacionPojo setPagina(Integer pagina) {
		this.pagina = pagina;
		return this;
	}

	/**
	 * @return the registrosPagina
	 */
	public Integer getRegistrosPagina() {
		return registrosPagina;
	}

	/**
	 * @param registrosPagina
	 *            the registrosPagina to set
	 */
	public PaginacionPojo setRegistrosPagina(Integer registrosPagina) {
		this.registrosPagina = registrosPagina;
		return this;
	}

	/**
	 * @return the columnaOrdenar
	 */
	public String getColumnaOrdenar() {
		return columnaOrdenar;
	}

	/**
	 * @param columnaOrdenar
	 *            the columnaOrdenar to set
	 */
	public PaginacionPojo setColumnaOrdenar(String columnaOrdenar) {
		this.columnaOrdenar = columnaOrdenar;
		return this;
	}

	/**
	 * @return the orden
	 */
	public DireccionOrdenamiento getOrden() {
		return orden;
	}

	/**
	 * @param orden
	 *            the orden to set
	 */
	public PaginacionPojo setOrden(DireccionOrdenamiento orden) {
		this.orden = orden;
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<FiltroPojo> getFiltros() {
		return filtros;
	}

	/**
	 * 
	 * @param filtros
	 */
	public void setFiltros(List<FiltroPojo> filtros) {
		this.filtros = filtros;
	}

	/**
	 * Enumeración que define los valores validos para aplicar el ordenamiento.
	 * 
	 * @author WORLD OFFICE
	 */
	public enum DireccionOrdenamiento {
		ASC, DESC
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaginacionWo [pagina=" + pagina + ", registrosPagina=" + registrosPagina + ", columnaOrdenar="
				+ columnaOrdenar + ", orden=" + orden + ", filtros=" + filtros + "]";
	}
}