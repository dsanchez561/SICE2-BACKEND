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
import co.com.javeriana.SICE2.entidades.Universidad;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.repositories.UniversidadRepository;
import co.com.javeriana.SICE2.utils.Util;

/**
 * @author Javeriana
 *
 */
@Component
public class UniversidadImpl {
	
	@Log
	private Logger log;
	
	@Autowired
	private UniversidadRepository universidadRepository;
	
	public List<Universidad> listarUniversidades() {
		try {
			return universidadRepository.findAll();
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
	 * Método que guarda en la base de datos una imagen a un inventario
	 * @param file de la imagen
	 * @param id del inventario
	 * @throws IOException
	 */
	public void uploadImage(MultipartFile file, Long id) throws IOException {
		Universidad universidad = universidadRepository.findOne(id);
		universidad.setImagen(file.getBytes());
		universidadRepository.save(universidad);
	}

	public void downloadImage(String id) {
		try {
			Universidad universidad = universidadRepository.findOne(Long.valueOf(id));
			universidad.setImagen(getImagenUniversidad("imagenes/"+universidad.getNombreArchivo()));
			universidadRepository.save(universidad);
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

}
