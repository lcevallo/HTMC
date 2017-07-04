/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import javax.annotation.PostConstruct;
import javax.el.ELContextEvent;
import javax.el.ELContextListener;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/**
 *
 * @author BryanV
 */
@ManagedBean(eager=true)
@ApplicationScoped
public class ConstantBean {

    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getApplication().addELContextListener(new ELContextListener() {
            @Override
            public void contextCreated(ELContextEvent event) {
                event.getELContext().getImportHandler().importClass("Utility.Rol");                
            }
        });
    }

}
