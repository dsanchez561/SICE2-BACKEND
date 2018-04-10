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

	public static void emailEventos(String asunto,String destinatario,Evento evento) {
		final String username = "SICE2Javeriana@gmail.com";
		final String password = "SICE2DavidDaniel";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("fromSomeone@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject(asunto);
			message.setText("Querido usuario,"
					+ "\n\nEste mensaje es con el objetivo de notificarle la suscripción del siguiente evento"
					+ "\n\nNombre del evento      : " + evento.getTitulo()
					+ "\nDescripción del evento : " + evento.getDescripcion()
					+ "\nFecha del evento       : " + evento.getInicio()
					+ "\nRequisitos del evento  : " + evento.getRequisitos()
					+ "\n\n\n No responder a este mensaje, para mayor información contactar al administrador de SICE2");

			MimeMultipart multipart = new MimeMultipart("related");
			 // first part (the html)
	         BodyPart messageBodyPart = new MimeBodyPart();
	         String htmlText = "<H3>Querido Usuario</H3><img src=\"cid:image\">";
	         messageBodyPart.setContent(htmlText, "text/html");
	         // add it
	         multipart.addBodyPart(messageBodyPart);

	         // second part (the image)
	         messageBodyPart = new MimeBodyPart();
	         DataSource fds = new FileDataSource(
	            "C:\\Users\\danielsanchez\\git\\SIEEJ\\src\\main\\java\\co\\com\\javeriana\\SICE2\\utils\\UniversidadJaveriana.png");

	         messageBodyPart.setDataHandler(new DataHandler(fds));
	         messageBodyPart.setHeader("Content-ID", "<image>");

	         // add image to the multipart
	         multipart.addBodyPart(messageBodyPart);

	         // put everything together
	         message.setContent(multipart);
			
			Transport.send(message);
			System.out.println("Correo Enviado correctamente");
		}catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static Boolean validarTipoImagen(MultipartFile file) {
		final String contenType = file.getContentType().substring(6);
		return (contenType.equalsIgnoreCase("PNG") || contenType.equalsIgnoreCase("JPEG")
				|| contenType.equalsIgnoreCase("JPG")) ? true : false;
	}

	public static Boolean validarTamImagen(MultipartFile file) {
		return file.getSize() / 1000 < TAM_MAX_IMAGEN ? true : false;

	}

}
