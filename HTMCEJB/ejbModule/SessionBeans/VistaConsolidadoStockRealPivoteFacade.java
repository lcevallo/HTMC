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

import Entities.VistaConsolidadoStockRealPivote;

/**
 *
 * @author Bryan
 */
@Stateless
public class VistaConsolidadoStockRealPivoteFacade extends
		AbstractFacade<VistaConsolidadoStockRealPivote> implements
		VistaConsolidadoStockRealPivoteFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public VistaConsolidadoStockRealPivoteFacade() {
		super(VistaConsolidadoStockRealPivote.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VistaConsolidadoStockRealPivote> findAllByYear(Integer year) {
		
		try {
			return em.createNamedQuery("VistaConsolidadoStockRealPivote.findByYear").setParameter("year", year).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
