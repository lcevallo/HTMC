/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.UnidadDependencia;

/**
 *
 * @author Bryan
 */
@Local
public interface UnidadDependenciaFacadeLocal {

    void create(UnidadDependencia UnidadDependencia);

    void edit(UnidadDependencia UnidadDependencia);

    void remove(UnidadDependencia UnidadDependencia);

    UnidadDependencia find(Object id);

    List<UnidadDependencia> findAll();

    List<UnidadDependencia> findRange(int[] range);

    int count();
    
}
