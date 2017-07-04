/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Usuario;

/**
 *
 * @author Bryan
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements
		UsuarioFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public UsuarioFacade() {
		super(Entities.Usuario.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> obtenerPages(Usuario usuario) {

		try {
			Query query = entityManager
					.createNativeQuery("select o.page from option o where o.id_option in (select ro.fk_option from rol_option ro where ro.fk_rol in (select ur.fk_rol from usuario_rol ur where ur.fk_usuario = :id_usuario))");
			query.setParameter("id_usuario", usuario.getUsuario());
			List<String> lista = (List<String>) query.getResultList();
			return lista;
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> obtenerRoles(Usuario usuario) {

		try {
			Query query = entityManager
					.createNativeQuery("select ur.fk_rol from usuario_rol ur where ur.fk_usuario = :id_usuario");
			query.setParameter("id_usuario", usuario.getUsuario());
			List<Integer> lista = (List<Integer>) query.getResultList();

			return lista;
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
		}

		return null;
	}

	/*
	 * This won't work in the new version. Fix ASAP.
	 * 
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetail> findUserDetails(Usuario usuario) {
		try {

			Query query;

			String sql = "select new SessionBeans.UserDetail(u.nombre,r.idRol,r.nombreRol,o.page) from Usuario u, Rol r, Option o,UsuarioRol ur,RolOption ro "
					+ "where u.usuario = ur.usuario.usuario and u.usuario = :id_usuario and ur.rol.idRol = r.idRol "
					+ "and r.idRol = ro.rol.idRol and ro.option.idOption = o.idOption";

			query = entityManager.createQuery(sql);

			query.setParameter("id_usuario", usuario.getUsuario());

			return (List<UserDetail>) query.getResultList();

		} catch (Exception exception) {
			exception.printStackTrace();
			System.err.println(exception.getMessage());
		}

		return null;
	}

	@Override
	public Usuario findUserInformation(Usuario usuario) {
		try {

			Query query;

			String sql;

			sql = "select distinct usuario from Usuario usuario "
					+ "join fetch usuario.roles roles "
					+ "join fetch roles.options "
					+ "where usuario.usuario = :id_usuario";

			query = entityManager.createQuery(sql);

			query.setParameter("id_usuario", usuario.getUsuario());

			return (Usuario) query.getSingleResult();

		} catch (Exception exception) {
			//exception.printStackTrace();
			System.err.println(exception.getMessage());
		}

		return null;
	}
	
	/* */
	
	@Override
	public Usuario findByUserAndPassword(String usuario, String clave) {
		try {
			return (Usuario) entityManager.createNamedQuery("Usuario.findUser")
					.setParameter("usuario", usuario)
					.setParameter("clave", clave).getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}

	@Override
	public Usuario fetchRolesByUser(String usuario) {
		try {
			return (Usuario) entityManager
					.createQuery(
							"SELECT distinct usuario FROM Usuario usuario "
									+ "join fetch usuario.roles roles "
									+ "WHERE usuario.usuario = :usuario")
					.setParameter("usuario", usuario).getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}

	@Override
	public Usuario fetchInformationByUser(String usuario) {
		try {
			return (Usuario) entityManager
					.createQuery(
							"SELECT distinct usuario FROM Usuario usuario "
									+ "join fetch usuario.roles roles "
									+ "join fetch roles.options options "
									+ "WHERE usuario.usuario = :nombreUsuario")
					.setParameter("nombreUsuario", usuario).getSingleResult();
		} catch (Exception exception) {			
			return null;
		}
	}

	@Override
	public Usuario findByUserCode(String usuario) {
		try {
			return (Usuario) entityManager
					.createNamedQuery("Usuario.findByUserCode")
					.setParameter("usuario", usuario).getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}

}

class UserDetail {
	private String nombre;
	private int rol;
	private String nombreRol;
	private String page;

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public UserDetail() {
		super();
	}

	public UserDetail(String nombre, int rol, String nombreRol, String page) {
		super();
		this.nombre = nombre;
		this.rol = rol;
		this.nombreRol = nombreRol;
		this.page = page;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

}
