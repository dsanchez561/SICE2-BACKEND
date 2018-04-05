package co.com.javeriana.SICE2.main;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import co.com.javeriana.SICE2.implement.DominioImpl;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.seguridad.SeguridadInfo;


/**
 * Clase Singleton encargada de ejecutar logica requerida al iniciar la
 * aplicación.
 * 
 * @author Javeriana
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StartUpInit {
    
	@Log
	private static Logger log;
	
	@Autowired
	private DominioImpl dominioImpl;

	/**
	 * Método encargado de ejecutar los procesos que deben ser procesados al
	 * desplegar la aplicación
	 */
	@PostConstruct
	public void init() {
		cargarImagenes();
		initSeguridadInfo();
	}
	
	/**
	 * Método encargado de cargar las imagenes del sistema en la Base de Datos.
	 */
	private void cargarImagenes() {
		log.info("Inicia la carga de las imagenes del sistema en la Base de Datos");
		dominioImpl.downloadImage();
		log.info("Finaliza la carga de las imagenes del sistemas en la Base de Datos");
	}
	
	/**
	 * Inicializa el objeto Seguridad Info
	 */
	private void initSeguridadInfo() {
		// Carga las entidades del sistema por Reflexion y las registra en un Map
		SeguridadInfo.getInstance();
	}
}
