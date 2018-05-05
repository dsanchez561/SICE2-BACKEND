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

import co.com.javeriana.SICE2.excepciones.SeguridadException;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Etiqueta;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.EtiquetaRepository;
import co.com.javeriana.SICE2.repositories.UsuarioJaverianaRepository;
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;


@CrossOrigin(allowCredentials="true")
@RestController
public class RestEtiqueta {	
	@Log
	private Logger log;
	
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	@Autowired
	private UsuarioJaverianaRepository usuarioRepository;
	
	/**
	 * Metodo que permite listar las etiquetas del sistema
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarEtiquetas",method=RequestMethod.GET)
	public ResponseEntity<List<Etiqueta>> asociarTipoProyecto() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(etiquetaRepository.findAll());
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Metodo que permite listar las etiquetas del usuario administrador logueado
	 * 
	 * @return devuelve la estado del servidor
	 * @throws IOException
	 */
	@RequestMapping(value="/listarEtiquetasPropias",method=RequestMethod.GET)
	public ResponseEntity<List<Etiqueta>> listarEtiquetasPropias() {
		try {
			if (seguridad.isAdministrador()) {
				UsuarioJaveriana usuarioActual = usuarioRepository.findById(seguridad.getCurrentUser().getId()).get();
				return ResponseEntity.status(HttpStatus.OK).body(usuarioActual.getPreferencias());
			}else {
				throw new SeguridadException("No tiene permisos para acceder a esta funcionalidad");
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
