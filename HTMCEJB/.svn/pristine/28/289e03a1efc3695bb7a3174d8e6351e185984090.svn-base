/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import Entities.ConsolidadoItemPercentil;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

/**
 *
 * @author Bryan
 */
@Local
public interface ConsolidadoItemPercentilFacadeLocal {

    void create(ConsolidadoItemPercentil consolidadoItemPercentil);

    void edit(ConsolidadoItemPercentil consolidadoItemPercentil);

    void remove(ConsolidadoItemPercentil consolidadoItemPercentil);

    ConsolidadoItemPercentil find(Object id);

    List<ConsolidadoItemPercentil> findAll();

    List<ConsolidadoItemPercentil> findRange(int[] range);
    
    List<ConsolidadoItemPercentil> findAll(int year) throws PersistenceException,SQLException;
    
    List<ConsolidadoItemPercentil> generarPercentil(int year,String percentil) throws  Exception,PersistenceException,SQLException;
    
    int count();
    
}
