/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.ConsolidadoStockRealMinimoPivote;

/**
 *
 * @author lcevallos
 */
@Local
public interface ConsolidadoStockRealMinimoPivoteFacadeLocal {

    void create(ConsolidadoStockRealMinimoPivote consolidadoStockRealMinimoPivote);

    void edit(ConsolidadoStockRealMinimoPivote consolidadoStockRealMinimoPivote);

    void remove(ConsolidadoStockRealMinimoPivote consolidadoStockRealMinimoPivote);

    ConsolidadoStockRealMinimoPivote find(Object id);

    List<ConsolidadoStockRealMinimoPivote> findAll();
    
    List<ConsolidadoStockRealMinimoPivote> findAll(int year);

    List<ConsolidadoStockRealMinimoPivote> findRange(int[] range);

    int count();
    
}
