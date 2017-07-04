/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.AreaItem;

/**
 *
 * @author Bryan
 */
@Stateless
public class AreaItemFacade extends AbstractFacade<AreaItem> implements
		AreaItemFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AreaItemFacade() {
		super(AreaItem.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AreaItem> findAllOrdered() {
		
		try {

			Query query = em.createNativeQuery(
					"SELECT ai.* FROM area_item ai ORDER BY ai.item_fk DESC",
					AreaItem.class);
			return (List<AreaItem>) query.getResultList();

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return null;
	}

	@Override
	public AreaItem exists(String idItem, Integer idEspecialidad) {
		try {

			Query query = em.createNativeQuery(
					"select ai.* from area_item ai where ai.item_fk = '"
							+ idItem + "' and ai.area_fk = " + idEspecialidad,
					AreaItem.class);

			Object object = query.getSingleResult();

			if (object instanceof AreaItem) {
				return (AreaItem) object;
			} else
				return null;

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return null;
		}

	}

	@EJB
	ApplicationAreaFacadeLocal applicationFacadeLocal;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getData() {
		try {

			int limit = applicationFacadeLocal.count();

			// String sql =
			// "SELECT ct.item,ct.descripcion, coalesce(ct.a, false) as c1, coalesce(ct.b, false) as c2 FROM crosstab('select ai.item_fk,i.descripcion, ai.area_fk, ai.estado from area_item ai, item i where ai.estado = true and ai.item_fk = i.codigo_item order by ai.area_fk asc','select m from generate_series(1,2) m') as ct(item text, descripcion text ,a boolean,b boolean)";
			String sql = "SELECT ct.item,ct.descripcion, coalesce(ct.c1, false) as c1, coalesce(ct.c2, false) as c2,"
					+ "coalesce(ct.c3, false) as c3, coalesce(ct.c4,false) as c4,coalesce(ct.c5, false) as c5, coalesce(ct.c6,false) as c6,"
					+ "coalesce(ct.c7, false) as c7, coalesce(ct.c8,false) as c8,coalesce(ct.c9, false) as c9, coalesce(ct.c10,false) as c10,"
					+ "coalesce(ct.c11, false) as c11, coalesce(ct.c12,false) as c12,coalesce(ct.c13, false) as c13, coalesce(ct.c14,false) as c14,"
					+ "coalesce(ct.c15, false) as c15, coalesce(ct.c16,false) as c16,coalesce(ct.c17, false) as c17, coalesce(ct.c18,false) as c18,"
					+ "coalesce(ct.c19, false) as c19, coalesce(ct.c20,false) as c20,coalesce(ct.c21, false) as c21, coalesce(ct.c22,false) as c22,"
					+ "coalesce(ct.c23, false) as c23, coalesce(ct.c24,false) as c24,coalesce(ct.c25, false) as c25, coalesce(ct.c26, false) as c26,"
					+ "coalesce(ct.c27, false) as c27, coalesce(ct.c28,false) as c28,coalesce(ct.c29, false) as c29, coalesce(ct.c30, false) as c30,"
					+ "coalesce(ct.c31, false) as c31, coalesce(ct.c32,false) as c32,coalesce(ct.c33, false) as c33"
					+ " FROM crosstab("
					+ "'select ai.item_fk,i.descripcion, ai.area_fk, ai.estado "
					+ "from area_item ai, item i, application_area aa"
					+ " where ai.item_fk = i.codigo_item "
					+ "order by ai.area_fk asc',"
					+ "'select m from generate_series(1,33) m')"
					+ " as ct(item text, descripcion text ,"
					+ "c1 boolean,c2 boolean,c3 boolean,c4 boolean,c5 boolean,c6 boolean,"
					+ "c7 boolean,c8 boolean,c9 boolean,c10 boolean,c11 boolean,c12 boolean,"
					+ "c13 boolean,c14 boolean,c15 boolean,c16 boolean,c17 boolean,c18 boolean,"
					+ "c19 boolean,c20 boolean,c21 boolean,c22 boolean,c23 boolean,c24 boolean,"
					+ "c25 boolean,c26 boolean,c27 boolean,c28 boolean,c29 boolean,c30 boolean,"
					+ "c31 boolean,c32 boolean,c33 boolean)";
			System.out.println(sql);
			Query query = em.createNativeQuery(sql);
			List<Object[]> lista = query.getResultList();
			System.out.println(lista.size());
			return lista;

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return null;
		}
	}
}
