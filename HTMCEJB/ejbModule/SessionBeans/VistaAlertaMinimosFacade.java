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

import Entities.VistaAlertaMinimos;

/**
 *
 * @author Bryan
 */
@Stateless
public class VistaAlertaMinimosFacade extends AbstractFacade<VistaAlertaMinimos> implements
		VistaAlertaMinimosFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public VistaAlertaMinimosFacade() {
		super(VistaAlertaMinimos.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VistaAlertaMinimos> findByBodegaAndYear(Integer bodega, Integer year) {
		try {
			return em.createNamedQuery("VistaAlertaMinimos.findByBodegaAndYear").setParameter("bodega", bodega)
					.setParameter("year", year).getResultList();

		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
}