/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import Entities.AreaItem;

import java.util.List;

import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface AreaItemFacadeLocal {

    void create(AreaItem areaItem);

    void edit(AreaItem areaItem);

    void remove(AreaItem areaItem);

    AreaItem find(Object id);

    List<AreaItem> findAll();

    List<AreaItem> findRange(int[] range);

    int count();

	List<AreaItem> findAllOrdered();
	
	AreaItem exists(String idItem, Integer idEspecialidad);

	List<Object[]> getData();

	
    
}
