/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import Entities.PlantillaExcelCorte;

/**
 *
 * @author lcevallos
 */
@Local
public interface PlantillaExcelCorteFacadeLocal {

    void create(PlantillaExcelCorte plantillaExcelCorte);

    void edit(PlantillaExcelCorte plantillaExcelCorte);

    void remove(PlantillaExcelCorte plantillaExcelCorte);

    PlantillaExcelCorte find(Object id);

    List<PlantillaExcelCorte> findAll();

    List<PlantillaExcelCorte> findRange(int[] range);
    
    List<PlantillaExcelCorte> findAllByFechas(Date fechaInicial,Date fechaFinal);

    int count();
    
}
