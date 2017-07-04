/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import Entities.ConsolidadoAnual;
import Entities.SPDetalleItem;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

/**
 *
 * @author Bryan
 */
@Local
public interface ConsolidadoAnualFacadeLocal {

    void create(ConsolidadoAnual consolidadoAnual);

    void edit(ConsolidadoAnual consolidadoAnual);

    void remove(ConsolidadoAnual consolidadoAnual);

    ConsolidadoAnual find(Object id);

    List<ConsolidadoAnual> findAll();

    List<ConsolidadoAnual> findRange(int[] range);

    int count();
    
    short generarProcesos(int anio,int mes);
    
    Date getFechaCorte();

	
    
}
