package co.com.javeriana.SICE2.utils;

/**
 * Enumeración que define los codigos de error retornados por el motor de
 * PostgreSQL. La tabla completa de codigos de error para PostgreSQL pueden ser
 * encontrados en:
 * https://www.postgresql.org/docs/9.2/static/errcodes-appendix.html
 * 
 * @author Javeriana
 */
public enum PostgreSQLErrorCode {
	// Class 22 — Data Exception
	STRING_DATA_RIGHT_TRUNCATION("22001"),

	// Class 23 — Integrity Constraint Violation
	NOT_NULL_VIOLATION("23502"), 
	FOREIGN_KEY_VIOLATION("23503"), 
	UNIQUE_VIOLATION("23505");

	/** Codigo de error propio de la Base de Datos */
	private String codigo;

	/**
	 * Metodo constructor de la enumeración
	 */
	private PostgreSQLErrorCode(final String erroCode) {
		this.codigo = erroCode;
	}

	/**
	 * Metodo que retorna el codigo de error
	 * 
	 * @return el codigo de error
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que obtiene el valor de la enumeración a partir del codigo sql
	 * 
	 * @param sqlState
	 *            codigo de error SQL generado por el motor de PostgreSQL
	 * @return la enumeración que corresponde al codigo de error.
	 */
	public static PostgreSQLErrorCode valueof(final String sqlState) {
		for (PostgreSQLErrorCode value : values()) {
			if (value.getCodigo().equals(sqlState)) {
				return value;
			}
		}

		return null;
	}
}
