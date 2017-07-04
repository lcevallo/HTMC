/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;
import Utility.Reporte;

/**
 *
 * @author lcevallos
 */
@ManagedBean
@ViewScoped
public class EgresoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer anio;
	private Integer mes;
	private Reporte rpt;
	private HashMap<String, Object> parametros;

	/**
	 * Creates a new instance of EgresoBean
	 */

	public EgresoBean() {

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

	public void exportarPDF() {

		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		parametros.put("inYear", this.anio);

		String path = "/reportes/consolidadoEgreso.jasper";

		try {
			rpt.exportarPDF(parametros, path, "consolidado_egreso");

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
							"Debe de seleccionar un año"));
		}

	}// Fin del metodo exportarPDFEgreso

	public void verPdf() {
		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		parametros.put("inYear", this.anio);

		String path = "/reportes/consolidadoEgreso.jasper";

		try {
			rpt.verPDF(parametros, path, "consolidado_egreso");

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
							"Debe de seleccionar un año"));
		}

	}//fin del metodo VerPdf

}
