/**
 * 
 */
package co.com.javeriana.SICE2.utils;

import java.util.Properties;

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

import org.springframework.stereotype.Component;

import co.com.javeriana.SICE2.model.general.Evento;

/**
 * Clase con utilidades generales del sistema relacionado al sistema de correo
 * 
 * @author Javeriana
 */
@Component
public class ProcesadorSMTP {

	public void emailEventos(String asunto, String destinatario, Evento evento) {
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

			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H3>Querido Usuario</H3>"
					+ "<p>Este mensaje es con el objetivo de notificarle la suscripción del siguiente evento" + "</p>"
					+ "<p> - Nombre del evento      : " + evento.getTitulo() + "</p>"
					+ "<p> - Descripción del evento : " + evento.getDescripcion() + "</p>"
					+ "<p> - Fecha del evento       : " + evento.getInicio() + "</p>"
					+ "<p> - Requisitos del evento  : " + evento.getRequisitos() + "</p>"
					+ "<div><p><b>No responder a este mensaje, para mayor información contactar al administrador de SICE2</b> </p>"
					+ "<img src=\"https://uvirtual.javeriana.edu.co/branding/_1_1/login-2.0/imgs/logo.png\" width=\"300\" height=\"130\"></div>";
			messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Correo Enviado correctamente");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
