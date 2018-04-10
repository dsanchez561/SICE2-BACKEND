package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.mail.smtp.SMTPTransport;

import co.com.javeriana.SICE2.entidades.UsuarioJaveriana;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.repositories.UsuarioRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
import co.com.javeriana.SICE2.utils.Util;

@CrossOrigin(allowCredentials="true")
@RestController
public class RestGeneral {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Metodo que permite retornar el usuario que acaba de iniciar sesión
	 * 
	 * @return devuelve el usuario actual en sesión
	 * @throws IOException
	 */
	@RequestMapping(value="/retornarUsuario",method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<UsuarioJaveriana> retornarUsuario() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findOne(seguridad.getCurrentUser().getId()));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
