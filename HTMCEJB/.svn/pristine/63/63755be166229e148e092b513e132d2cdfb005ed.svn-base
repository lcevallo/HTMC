/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.naming.NamingException;
import javax.persistence.PersistenceException;

import Entities.ConsolidadoAnualPivote;
import Entities.SPDetalleItem;

/**
 *
 * @author Bryan
 */
@Local
public interface ConsolidadoAnualPivoteFacadeLocal {

    void create(ConsolidadoAnualPivote consolidadoAnualPivote);

    void edit(ConsolidadoAnualPivote consolidadoAnualPivote);

    void remove(ConsolidadoAnualPivote consolidadoAnualPivote);

    ConsolidadoAnualPivote find(Object id);

    List<ConsolidadoAnualPivote> findAll();

    List<ConsolidadoAnualPivote> findRange(int[] range);
    
    List<ConsolidadoAnualPivote> findAll(int year, int mes);
    
    void generarConsolidadoAnual(Integer anio) throws SQLException,PersistenceException,NamingException,NamingException;
    
    void generarConsolidadoPivoteAnual(Integer anio) throws SQLException,PersistenceException,NamingException;
    
    List<SPDetalleItem> getDetalleItem(String itemFk, Integer anio,Integer mes, String tipo) throws SQLException,PersistenceException,NamingException;
    
    int count();

	
    
}
