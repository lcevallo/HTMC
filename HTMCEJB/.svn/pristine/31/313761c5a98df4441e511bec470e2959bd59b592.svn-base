/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.Date;
import java.util.List;

import Entities.PlantillaExcelCorte;
import Entities.VistaItemDetalleStockSf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author lcevallos
 */
@Stateless
public class PlantillaExcelCorteFacade extends AbstractFacade<PlantillaExcelCorte> implements PlantillaExcelCorteFacadeLocal {
    @PersistenceContext(unitName = "HTMC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlantillaExcelCorteFacade() {
        super(PlantillaExcelCorte.class);
    }

	@Override
	public List<PlantillaExcelCorte> findAllByFechas(Date fechaInicial,
			Date fechaFinal) {

		try {

			StoredProcedureQuery storedProcedure = em
					.createStoredProcedureQuery(
							"generar_plantilla_excel_al_corte",
							PlantillaExcelCorte.class);

			storedProcedure.registerStoredProcedureParameter(1, Date.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(2, Date.class,
					ParameterMode.IN);
		
			
			
			storedProcedure.setParameter(1, fechaInicial);
			storedProcedure.setParameter(2, fechaFinal);
			
			storedProcedure.execute();

			List<PlantillaExcelCorte> lista = storedProcedure.getResultList();

			return lista;

		} catch (Exception exception) {
			
			exception.printStackTrace();
			System.out.println(exception.getMessage());
		}

		return null;
	}
    
}
