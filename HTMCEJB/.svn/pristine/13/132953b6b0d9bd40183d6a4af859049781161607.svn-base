/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.Option;

/**
 *
 * @author Bryan
 */
@Local
public interface OptionFacadeLocal {

    void create(Option Option);

    void edit(Option Option);

    void remove(Option Option);

    Option find(Object id);

    List<Option> findAll();

    List<Option> findRange(int[] range);

    int count();

	Option findByPermiso(String permiso);
    
}
