/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import Entities.Bodega;
import Entities.VistaAlertaMinimos;
import SessionBeans.BodegaFacadeLocal;
import SessionBeans.VistaAlertaMinimosFacadeLocal;
import Utility.Reporte;
import java.io.IOException;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class AlertaMinimoxBodegaBean implements Serializable {

	/**
	 * Creates a new instance of AlertaMinimoxBodegaBean
	 */
	private static final long serialVersionUID = 1L;
	private Integer anio;
	private Integer mes;
	private Reporte rpt;
	private String rptGlobal;
	private String bodega;
	private List<VistaAlertaMinimos> dtbBodegaAlerta = new ArrayList<>();
	private List<Bodega> bodegas = new ArrayList<>();
	private HashMap<String, Object> parametros;
	private ArrayList<String> selectedColumnsAlertas = new ArrayList<>();
	private ArrayList<String> columnsAlertas = new ArrayList<>();
	private boolean dialogRendered;

	@EJB
	private VistaAlertaMinimosFacadeLocal facadeVistaAlertaMinimos;

	@EJB
	private BodegaFacadeLocal facedeBodegaLocal;

	@PostConstruct
	public void inicio() {
		dialogRendered = false;
		this.rptGlobal = "rptAlertaMaxMinGlobal";
		try {
			this.bodegas = this.facedeBodegaLocal.findAll();

			Iterator<Bodega> i = this.bodegas.iterator();
			while (i.hasNext()) {
				Bodega o = i.next();
				if (o.getCodigoBodega() == 91) {
					i.remove();
				}
			}

			this.fillColumns();

		} catch (PersistenceException he) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", he.getMessage()));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));
		}

	}

	public AlertaMinimoxBodegaBean() {

	}

	public boolean isDialogRendered() {
		return dialogRendered;
	}

	public void setDialogRendered(boolean dialogRendered) {
		this.dialogRendered = dialogRendered;
	}

	public String getRptGlobal() {
		return rptGlobal;
	}

	public void setRptGlobal(String rptGlobal) {
		this.rptGlobal = rptGlobal;
	}

	public String getBodega() {
		return bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public List<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
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

	public VistaAlertaMinimosFacadeLocal getFacadeVistaAlertaMinimos() {
		return facadeVistaAlertaMinimos;
	}

	public void setFacadeVistaAlertaMinimos(VistaAlertaMinimosFacadeLocal facadeVistaAlertaMinimos) {
		this.facadeVistaAlertaMinimos = facadeVistaAlertaMinimos;
	}

	public BodegaFacadeLocal getFacedeBodegaLocal() {
		return facedeBodegaLocal;
	}

	public void setFacedeBodegaLocal(BodegaFacadeLocal facedeBodegaLocal) {
		this.facedeBodegaLocal = facedeBodegaLocal;
	}

	public HashMap<String, Object> getParametros() {
		return parametros;
	}

	public void setParametros(HashMap<String, Object> parametros) {
		this.parametros = parametros;
	}

	public ArrayList<String> getSelectedColumnsAlertas() {
		return selectedColumnsAlertas;
	}

	public void setSelectedColumnsAlertas(ArrayList<String> selectedColumnsAlertas) {
		this.selectedColumnsAlertas = selectedColumnsAlertas;
	}

	public ArrayList<String> getColumnsAlertas() {
		return columnsAlertas;
	}

	public void setColumnsAlertas(ArrayList<String> columnsAlertas) {
		this.columnsAlertas = columnsAlertas;
	}

	public List<VistaAlertaMinimos> getDtbBodegaAlerta() {
		return dtbBodegaAlerta;
	}

	public void setDtbBodegaAlerta(List<VistaAlertaMinimos> dtbBodegaAlerta) {
		this.dtbBodegaAlerta = dtbBodegaAlerta;
	}

	public void fillColumns() {

		String[] columnas = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		int limit = 0;
		if (mes == null) {
			limit = columnas.length;
		} else {
			limit = mes.intValue();
		}

		selectedColumnsAlertas.clear();
		columnsAlertas.clear();

		for (int index = 0; index < limit; index++) {
			String value = columnas[index];

			selectedColumnsAlertas.add(value);
			columnsAlertas.add(value);

		}
	}

	public void invocarDialogo(VistaAlertaMinimos record, Long mes) {

	}

	public void exportarPDF() {

		rpt = new Reporte();
		parametros = new HashMap<String, Object>();
                
		String path = "/reportes/" + this.rptGlobal + ".jasper";                                
                
                
		try {
			if(this.bodega != null)
			{
				

				parametros.put("inYear", this.anio);
		                parametros.put("inBodega",Integer.parseInt(this.bodega));
				
				rpt.exportarPDF(parametros, path, "stock_consolidado" + this.anio);
				
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe de seleccionar de dar click en una bodega"));				
			}
			
                        

		} catch (JRException je) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", je.getMessage()));
			je.printStackTrace();
		} catch (IOException ie) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ie.getMessage()));
			ie.printStackTrace();
		} catch (NumberFormatException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe de seleccionar un a�o"));
		}

	}// Fin del metodo exportarPDFEgreso

	public void verAlertaMaxMinGlobalPdf() {

		if (this.dtbBodegaAlerta.size()>0) {

			try {

				this.dialogRendered = true;
				RequestContext.getCurrentInstance().update("impresionReporteDialogWidgetAlertaMinimo");
				RequestContext.getCurrentInstance().execute("PF('impresionReporteDialogWidgetAlertaMinimo').show();");

			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe de seleccionar un año"));

		}

	}

	public void llenarDatatable(Integer anio, Integer mes, Integer bodega) {
		try {

			this.dtbBodegaAlerta.clear();
			this.bodega = bodega.toString();
			this.anio = anio;

			this.dtbBodegaAlerta = this.facadeVistaAlertaMinimos.findByBodegaAndYear(bodega, anio);
			// this.dtbBodegaAlerta = this.facadeVistaAlertaMinimos.findAll();

			RequestContext.getCurrentInstance().update("tabView:frmAlertaMaximoMinimoxBodega:dtbBodegaAlerta");

		} catch (PersistenceException he) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", he.getMessage()));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));
		}

	}

}
