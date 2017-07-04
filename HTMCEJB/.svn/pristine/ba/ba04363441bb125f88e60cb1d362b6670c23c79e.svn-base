/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import Entities.EgresoItem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface EgresoItemsFacadeLocal {

	void create(EgresoItem EgresoItem);

	void edit(EgresoItem EgresoItem);

	void remove(EgresoItem EgresoItem);

	EgresoItem find(Object id);

	List<EgresoItem> findAll();

	List<EgresoItem> findRange(int[] range);

	int count();

}
