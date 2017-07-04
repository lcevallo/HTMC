/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Option;

/**
 *
 * @author Bryan
 */
@Stateless
public class OptionFacade extends AbstractFacade<Option> implements OptionFacadeLocal {
    @PersistenceContext(unitName = "HTMC-ejbPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public OptionFacade() {
        super(Option.class);
    }
    
	@Override
	public Option findByPermiso(String page) {
		try {

			return (Option) entityManager.createNamedQuery("Option.findByPermiso")
					.setParameter("page", page).getSingleResult();

		} catch (Exception exception) {
			return null;
		}
	}
    
}
