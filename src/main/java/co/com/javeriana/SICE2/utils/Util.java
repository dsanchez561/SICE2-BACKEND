/**
 * 
 */
package co.com.javeriana.SICE2.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.multipart.MultipartFile;

import co.com.javeriana.SICE2.entidades.Evento;

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
