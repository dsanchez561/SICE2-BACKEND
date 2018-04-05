package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SICE2.entidades.Evento;
import co.com.javeriana.SICE2.entidades.UsuarioJaveriana;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.repositories.UsuarioRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestUsuario {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/**
	 * Metodo que permite listar los eventos a los que esta suscrito el usuario actual
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarEventosPorUsuario",method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<List<Evento>> asociarTipoProyecto() {
		try {
			UsuarioJaveriana usuarioActual = usuarioRepository.findOne(seguridad.getCurrentUser().getId());
			return ResponseEntity.status(HttpStatus.OK).body(usuarioActual.getEventosSuscritos());
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
}
