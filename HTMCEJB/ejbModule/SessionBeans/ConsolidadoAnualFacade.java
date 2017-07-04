/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.Date;
import java.util.List;

import Entities.AreaItem;
import Entities.ConsolidadoAnual;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bryan
 */
@Stateless
public class ConsolidadoAnualFacade extends AbstractFacade<ConsolidadoAnual>
		implements ConsolidadoAnualFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ConsolidadoAnualFacade() {
		super(ConsolidadoAnual.class);
	}

	@Override
	public short generarProcesos(int anio, int mes) {

		try {

			Query query = em
					.createNativeQuery("SELECT * FROM adm_generar_proceso(?,?) ");

			query.setParameter(1, anio);
			query.setParameter(2, mes);

			return (short) query.getSingleResult();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return 0;
	}

	@Override
	public Date getFechaCorte() {
		try {

			Query query = em
					.createNativeQuery("SELECT * FROM get_fecha_corte_actual() ");

			return (Date) query.getSingleResult();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

}
