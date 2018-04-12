/**
 * 
 */
package co.com.javeriana.SICE2.entidades;

import java.io.Serializable;
import java.util.List;

import co.com.javeriana.SICE2.enumeracion.TipoDatoEnum;



/**
 * Clase que permite definir filtros para ser aplicados a los registros que
 * seran retornados a la GUI
 * 
 * @author WORLD OFFICE
 */
public class FiltroPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String atributo;
	private String valor;
	private TipoFiltro tipoFiltro;
	private TipoDatoEnum tipoDato;
	private String valor2;
	private OperadorEnum operador;
	//Atributo usado para multi select
	private String clase;
	//Atributo usado para multi select
	private List<String> valores;

	/**
	 * 
	 */
	public FiltroPojo() {
	}

	/**
	 * 
	 * @param atributo
	 * @param valor
	 * @param tipoDato
	 * @param tipoFiltro
	 */
	public FiltroPojo(final String atributo, final String valor, final TipoDatoEnum tipoDato,
			final TipoFiltro tipoFiltro, OperadorEnum operador) {
		this.atributo = atributo;
		this.valor = valor;
		this.tipoDato = tipoDato;
		this.tipoFiltro = tipoFiltro;
		this.operador = operador;
	}

	public OperadorEnum getOperador() {
		return operador;
	}

	public void setOperador(OperadorEnum operador) {
		this.operador = operador;
	}

	public String getValor2() {
		return valor2;
	}

	public List<String> getValores() {
		return valores;
	}
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public void setValores(List<String> valores) {
		this.valores = valores;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}

	public TipoDatoEnum getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(TipoDatoEnum tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public TipoFiltro getTipoFiltro() {
		return tipoFiltro;
	}

	public void setTipoFiltro(TipoFiltro tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}

	/**
	 * Enumeración que define los valores validos para aplicar el filtro.
	 * 
	 * @author WORLD OFFICE
	 */
	public enum TipoFiltro {
		IGUAL, CONTIENE, MENOR_QUE, MAYOR_QUE, EMPIEZA_CON, TERMINA_CON, ENTRE;
	}
	
	public enum OperadorEnum {
		AND, OR;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FiltroWo [atributo=" + atributo + ", valor=" + valor + ", tipoFiltro=" + tipoFiltro + ", tipoDato="
				+ tipoDato + ", valor2=" + valor2 + ", operador=" + operador + ", clase=" + clase + ", valores="
				+ valores + "]";
	}

}
