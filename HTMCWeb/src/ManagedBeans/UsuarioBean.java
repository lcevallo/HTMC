/*
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import Entities.Usuario;
import SessionBeans.UsuarioFacadeLocal;
import Utility.StringMD5;

/**
 *
 * @author BryanV
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioFacadeLocal usuarioFacadeLocal;

	private Usuario usuario;

	private List<Usuario> usuarios;

	private List<Usuario> usuariosFiltered;

	private boolean editMode;

	private String actualPassword;
	private String newPassword;
	private String newMatchPassword;

	public UsuarioBean() {

	}

	@PostConstruct
	public void inicio() {

		editMode = false;

		usuario = new Usuario();

		usuarios = usuarioFacadeLocal.findAll();

	}

	public void removeUser(Usuario usuario) {

		usuarios.remove(usuario);

		try {
			if (usuarioFacadeLocal.find(usuario.getUsuario()) != null) {
				usuario.setEstado(false);
				usuarioFacadeLocal.edit(usuario);
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

	}

	public void addUser() {

		String message = null;

		try {

			if (isEditMode()) {

				usuarioFacadeLocal.edit(usuario);
				message = "El usuario '" + usuario.getUsuario() + "' ha sido editado";

				editMode = false;

			} else {

				message = "El usuario '" + usuario.getUsuario() + "' ya existe";

				if (usuarioFacadeLocal.find(usuario.getUsuario()) == null) {					
					
					usuarios.add(0, usuario);
					usuario.setClave(StringMD5.getStringMessageDigest(usuario.getClave(), StringMD5.MD5));
					usuarioFacadeLocal.create(usuario);					
					message = "El usuario '" + usuario.getUsuario() + "' ha sido creado";

				}
			}

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		FacesMessage mensaje = new FacesMessage(message, null);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);

		usuario = new Usuario();

		usuarios = usuarioFacadeLocal.findAll();

		RequestContext.getCurrentInstance().reset("form:usuarioSelected");

	}

	public void editRow(Usuario usuario) {

		RequestContext.getCurrentInstance().reset("form:usuarioSelected");

		this.usuario = usuario;

		editMode = true;

	}

	public void changePassword() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		Usuario userInSession = new Usuario();
		userInSession = (Usuario) session.getAttribute("userInSession");

		if (StringMD5.getStringMessageDigest(actualPassword, "MD5").equals(userInSession.getClave())) {
			userInSession.setClave(StringMD5.getStringMessageDigest(newPassword, "MD5"));
			try {
				usuarioFacadeLocal.edit(userInSession);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseņa cambiada correctamente", null));
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseņa actual no es correcta", null));

		}

	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosFiltered() {
		return usuariosFiltered;
	}

	public void setUsuariosFiltered(List<Usuario> usuariosFiltered) {
		this.usuariosFiltered = usuariosFiltered;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public String getActualPassword() {
		return actualPassword;
	}

	public void setActualPassword(String actualPassword) {
		this.actualPassword = actualPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewMatchPassword() {
		return newMatchPassword;
	}

	public void setNewMatchPassword(String newMatchPassword) {
		this.newMatchPassword = newMatchPassword;
	}
}