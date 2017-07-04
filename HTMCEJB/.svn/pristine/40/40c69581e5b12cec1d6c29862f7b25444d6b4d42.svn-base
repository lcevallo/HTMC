package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the option database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Option.findAll", query = "SELECT o FROM Option o"),
	@NamedQuery(name = "Option.findByPermiso", query = "SELECT o FROM Option o where o.page = :page") })
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_option")
	private Integer idOption;

	private String description;

	private Boolean estado;

	private String page;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="options")
	private Set<Rol> roles;

	public Option() {
	}

	public Integer getIdOption() {
		return this.idOption;
	}

	public void setIdOption(Integer idOption) {
		this.idOption = idOption;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getPage() {
		return this.page;
	}

	public void setPage(String page) {
		this.page = page;
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
		result = prime * result + ((idOption == null) ? 0 : idOption.hashCode());
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
		Option other = (Option) obj;
		if (idOption == null) {
			if (other.idOption != null)
				return false;
		} else if (!idOption.equals(other.idOption))
			return false;
		return true;
	}

}