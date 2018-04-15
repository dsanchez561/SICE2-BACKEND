/**
 * 
 */
package co.com.javeriana.SICE2.implement;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import co.com.javeriana.SICE2.comandos.mensaje.Mensaje;
import co.com.javeriana.SICE2.enumeracion.TipoDominioEnum;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Dominio;
import co.com.javeriana.SICE2.model.general.Servicio;
import co.com.javeriana.SICE2.repositories.DominioRepository;
import co.com.javeriana.SICE2.repositories.ServicioRepository;
import co.com.javeriana.SICE2.utils.Util;

/**
 * @author Javeriana
 *
 */
@Component
public class DominioImpl {
	
	@Log
	private Logger log;
	
	@Autowired
	private DominioRepository dominioRepository;

	@Autowired
	private ServicioRepository servicioRepository;
	
	public List<Dominio> listarDominiosNacionales(String tipo) {
		try {
			return dominioRepository.findByActivoAndTipoAndNacional(true, TipoDominioEnum.valueOf(tipo),true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	public List<Dominio> listarDominiosInternacionales(String tipo) {
		try {
			return dominioRepository.findByActivoAndTipoAndNacional(true, TipoDominioEnum.valueOf(tipo),false);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	public Mensaje validarImagen(MultipartFile file) {
		Mensaje mensaje=null;
		if(!Util.validarTamImagen(file)) {
//			mensaje = new Mensaje(null, null, null, CodigosError.TAMANIO_IMAGEN_NO_SOPORTADO);
		}
		if(!Util.validarTipoImagen(file)) {
//			mensaje =  new Mensaje(null, null, null, CodigosError.TIPO_IMAGEN_NO_SOPORTADO);
		}
		return mensaje;
	}

	/**
	 * Método que guarda en la base de datos una imagen a un dominio
	 * @param file de la imagen
	 * @param id del inventario
	 * @throws IOException
	 */
	public byte[] uploadImage(Long id) throws IOException {
		return dominioRepository.findById(id).get().getImagen();
	}

	public void downloadImage() {
		try {
			for(Dominio dominio:dominioRepository.findAll()) {
				dominio.setImagen(getImagenUniversidad("imagenes/"+dominio.getNombreArchivo()));
				dominioRepository.save(dominio);
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Método que crea una imagen por defecto
	 * @param ruta de la imagen
	 * @return la imagen creada
	 * @throws IOException excepcion de la imagen
	 */
	public byte[] getImagenUniversidad(final String ruta) throws IOException {
		final ClassPathResource resource = new ClassPathResource(ruta);
	    BufferedImage imageOnDisk = ImageIO.read(resource.getFile());
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imageOnDisk, "png", baos);
        baos.flush();
	    return baos.toByteArray();
	}

	public String obtenerURL(Long id, String nombre) {
		Dominio dominio = dominioRepository.findById(Long.valueOf(id)).get();
		Servicio pagina = servicioRepository.findByDominioAndNombre(dominio, nombre);
		return pagina.getUrl();
	}

}
