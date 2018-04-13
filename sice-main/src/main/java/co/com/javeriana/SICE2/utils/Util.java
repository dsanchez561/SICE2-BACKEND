/**
 * 
 */
package co.com.javeriana.SICE2.utils;

import org.springframework.web.multipart.MultipartFile;

/**
 * Clase con utilidades generales del sistema
 * 
 * @author Javeriana
 */
public final class Util {

	public static final Long TAM_MAX_IMAGEN = 500L; // tamaño en kb

	public static Boolean validarTipoImagen(MultipartFile file) {
		final String contenType = file.getContentType().substring(6);
		return (contenType.equalsIgnoreCase("PNG") || contenType.equalsIgnoreCase("JPEG")
				|| contenType.equalsIgnoreCase("JPG")) ? true : false;
	}

	public static Boolean validarTamImagen(MultipartFile file) {
		return file.getSize() / 1000 < TAM_MAX_IMAGEN ? true : false;

	}

}
