/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.TransactionManager;

import Entities.VistaIngresoMaximoMinimo;

/**
 *
 * @author Bryan
 */
@Stateless
public class VistaItemMaxMinFacade extends AbstractFacade<VistaIngresoMaximoMinimo> implements
		VistaItemMaxMinFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager entityManager;
	private TransactionManager transaction;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public VistaItemMaxMinFacade() {
		super(VistaIngresoMaximoMinimo.class);
	}

	@Override
	public String guardarMaximoMinimo(String usuario,VistaIngresoMaximoMinimo vistaIngresoMaximoMinimo) {
		
		
		try {
						
			StoredProcedureQuery storedProcedure = entityManager
					.createStoredProcedureQuery(
							"adm_ingresar_max_min"
							);

			storedProcedure.registerStoredProcedureParameter(1, String.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(2, String.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(3, Integer.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(4, Integer.class,
					ParameterMode.IN);			
			storedProcedure.registerStoredProcedureParameter(5, Integer.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(6, Integer.class,
					ParameterMode.IN);			
			storedProcedure.registerStoredProcedureParameter(7, Integer.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(8, Integer.class,
					ParameterMode.IN);
			
			
			storedProcedure.setParameter(1, usuario);
			storedProcedure.setParameter(2, vistaIngresoMaximoMinimo.getCodigoItem());
			storedProcedure.setParameter(3, vistaIngresoMaximoMinimo.getMaximo112());
			storedProcedure.setParameter(4, vistaIngresoMaximoMinimo.getMinimo112());
			storedProcedure.setParameter(5, vistaIngresoMaximoMinimo.getMaximo113());
			storedProcedure.setParameter(6, vistaIngresoMaximoMinimo.getMinimo113());
			storedProcedure.setParameter(7, vistaIngresoMaximoMinimo.getMaximo114());
			storedProcedure.setParameter(8, vistaIngresoMaximoMinimo.getMinimo114());

			
			storedProcedure.execute();
			
			
			
			return storedProcedure.getSingleResult().toString();

			

		

		} catch (Exception exception) {
			//System.out.println(exception.getMessage());
			exception.printStackTrace();
		}

		return null;
		
		
		
	}

}
