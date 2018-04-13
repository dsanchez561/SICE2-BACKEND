package co.com.javeriana.SICE2.model.general;

import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.javeriana.SICE2.enumeracion.EstadoEnum;

/**
 * @author Javeriana
 */
@SuppressWarnings("serial")
@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"username"})
	)
@Entity
public class UsuarioJaveriana implements UserDetails{

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
    private String email;

    @Basic
    private String password;
    
    @Basic
    private Boolean administrador;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estadoEnum;

    @JsonIgnore
    @OneToMany(targetEntity = Horario.class)
    private List<Horario> horarios;

    @JsonIgnore
    @ManyToMany(mappedBy = "inscritos",fetch = FetchType.EAGER)
    private List<Evento> eventosSuscritos;

    @JsonIgnore
    @OneToMany(mappedBy = "creador",fetch = FetchType.EAGER)
    private List<Evento> eventosCreados;

    @JsonIgnore
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
	 * @return the administrador
	 */
	public Boolean getAdministrador() {
		return administrador;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param administrador the administrador to set
	 */
	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
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
	 * @return the eventosSuscritos
	 */
	public List<Evento> getEventosSuscritos() {
		return eventosSuscritos;
	}

	/**
	 * @param eventosSuscritos the eventosSuscritos to set
	 */
	public void setEventosSuscritos(List<Evento> eventosSuscritos) {
		this.eventosSuscritos = eventosSuscritos;
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

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return false;
	}
}