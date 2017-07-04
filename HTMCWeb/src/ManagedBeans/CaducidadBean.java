/*
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;

import org.primefaces.context.RequestContext;

import Entities.VistaCaducidad;
import SessionBeans.VistaCaducidadFacadeLocal;
import Utility.Reporte;

/**
 *
 * @author BryanV
 */
@ManagedBean
@ViewScoped
public class CaducidadBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer anio;
	private Integer mes;
	private Reporte rpt;
	private HashMap<String, Object> parametros;
	private String itemSeleccionado;
	private String itemDescripcion;
	private Integer mesSeleccionado;
	

	@EJB
	private VistaCaducidadFacadeLocal vistaCaducidadFacadeLocal;
	
	@ManagedProperty(value = "#{opcionesCaducidadBean}")
	OpcionesCaducidadBean opcionesCaducidadBean;
	
	
	private List<VistaCaducidad> listaCaducidad;
	private List<VistaCaducidad> filteredListaCaducidad;

	private VistaCaducidad selectedVistaCaducidad;
	private List<Object[]> selectedListaCaducidad;

	public CaducidadBean() {

	}

	@PostConstruct
	public void inicio() {

		listaCaducidad = vistaCaducidadFacadeLocal.findAll();

	}
	
	
	
	public Integer getMesSeleccionado() {
		return mesSeleccionado;
	}

	public void setMesSeleccionado(Integer mesSeleccionado) {
		this.mesSeleccionado = mesSeleccionado;
	}

	public String getItemDescripcion() {
		return itemDescripcion;
	}

	public void setItemDescripcion(String itemDescripcion) {
		this.itemDescripcion = itemDescripcion;
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

	public void openDialogImprimirColores()
	{
	
		this.opcionesCaducidadBean.setAnio(this.anio);
		this.opcionesCaducidadBean.setMes(this.mes);
		
		this.opcionesCaducidadBean.setNombre_archivo("reporte_caducidad_"+this.anio);
		
		RequestContext context = RequestContext.getCurrentInstance();
		
		context.execute("PF('impresionDialogWidget').show();");
		
		
	}
	
	public void openDialog(VistaCaducidad record, String type)
			throws ParseException {

		RequestContext context = RequestContext.getCurrentInstance();

		this.selectedVistaCaducidad = record;
		this.itemSeleccionado=record.getItemfk();
		this.itemDescripcion=record.getDescripcion();
		this.mesSeleccionado=Integer.parseInt(type);
		
		String[] information = getInformation(type, record);

		int size = information.length;

		selectedListaCaducidad = new ArrayList<Object[]>();

		for (int index = 0; index < size; index++) {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateInString = information[index].split("\\|")[0];
			Date dateCaducidad = formatter.parse(dateInString);
			long difference = dateCaducidad.getTime() - new Date().getTime();

			long days = TimeUnit.DAYS
					.convert(difference, TimeUnit.MILLISECONDS);

			Object[] row = new Object[4];
			row[0] = information[index].split("@")[1];
			row[1] = information[index].split("\\|")[0];
			row[2] = information[index].split("\\|")[2].split("@")[0];
			row[3] = days;

			selectedListaCaducidad.add(row);

		}

		RequestContext.getCurrentInstance().update("formRecordItemCaducidad");
		RequestContext.getCurrentInstance().update("tablaCaducidad");
		context.execute("PF('dialogWidgetCaducidad').show();");

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

	public OpcionesCaducidadBean getOpcionesCaducidadBean() {
		return opcionesCaducidadBean;
	}

	public void setOpcionesCaducidadBean(OpcionesCaducidadBean opcionesCaducidadBean) {
		this.opcionesCaducidadBean = opcionesCaducidadBean;
	}

	public String[] getInformation(String type, VistaCaducidad record) {
		switch (Integer.parseInt(type)) {
		case 1:
			return record.getJan().split(",");
		case 2:
			return record.getFeb().split(",");
		case 3:
			return record.getMar().split(",");
		case 4:
			return record.getApr().split(",");
		case 5:
			return record.getMay().split(",");
		case 6:
			return record.getJun().split(",");
		case 7:
			return record.getJul().split(",");
		case 8:
			return record.getAug().split(",");
		case 9:
			return record.getSep().split(",");
		case 10:
			return record.getOct().split(",");
		case 11:
			return record.getNov().split(",");
		case 12:
			return record.getDec().split(",");

		}
		return null;
	}

	public List<VistaCaducidad> getListaCaducidad() {
		return listaCaducidad;
	}

	public void setListaCaducidad(List<VistaCaducidad> listaCaducidad) {
		this.listaCaducidad = listaCaducidad;
	}

	public List<VistaCaducidad> getFilteredListaCaducidad() {
		return filteredListaCaducidad;
	}

	public void setFilteredListaCaducidad(
			List<VistaCaducidad> filteredListaCaducidad) {
		this.filteredListaCaducidad = filteredListaCaducidad;
	}

	public VistaCaducidad getSelectedVistaCaducidad() {
		return selectedVistaCaducidad;
	}

	public void setSelectedVistaCaducidad(VistaCaducidad selectedVistaCaducidad) {
		this.selectedVistaCaducidad = selectedVistaCaducidad;
	}

	public List<Object[]> getSelectedListaCaducidad() {
		return selectedListaCaducidad;
	}

	public void setSelectedListaCaducidad(List<Object[]> selectedListaCaducidad) {
		this.selectedListaCaducidad = selectedListaCaducidad;
	}
		
	
	
	/**
    Seccion para repotes *
    */
	public void exportarPDFDetalle() {

		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		
		parametros.put("inYear", this.anio);
		parametros.put("inMes", this.mesSeleccionado);
		parametros.put("inItem", this.itemSeleccionado);
		parametros.put("descripcion", this.itemDescripcion);
		
	
		
		
		String path = "/reportes/item_caducidad_x_detalle.jasper";

		try {
			rpt.exportarPDF(parametros, path, "detalleItemCaducidad");

		} catch (JRException je) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", je
							.getMessage()));
			je.printStackTrace();
		} catch (IOException ie) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ie
							.getMessage()));
			ie.printStackTrace();
		} catch (NumberFormatException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
							"Debe de seleccionar un a�o"));
		}

	}// Fin del metodo exportarPDFDetalle

	
	
	public void exportarExcelDetalle() {

		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		
		parametros.put("inYear", this.anio);
		parametros.put("inMes", this.mesSeleccionado);
		parametros.put("inItem", this.itemSeleccionado);
		parametros.put("descripcion", this.itemDescripcion);
		
		
		String path = "/reportes/item_caducidad_x_detalle_excel.jasper";

		try {
			rpt.exportarXLS(parametros, path, "detalleItemCaducidad");

		} catch (JRException je) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", je
							.getMessage()));
			je.printStackTrace();
		} catch (IOException ie) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ie
							.getMessage()));
			ie.printStackTrace();
		} catch (NumberFormatException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
							"Debe de seleccionar un a�o"));
		}

	}// Fin del metodo exportarPDFDetalle

	
	
	public void verPDFDetalle() {
		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		
		
		
		parametros.put("inYear", this.anio);
		parametros.put("inMes", this.mesSeleccionado);
		parametros.put("inItem", this.itemSeleccionado);
		parametros.put("descripcion", this.itemDescripcion);
		
	
	
		String path = "/reportes/item_caducidad_x_detalle.jasper";

		try {
			rpt.verPDF(parametros, path, "detalleItemCaducidad");

		} catch (JRException je) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", je
							.getMessage()));
			je.printStackTrace();
		} catch (IOException ie) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ie
							.getMessage()));
			ie.printStackTrace();
		} catch (NumberFormatException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
							"Debe de seleccionar un a�o"));
		}

	}//fin del metodo verPDFDetalle

   /**
      FIN DE LA SECCION PARA REPOTE *
   */
	
	
	
}
