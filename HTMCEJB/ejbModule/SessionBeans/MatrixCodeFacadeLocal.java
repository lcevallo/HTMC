/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.MatrixCode;

/**
 *
 * @author Bryan
 */
@Local
public interface MatrixCodeFacadeLocal {

    void create(MatrixCode MatrixCode);

    void edit(MatrixCode MatrixCode);

    void remove(MatrixCode MatrixCode);

    MatrixCode find(Object id);

    List<MatrixCode> findAll();

    List<MatrixCode> findRange(int[] range);

    int count();
    
}
