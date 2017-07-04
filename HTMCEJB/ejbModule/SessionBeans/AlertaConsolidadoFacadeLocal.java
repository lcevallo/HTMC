/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.ConsolidadoAlerta;

/**
 *
 * @author Bryan
 */
@Local
public interface AlertaConsolidadoFacadeLocal {

    void create(ConsolidadoAlerta ConsolidadoAlerta);

    void edit(ConsolidadoAlerta ConsolidadoAlerta);

    void remove(ConsolidadoAlerta ConsolidadoAlerta);

    ConsolidadoAlerta find(Object id);

    List<ConsolidadoAlerta> findAll();

    List<ConsolidadoAlerta> findRange(int[] range);

    int count();
    
}
