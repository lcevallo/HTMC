package Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Usuario.findByUserCode", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
		@NamedQuery(name = "Usuario.findUser", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario and u.clave = :clave"),
		@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u") })
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	private String usuario;

	private String apellido;

	private String clave;

	private Boolean estado;

	private String nombre;

	@Column(name = "rol_activo")
	private String rolActivo;

	// bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(name = "usuario_rol", joinColumns = { @JoinColumn(name = "fk_usuario") }, inverseJoinColumns = { @JoinColumn(name = "fk_rol") })
	private Set<Rol> roles;
	
	@OneToMany(mappedBy="usuario")
	private List<ItemMaxMin> itemMaxMins;

	public Usuario() {

		this.estado = true;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRolActivo() {
		return this.rolActivo;
	}

	public void setRolActivo(String rolActivo) {
		this.rolActivo = rolActivo;
	}

	public Set<Rol> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Rol> rols) {
		this.roles = rols;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	public List<ItemMaxMin> getItemMaxMins() {
		return this.itemMaxMins;
	}

	public void setItemMaxMins(List<ItemMaxMin> itemMaxMins) {
		this.itemMaxMins = itemMaxMins;
	}

	public ItemMaxMin addItemMaxMin(ItemMaxMin itemMaxMin) {
		getItemMaxMins().add(itemMaxMin);
		itemMaxMin.setUsuario(this);

		return itemMaxMin;
	}

	public ItemMaxMin removeItemMaxMin(ItemMaxMin itemMaxMin) {
		getItemMaxMins().remove(itemMaxMin);
		itemMaxMin.setUsuario(null);

		return itemMaxMin;
	}

}