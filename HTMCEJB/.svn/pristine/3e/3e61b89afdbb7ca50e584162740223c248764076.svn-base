/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import Entities.ConsolidadoEgreso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface ConsolidadoEgresoFacadeLocal {

    void create(ConsolidadoEgreso consolidadoEgreso);

    void edit(ConsolidadoEgreso consolidadoEgreso);

    void remove(ConsolidadoEgreso consolidadoEgreso);

    ConsolidadoEgreso find(Object id);

    List<ConsolidadoEgreso> findAll();

    List<ConsolidadoEgreso> findRange(int[] range);

    int count();
    
}
