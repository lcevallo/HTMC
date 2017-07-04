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
import javax.persistence.Query;

import Entities.ApplicationArea;
import Entities.AreaItem;

/**
 *
 * @author Bryan
 */
@Stateless
public class ApplicationAreaFacade extends AbstractFacade<ApplicationArea>
		implements ApplicationAreaFacadeLocal {
	@PersistenceContext(unitName = "HTMC-ejbPU")
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public ApplicationAreaFacade() {
		super(ApplicationArea.class);
	}

	

}
