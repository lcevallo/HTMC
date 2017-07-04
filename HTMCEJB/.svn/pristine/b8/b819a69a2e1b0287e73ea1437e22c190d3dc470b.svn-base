/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.VistaAlertaMinimos;

/**
 *
 * @author Bryan
 */
@Local
public interface VistaAlertaMinimosFacadeLocal {

	void create(VistaAlertaMinimos vistaAlertaMinimos);

	void edit(VistaAlertaMinimos vistaAlertaMinimos);

	void remove(VistaAlertaMinimos vistaAlertaMinimos);

	VistaAlertaMinimos find(Object id);

	List<VistaAlertaMinimos> findAll();

	List<VistaAlertaMinimos> findRange(int[] range);

	int count();

	List<VistaAlertaMinimos> findByBodegaAndYear(Integer bodega, Integer year);

}
