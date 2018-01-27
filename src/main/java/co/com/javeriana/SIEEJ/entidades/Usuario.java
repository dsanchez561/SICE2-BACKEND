package co.com.javeriana.SIEEJ.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.javeriana.SIEEJ.enumeracion.TipoProyecto;

/**
 * @author Javeriana
 */
@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"username"})
	)
@Entity
public class Usuario {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String nombre;

    @Basic
    private String apellidos;

    @Basic
    private String username;

    @Basic
    @JsonIgnore
    private String password;
    
    @Basic
    private Boolean nuevo;

    @ElementCollection(targetClass=TipoProyecto.class, fetch=FetchType.EAGER)
    private List<TipoProyecto> tipoProyecto = new ArrayList<>();
  
    /**
	 * @return the nuevo
	 */
	public Boolean getNuevo() {
		return nuevo;
	}

	/**
	 * @param nuevo the nuevo to set
	 */
	public void setNuevo(Boolean nuevo) {
		this.nuevo = nuevo;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the tipoProyecto
	 */
	public List<TipoProyecto> getTipoProyecto() {
		return tipoProyecto;
	}

	/**
	 * @param tipoProyecto the tipoProyecto to set
	 */
	public void setTipoProyecto(List<TipoProyecto> tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}

	
}