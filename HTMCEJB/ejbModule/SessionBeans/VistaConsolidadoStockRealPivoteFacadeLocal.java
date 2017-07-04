/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.VistaConsolidadoStockRealPivote;

/**
 *
 * @author Bryan
 */
@Local
public interface VistaConsolidadoStockRealPivoteFacadeLocal {

	void create(VistaConsolidadoStockRealPivote VistaConsolidadoStockRealPivote);

	void edit(VistaConsolidadoStockRealPivote VistaConsolidadoStockRealPivote);

	void remove(VistaConsolidadoStockRealPivote VistaConsolidadoStockRealPivote);

	VistaConsolidadoStockRealPivote find(Object id);

	List<VistaConsolidadoStockRealPivote> findAll();

	List<VistaConsolidadoStockRealPivote> findRange(int[] range);
	
	List<VistaConsolidadoStockRealPivote> findAllByYear (Integer year);

	int count();

}
