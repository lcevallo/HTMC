/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import Entities.ConsolidadoSaldo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface SaldoConsolidadoFacadeLocal {

    void create(ConsolidadoSaldo ConsolidadoSaldo);

    void edit(ConsolidadoSaldo ConsolidadoSaldo);

    void remove(ConsolidadoSaldo ConsolidadoSaldo);

    ConsolidadoSaldo find(Object id);

    List<ConsolidadoSaldo> findAll();

    List<ConsolidadoSaldo> findRange(int[] range);

    int count();
    
}
