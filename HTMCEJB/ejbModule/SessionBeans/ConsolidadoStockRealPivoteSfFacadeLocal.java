/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.ConsolidadoStockRealPivoteSf;
import Entities.VistaItemDetalleStockSf;

/**
 *
 * @author lcevallos
 */
@Local
public interface ConsolidadoStockRealPivoteSfFacadeLocal {

    void create(ConsolidadoStockRealPivoteSf consolidadoStockRealPivoteSf);

    void edit(ConsolidadoStockRealPivoteSf consolidadoStockRealPivoteSf);

    void remove(ConsolidadoStockRealPivoteSf consolidadoStockRealPivoteSf);

    ConsolidadoStockRealPivoteSf find(Object id);

    List<ConsolidadoStockRealPivoteSf> findAll();

    List<ConsolidadoStockRealPivoteSf> findRange(int[] range);
    
    List<ConsolidadoStockRealPivoteSf> findAll(Integer anio);
    
    List<VistaItemDetalleStockSf> findAll(String item,Integer anio, Integer mes);
    
    int count();
    
}
