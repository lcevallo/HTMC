/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Rol;

/**
 *
 * @author Bryan
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public RolFacade() {
		super(Rol.class);
	}

	@Override
	public Rol findByName(String nombreRol) {

		try {
			return (Rol) entityManager
					.createQuery("SELECT rol FROM Rol rol WHERE upper(rol.nombreRol) = upper(:nombreRol)")
					.setParameter("nombreRol", nombreRol).getSingleResult();

		} catch (Exception exception) {
			//exception.printStackTrace();
			return null;
		}
		

	}

	@Override
	public Rol fetchPermisosByRol(String rol) {
		try {
			return (Rol) entityManager
					.createQuery(
							"SELECT distinct rol FROM Rol rol " + "join fetch rol.options permisos "
									+ "WHERE rol.nombreRol = :nombreRol").setParameter("nombreRol", rol)
					.getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}

}
