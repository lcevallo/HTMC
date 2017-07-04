/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.UnidadDependencia;

/**
 *
 * @author Bryan
 */
@Stateless
public class UnidadDependenciaFacade extends AbstractFacade<UnidadDependencia> implements UnidadDependenciaFacadeLocal {
    @PersistenceContext(unitName = "HTMC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadDependenciaFacade() {
        super(UnidadDependencia.class);
    }
    
}