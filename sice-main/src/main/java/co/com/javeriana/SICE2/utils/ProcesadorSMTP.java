/**
 * 
 */
package co.com.javeriana.SICE2.utils;

import java.util.List;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.com.javeriana.SICE2.model.general.AtrPersonalizado;
import co.com.javeriana.SICE2.model.general.Etiqueta;
import co.com.javeriana.SICE2.model.general.Evento;
import co.com.javeriana.SICE2.model.general.Idea;
import co.com.javeriana.SICE2.model.general.RespuestaAtrPersonalizado;
import co.com.javeriana.SICE2.model.general.Solicitud;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.RespuestaAtrPersonalizadoRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;

/**
 * Clase con utilidades generales del sistema relacionado al sistema de correo
 * 
 * @author Javeriana
 */
@Component
public class ProcesadorSMTP {
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private RespuestaAtrPersonalizadoRepository datoPersonalizadoRepository;
	
	private final String username = "SICE2Javeriana@gmail.com";
	private final String password = "SICE2DavidDaniel";
	private final String firmaCorreo = "<div><p><b>No responder a este mensaje, para mayor información contactar al administrador de SICE2</b> </p>"
			+ "<img src=\"https://uvirtual.javeriana.edu.co/branding/_1_1/login-2.0/imgs/logo.png\" width=\"320\" height=\"130\"></div>";

	public void emailEventos(String asunto, String destinatario, Evento evento) {
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
			UsuarioJaveriana usuario = seguridad.getCurrentUser();
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String text1 = "<H3>Hola "+usuario.getNombre()+"</H3>"
					+ "<p>Este mensaje es con el objetivo de notificarle la suscripción del siguiente evento" + "</p>"
					+ "<p> - Nombre del evento      : " + evento.getTitulo() + "</p>"
					+ "<p> - Descripción del evento : " + evento.getDescripcion() + "</p>"
					+ "<p> - Fecha del evento       : " + evento.getInicio() + "</p>"
					+ "<p> - Requisitos del evento  : " + evento.getRequisitos() + "</p>";
			String text2 = "";
			if (evento.getAtrPersonalizados().size()>0) {
				text2= "<p>Información adicional</p>";
				for (AtrPersonalizado atrPersonalizado: evento.getAtrPersonalizados()) {
					RespuestaAtrPersonalizado datoPersonalizado = datoPersonalizadoRepository.findByAtrPersonalizadoAndUsuarioJaveriana(atrPersonalizado, usuario);
					text2 = text2 +"<p> - "+atrPersonalizado.getNombre()+"  : " + datoPersonalizado.getDato() + "</p>";
				}
			}
			String htmlText = text1+text2+firmaCorreo;
			messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Correo Enviado correctamente");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void emailServicios(String asunto, UsuarioJaveriana usuario, Solicitud solicitud) {
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario.getEmail()));
			message.setSubject(asunto);
			UsuarioJaveriana usuarioSolicitante = seguridad.getCurrentUser();
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H3>Hola "+usuario.getNombre()+"</H3>"
					+ "<p>Este mensaje es con el objetivo de notificarle la solicitud de un nuevo servicio" + "</p>"
					+ "<p>Los datos del estudiante que presenta la solicitud son los siguientes" + "</p>"
					+ "<p> - Nombre completo  : " + usuarioSolicitante.getNombre() + " " + usuarioSolicitante.getApellidos()+ "</p>"
					+ "<p> - Email            : " + usuarioSolicitante.getEmail() + "</p>"
					+ "<p>El servicio que solicita es el siguiente" + "</p>"
					+ "<p> - Nombre           : " + solicitud.getNombre() + "</p>"
					+ "<p> - Descripción      : " + solicitud.getDescripcion() + "</p>"
					+ firmaCorreo;
			messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Correo Enviado correctamente");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void emailCierreSolicitud(String asunto, String motivo, Solicitud solicitud) {
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(solicitud.getCreador().getEmail()));
			message.setSubject(asunto);
			
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H3>Hola "+solicitud.getCreador().getNombre()+"</H3>"
					+ "<p>Este mensaje es con el objetivo de notificarle que la solicitud presentada el "
					+ solicitud.getFecha().getDay()+"/"+ solicitud.getFecha().getMonth()+"/"+ solicitud.getFecha().getYear()
					+ " con el titúlo \"" + solicitud.getNombre() +"\" fue cerrada</p>"
					+ "<p>Motivo de cierre : " + "</p>"
					+ "<p> "+motivo+" </p>"
					+ firmaCorreo;
			messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Correo Enviado correctamente");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void emailNotificarEvento(String asunto, String motivo, UsuarioJaveriana usuario) {
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario.getEmail()));
			message.setSubject(asunto);
			
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H3>Hola "+usuario.getNombre()+"</H3>"
					+ "<p> "+motivo+" </p>"
					+ firmaCorreo;
			messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Correo Enviado correctamente");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void emailNotificarIdea(String asunto, UsuarioJaveriana usuarioInteresado, UsuarioJaveriana usuarioActual,Idea idea,List<Etiqueta> etiquetasCoincidencia) {
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuarioInteresado.getEmail()));
			message.setSubject(asunto);
			
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String etiquetas = "";
			for (Etiqueta etiqueta : etiquetasCoincidencia) {
				etiquetas = etiquetas+"<p> - "+ etiqueta.getNombre()  +"</p>";
			}
			String htmlText = "<H3>Hola "+usuarioInteresado.getNombre()+"</H3>"
					+ "<p> Este correo es con el objetivo de notificarle una nueva idea propuesta por : </p>"
					+ "<p> - Nombre completo       : " + usuarioActual.getNombre() + " " + usuarioActual.getApellidos()+ "</p>"
					+ "<p> - Email                 : " + usuarioActual.getEmail() + "</p>"
					+ "<p>La idea presentada es la siguiente" + "</p>"
					+ "<p> - Título                : " + idea.getTitulo() + "</p>"
					+ "<p> - Descripción           : " + idea.getDescripcion() + "</p>"
					+ "<p>Etiquetas con coincidencia  </p>" 
					+ etiquetas
					+ firmaCorreo;
			messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Correo Enviado correctamente");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Scheduled(fixedRate=86400000)
	public void sendMail() {
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("d-sancheza@javeriana.edu.co"));
			message.setSubject("Correo Periodico");
			
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String etiquetas = "";
			/**
			 * TODO:: Descomentariar lo grande y borrar lo de abajo
			 */
			String htmlText = "";
			/*String htmlText = "<H3>Hola "+usuarioInteresado.getNombre()+"</H3>"
					+ "<p> Este correo es con el objetivo de notificarle una nueva idea propuesta por : </p>"
					+ "<p> - Nombre completo       : " + usuarioActual.getNombre() + " " + usuarioActual.getApellidos()+ "</p>"
					+ "<p> - Email                 : " + usuarioActual.getEmail() + "</p>"
					+ "<p>La idea presentada es la siguiente" + "</p>"
					+ "<p> - Título                : " + idea.getTitulo() + "</p>"
					+ "<p> - Descripción           : " + idea.getDescripcion() + "</p>"
					+ "<p>Etiquetas con coincidencia  </p>" 
					+ etiquetas
					+ firmaCorreo;*/
			messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Correo periodico enviado correctamente");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
