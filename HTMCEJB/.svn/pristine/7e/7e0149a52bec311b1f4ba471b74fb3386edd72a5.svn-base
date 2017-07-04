/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import Entities.ConsolidadoStockRealPivoteSf;
import Entities.VistaItemDetalleStockSf;

/**
 *
 * @author lcevallos
 */
@Stateless
public class ConsolidadoStockRealPivoteSfFacade extends AbstractFacade<ConsolidadoStockRealPivoteSf> implements ConsolidadoStockRealPivoteSfFacadeLocal {
    @PersistenceContext(unitName = "HTMC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsolidadoStockRealPivoteSfFacade() {
        super(ConsolidadoStockRealPivoteSf.class);
    }

	@Override
	public List<ConsolidadoStockRealPivoteSf> findAll(Integer anio) {
		try
		{
			return this.em.createNamedQuery("ConsolidadoStockRealPivoteSf.findByYear").setParameter("year", anio).getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();	
			return null;
		}
		
	}

	@Override
	public List<VistaItemDetalleStockSf> findAll(String item, Integer anio,Integer mes) {
		
		try {

			StoredProcedureQuery storedProcedure = em
					.createStoredProcedureQuery(
							"adm_get_detalle_stock_sf",
							VistaItemDetalleStockSf.class);

			storedProcedure.registerStoredProcedureParameter(1, String.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(2, Integer.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(3, Integer.class,
					ParameterMode.IN);
			
			
			storedProcedure.setParameter(1, item);
			storedProcedure.setParameter(2, anio);
			storedProcedure.setParameter(3, mes);
			
			storedProcedure.execute();

			List<VistaItemDetalleStockSf> lista = storedProcedure.getResultList();

			return lista;

		} catch (Exception exception) {
			
			exception.printStackTrace();
			System.out.println(exception.getMessage());
		}

		return null;

	}
    
}
