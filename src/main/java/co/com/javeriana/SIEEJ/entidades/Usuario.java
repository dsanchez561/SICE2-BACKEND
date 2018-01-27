package co.com.javeriana.SIEEJ.entidades;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.com.javeriana.SIEEJ.enumeracion.EstadoEnum;

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
    private String password;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estadoEnum;

    @OneToMany(targetEntity = Horario.class)
    private List<Horario> horarios;

    @OneToMany(targetEntity = Evento.class)
    private List<Evento> eventosSuscrito;

    @OneToMany(targetEntity = Evento.class)
    private List<Evento> eventosCreados;

    @ManyToMany(targetEntity = Etiqueta.class)
    private List<Etiqueta> preferencias;

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
	 * @return the estadoEnum
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * @param estadoEnum the estadoEnum to set
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * @return the horarios
	 */
	public List<Horario> getHorarios() {
		return horarios;
	}

	/**
	 * @param horarios the horarios to set
	 */
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	/**
	 * @return the eventosSuscrito
	 */
	public List<Evento> getEventosSuscrito() {
		return eventosSuscrito;
	}

	/**
	 * @param eventosSuscrito the eventosSuscrito to set
	 */
	public void setEventosSuscrito(List<Evento> eventosSuscrito) {
		this.eventosSuscrito = eventosSuscrito;
	}

	/**
	 * @return the eventosCreados
	 */
	public List<Evento> getEventosCreados() {
		return eventosCreados;
	}

	/**
	 * @param eventosCreados the eventosCreados to set
	 */
	public void setEventosCreados(List<Evento> eventosCreados) {
		this.eventosCreados = eventosCreados;
	}

	/**
	 * @return the preferencias
	 */
	public List<Etiqueta> getPreferencias() {
		return preferencias;
	}

	/**
	 * @param preferencias the preferencias to set
	 */
	public void setPreferencias(List<Etiqueta> preferencias) {
		this.preferencias = preferencias;
	}
}