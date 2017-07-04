/*
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Entities.Option;
import Entities.Rol;
import SessionBeans.OptionFacadeLocal;
import SessionBeans.RolFacadeLocal;

/**
 *
 * @author BryanV
 */
@ManagedBean
@ViewScoped
public class RolPermisoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Rol rol;
	private Option permiso;

	@EJB
	private RolFacadeLocal tipoUsuarioFacadeLocal;

	@EJB
	private OptionFacadeLocal permisoFacadeLocal;

	private List<Rol> roles;
	private List<Rol> rolesFiltered;

	private Set<Option> permisos;
	private Set<Option> permisosFiltered;

	private Set<Option> permisosSelected;

	private boolean rolSelected;

	public RolPermisoBean() {

	}

	@PostConstruct
	public void inicio() {

		rol = new Rol();
		permiso = new Option();

		roles = tipoUsuarioFacadeLocal.findAll();
		permisos = new HashSet<>();
		permisos.addAll(permisoFacadeLocal.findAll());

	}

	public void buscarPermisos(Rol tipoUsuario) {

		try {

			permisosSelected = new HashSet<>();

			this.rol = (Rol) tipoUsuarioFacadeLocal
					.fetchPermisosByRol(tipoUsuario.getNombreRol());

			if (this.rol != null) {

				permisosSelected.addAll(this.rol.getOptions());
			}

			this.rol = tipoUsuario;
			setRolSelected(true);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public void guardar() {

		if (rolSelected) {

			this.rol.setOptions(permisosSelected);

			try {
				tipoUsuarioFacadeLocal.edit(this.rol);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}

		setRolSelected(false);
		permisosSelected = new HashSet<>();
		rol = new Rol();

	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Option getPermiso() {
		return permiso;
	}

	public void setPermiso(Option permiso) {
		this.permiso = permiso;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Rol> getRolesFiltered() {
		return rolesFiltered;
	}

	public void setRolesFiltered(List<Rol> rolesFiltered) {
		this.rolesFiltered = rolesFiltered;
	}

	public Set<Option> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Option> permisos) {
		this.permisos = permisos;
	}

	public Set<Option> getPermisosFiltered() {
		return permisosFiltered;
	}

	public void setPermisosFiltered(Set<Option> permisosFiltered) {
		this.permisosFiltered = permisosFiltered;
	}

	public Set<Option> getPermisosSelected() {
		return permisosSelected;
	}

	public void setPermisosSelected(Set<Option> permisosSelected) {
		this.permisosSelected = permisosSelected;
	}

	public boolean isRolSelected() {
		return rolSelected;
	}

	public void setRolSelected(boolean rolSelected) {
		this.rolSelected = rolSelected;
	}
	
	

	

}