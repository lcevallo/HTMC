/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import Entities.ConsolidadoAnualPivote;
import Entities.SPDetalleItem;

/**
 *
 * @author Bryan
 */
@Stateless
public class ConsolidadoAnualPivoteFacade extends
		AbstractFacade<ConsolidadoAnualPivote> implements
		ConsolidadoAnualPivoteFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager entityManager;
	private TransactionManager transaction;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public ConsolidadoAnualPivoteFacade() {
		super(ConsolidadoAnualPivote.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsolidadoAnualPivote> findAll(int year, int mes) {

		try {

			StoredProcedureQuery storedProcedure = entityManager
					.createStoredProcedureQuery(
							"get_table_consolidado_anual_pivote",
							ConsolidadoAnualPivote.class);

			storedProcedure.registerStoredProcedureParameter(1, Integer.class,
					ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter(2, Integer.class,
					ParameterMode.IN);

			storedProcedure.setParameter(1, year);
			storedProcedure.setParameter(2, mes);

			storedProcedure.execute();

			List<ConsolidadoAnualPivote> lista = storedProcedure
					.getResultList();

			return lista;

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		return null;
	}

	@Override
	public void generarConsolidadoAnual(Integer anio) throws SQLException,
			PersistenceException, NamingException {
		this.transaction = (TransactionManager) new InitialContext()
				.lookup("java:jboss/TransactionManager");

		try {
			this.transaction.begin();

			entityManager.createQuery(
					"select * from adm_generar_consolidado(?)").setParameter(1,
					anio);

			this.transaction.commit();

		} catch (NotSupportedException | RollbackException | SecurityException
				| IllegalStateException | SystemException
				| HeuristicMixedException | HeuristicRollbackException e) {

			e.printStackTrace();
			try {
				this.transaction.rollback();

			} catch (IllegalStateException | SecurityException
					| SystemException e1) {
				
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void generarConsolidadoPivoteAnual(Integer anio)
			throws SQLException, PersistenceException, NamingException {
		this.transaction = (TransactionManager) new InitialContext()
				.lookup("java:jboss/TransactionManager");

		try {
			this.transaction.begin();

			entityManager.createQuery(
					"select * from adm_generar_consolidado_pivote(?)")
					.setParameter(1, anio);

			this.transaction.commit();

		} catch (NotSupportedException | RollbackException | SecurityException
				| IllegalStateException | SystemException
				| HeuristicMixedException | HeuristicRollbackException e) {

			e.printStackTrace();
			try {
				this.transaction.rollback();

			} catch (IllegalStateException | SecurityException
					| SystemException e1) {
	
				e1.printStackTrace();
			}
		}

	}

	@Override
	public List<SPDetalleItem> getDetalleItem(String itemFk, Integer anio,
			Integer mes, String tipo) throws SQLException,
			PersistenceException, NamingException {

		List<SPDetalleItem> listaEnviada;

		try {

			Query q = entityManager
					.createNativeQuery(
							"select * from adm_detalle_items(?,?,?,?)")
					.setParameter(1, mes).setParameter(2, anio)
					.setParameter(3, itemFk).setParameter(4, tipo);

			List<Object[]> lista = q.getResultList();

			listaEnviada = new ArrayList<SPDetalleItem>();

			for (Object[] o : lista) {

				Integer CantidadRS = (int) o[1];
				Integer BodegaRS = (int) o[2];
				Date FechaRS = (Date) o[3];
				String DescripcionRS = (String) o[4];
				String OrdenMedicaRS = (String) o[5];

				SPDetalleItem sPDetalleItem = new SPDetalleItem(itemFk,
						CantidadRS, BodegaRS, FechaRS, DescripcionRS,
						OrdenMedicaRS);

				listaEnviada.add(sPDetalleItem);

			}

			return listaEnviada;

		} catch (SecurityException | IllegalStateException e) {

			e.printStackTrace();

		}
		return null;

	}

}
