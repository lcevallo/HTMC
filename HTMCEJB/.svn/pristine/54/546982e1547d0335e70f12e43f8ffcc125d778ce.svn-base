/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.ItemMaxMin;


/**
 *
 * @author lcevallos
 */
@Local
public interface ItemMaxMinFacadeLocal {

    void create(ItemMaxMin ItemMaxMin);

    void edit(ItemMaxMin ItemMaxMin);

    void remove(ItemMaxMin ItemMaxMin);

    ItemMaxMin find(Object id);

    List<ItemMaxMin> findAll();

    List<ItemMaxMin> findRange(int[] range);    
    

    int count();
    
}
