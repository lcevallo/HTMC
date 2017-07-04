/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import Entities.ConsolidadoIngreso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface ConsolidadoIngresoFacadeLocal {

    void create(ConsolidadoIngreso consolidadoIngreso);

    void edit(ConsolidadoIngreso consolidadoIngreso);

    void remove(ConsolidadoIngreso consolidadoIngreso);

    ConsolidadoIngreso find(Object id);

    List<ConsolidadoIngreso> findAll();

    List<ConsolidadoIngreso> findRange(int[] range);

    int count();
    
}
