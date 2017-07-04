/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import Entities.VistaItemDetalleStockSf;
import SessionBeans.ConsolidadoStockRealPivoteSfFacadeLocal;
import Utility.Reporte;

/**
 *
 * @author lcevallos
 */
@ManagedBean
@ViewScoped
public class ItemStockSfDetalleBean implements Serializable {
    
  
    private static final long serialVersionUID = 1L;
    private String codigoItem;
    private String descripcionItem;
    private Integer anio;
    private Integer mes;
    private Reporte rpt;
    private HashMap<String, Object> parametros;
	private List<VistaItemDetalleStockSf> dtbVistaItemDetalleStockSf;
	
	@EJB
	private ConsolidadoStockRealPivoteSfFacadeLocal facadeConsolidadoStockRealPivoteSfFacade;
	
	/**
     * Creates a new instance of itemStockSfDetalleBean
     */
    public ItemStockSfDetalleBean() {
    }


	public Integer getAnio() {
		return anio;
	}


	public void setAnio(Integer anio) {
		this.anio = anio;
	}


	public Integer getMes() {
		return mes;
	}


	public void setMes(Integer mes) {
		this.mes = mes;
	}


	public Reporte getRpt() {
		return rpt;
	}


	public void setRpt(Reporte rpt) {
		this.rpt = rpt;
	}


	public HashMap<String, Object> getParametros() {
		return parametros;
	}


	public void setParametros(HashMap<String, Object> parametros) {
		this.parametros = parametros;
	}


	public List<VistaItemDetalleStockSf> getDtbVistaItemDetalleStockSf() {
		return dtbVistaItemDetalleStockSf;
	}

	
	public String getCodigoItem() {
		return codigoItem;
	}


	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}


	public String getDescripcionItem() {
		return descripcionItem;
	}


	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}


	public void setDtbVistaItemDetalleStockSf(
			List<VistaItemDetalleStockSf> dtbVistaItemDetalleStockSf) {
		this.dtbVistaItemDetalleStockSf = dtbVistaItemDetalleStockSf;
	}

   
	public void getDetalleStockItem(String item)
	{
		
		try{
			this.dtbVistaItemDetalleStockSf=this.facadeConsolidadoStockRealPivoteSfFacade.findAll(item, this.anio, this.mes);
			
		}
		catch (PersistenceException he) {
			he.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", he
							.getMessage()));

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e
							.getMessage()));
		}
	}
	
	
	/**
    Seccion para repotes *
    */
   public void exportarPDF() {

   }

   public void verPdf() {

   }

   /**
      FIN DE LA SECCION PARA REPOTE *
   */
    
   
   
   
}	
