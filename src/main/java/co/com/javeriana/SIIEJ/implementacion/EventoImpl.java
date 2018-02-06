/**
 * 
 */
package co.com.javeriana.SIIEJ.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.javeriana.SIIEJ.entidades.Etiqueta;
import co.com.javeriana.SIIEJ.entidades.Evento;
import co.com.javeriana.SIIEJ.entidades.Usuario;
import co.com.javeriana.SIIEJ.excepciones.BaseDatosException;
import co.com.javeriana.SIIEJ.log.Log;
import co.com.javeriana.SIIEJ.repositories.EventoRepository;

/**
 * @author Javeriana
 *
 */
@Component
public class EventoImpl {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Log
	private Logger log;

	/**
	 * Método que asocia las etiquetas a un usuario
	 * @param id
	 * @param etiquetas
	 * @return
	 */
	public Evento asociarEtiquetas(String id, List<Etiqueta> etiquetas) {
		try {
			Evento evento = eventoRepository.findOne(Long.valueOf(id));
			evento.setEtiquetas(etiquetas);
			return eventoRepository.save(evento);
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new BaseDatosException("Error al asociar etiquetas al evento",e);
		}
	}

	/**
	 * Método que consulta los usuarios suscritos
	 * @param id del evento
	 * @return lista de usuarios suscritos
	 */
	public List<Usuario> obtenerSuscritos(String id) {
		try {
			return eventoRepository.findOne(Long.valueOf(id)).getUsuariosSuscritos();
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new BaseDatosException("Error al asociar etiquetas al evento",e);
		}
	}

}
