package co.com.javeriana.SICE2.rest.general;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.AtrPersonalizado;
import co.com.javeriana.SICE2.model.general.Evento;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.pojo.DatoAtrPersonalizadoPorUsuarioPojo;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.RespuestaAtrPersonalizadoRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestDatoPersonalizado {	
	@Log
	private Logger log;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private UsuarioJaverianaRepository usuarioRepository;
	
	@Autowired
	private RespuestaAtrPersonalizadoRepository datoPersonalizadoRepository;
	
	private static String SINPERMISOS = "No tiene permisos para acceder a esta funcionalidad";

	
	/**
	 * Metodo que permite guardar los datos personalizados a la hora de inscribirse a un evento
	 * 
	 * @return devuelve el estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarDatosPersonalizadosPorUsuario/{idEvento}/{idUsuario}",method=RequestMethod.GET)
	public ResponseEntity<List<DatoAtrPersonalizadoPorUsuarioPojo>> guardarDatosPersonalizados(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idEvento") Long idEvento) {
		if (seguridad.getCurrentUser().getAdministrador()) {
			try {
				List<DatoAtrPersonalizadoPorUsuarioPojo> datosPojo = new ArrayList<>();
				
				UsuarioJaveriana usuarioJaveriana = usuarioRepository.findById(idUsuario).get();
				Evento evento = eventoRepository.findById(idEvento).get();
				for (AtrPersonalizado atr : evento.getAtrPersonalizados()) {
					DatoAtrPersonalizadoPorUsuarioPojo datoPojo = new DatoAtrPersonalizadoPorUsuarioPojo();
					datoPojo.setRespuestaAtrPersonalizado(datoPersonalizadoRepository.findByAtrPersonalizadoAndUsuarioJaveriana(atr, usuarioJaveriana).getDato());
					datoPojo.setNombreAtrPersonalizado(atr.getDescripcion());
					datosPojo.add(datoPojo);
				}
				return ResponseEntity.status(HttpStatus.OK).body(datosPojo);
			}catch (Exception e) {
				log.error(e.getMessage(), e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else {
			throw new SeguridadException(SINPERMISOS);
		}
	}
}
