/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import Entities.ConsolidadoItemPercentil;

/**
 *
 * @author Bryan
 */
@Stateless
public class ConsolidadoItemPercentilFacade extends
		AbstractFacade<ConsolidadoItemPercentil> implements
		ConsolidadoItemPercentilFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager em;
	private TransactionManager transaction;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ConsolidadoItemPercentilFacade() {
		super(ConsolidadoItemPercentil.class);
	}

	@Override
	public List<ConsolidadoItemPercentil> findAll(int year)
			throws PersistenceException, SQLException {

		try {

			List<ConsolidadoItemPercentil> listado = null;
			String query = "FROM ConsolidadoItemPercentil  E where E.id.year=:anio Order by E.id.itemFk ";
			Query q = this.em.createQuery(query).setParameter("anio", year);
			listado = q.getResultList();
			return listado;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsolidadoItemPercentil> generarPercentil(int year,
			String percentil) throws Exception, PersistenceException,
			SQLException {

		String query = "FROM ConsolidadoItemPercentil E where E.id.year= :anio Order by E.id.itemFk";

		try {

			Query querySQL = em.createQuery(query).setParameter("anio", year);

			List<ConsolidadoItemPercentil> lista = (List<ConsolidadoItemPercentil>) querySQL
					.getResultList();

			

			return lista;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;

	}

}
