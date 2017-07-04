/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.Item;

/**
 *
 * @author Bryan
 */
@Local
public interface ItemFacadeLocal {

    void create(Item Item);

    void edit(Item Item);

    void remove(Item Item);

    Item find(Object id);

    List<Item> findAll();

    List<Item> findRange(int[] range);

    int count();
    
}
