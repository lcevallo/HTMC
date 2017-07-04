/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Entities.Option;
import Entities.Rol;
import Entities.Usuario;
import SessionBeans.UsuarioFacadeLocal;
import Utility.StringMD5;

/**
 *
 * @author BryanV
 */
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario user;
	@EJB
	private UsuarioFacadeLocal usuarioFacadeLocal;

	/**
	 * Creates a new instance of loginBean
	 */
	public LoginBean() {
	}

	@PostConstruct
	public void inicio() {
		this.user = new Usuario();
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void logIn() throws IOException {

		try {

			Usuario userLogin = usuarioFacadeLocal.findByUserAndPassword(this.user.getUsuario(),
					StringMD5.getStringMessageDigest(this.user.getClave(), StringMD5.MD5));

			if (userLogin != null) {

				if (userLogin.getEstado()) {

					invalidateSession();
					HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
							.getSession(true);

					// userLogin = usuarioFacadeLocal.fetchRolesByUser(userLogin
					// .getCodUsuario());
					userLogin = usuarioFacadeLocal.fetchInformationByUser(userLogin.getUsuario());

					if (userLogin != null) {

						String startPage = getStartPage(userLogin);

						if (startPage != null) {

							session.setAttribute("userInSession", userLogin);
							session.setAttribute("tiposDeUsuario",
									tiposDeUsuario(usuarioFacadeLocal.fetchRolesByUser(userLogin.getUsuario())
											.getRoles()));

							Set<String> pagesInSession = new HashSet<>();
							Set<Integer> rolesByID = new HashSet<>();
							for (Rol rol : userLogin.getRoles()) {
								rolesByID.add(rol.getIdRol());
								for (Option permiso : rol.getOptions()) {
									pagesInSession.add(permiso.getPage());

								}
							}
							session.setAttribute("pagesInSession", pagesInSession);
							session.setAttribute("rolesInSession", rolesByID);

							FacesContext
									.getCurrentInstance()
									.getExternalContext()
									.redirect(
											FacesContext.getCurrentInstance().getExternalContext()
													.getRequestContextPath()
													+ startPage);

						} else
							FacesContext.getCurrentInstance().addMessage(
									null,
									new FacesMessage(FacesMessage.SEVERITY_WARN,
											"El rol principal asignado al usuario no tiene p�gina inicial", null));

					} else {
						invalidateSession();
						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "El usuario no tiene roles o permisos",
										null));

					}

				} else
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario inactivo", null));

			} else
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales incorrectas", null));

		} catch (Exception exception) {
			exception.printStackTrace();

			System.out.println(exception.getMessage());
		}

		user = new Usuario();
	}

	public void invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public String getStartPage(Usuario usuario) {

		for (Rol tipoUsuario : usuario.getRoles()) {
			if (tipoUsuario.getNombreRol().equals(usuario.getRolActivo()))
				return tipoUsuario.getStartPage();
		}

		return null;
	}

	public List<String> tiposDeUsuario(Set<Rol> set) {

		List<String> tiposDeUsuario = new ArrayList<String>();

		for (Rol tipoUsuario : set) {
			tiposDeUsuario.add(tipoUsuario.getNombreRol());
		}

		return tiposDeUsuario;

	}

	public void logOut() {

		try {

			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.redirect(
							FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
									+ "/login.jsf?faces-redirect=true");

		} catch (Exception exception) {
			// exception.printStackTrace();
			System.out.println(exception.getMessage());
		}

	}

}