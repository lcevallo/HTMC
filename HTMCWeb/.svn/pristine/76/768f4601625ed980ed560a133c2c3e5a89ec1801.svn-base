/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRException;
import Utility.Reporte;

/**
 *
 * @author lcevallos
 */
@ManagedBean
@ViewScoped
public class IngresoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer anio;
	private Integer mes;

	private Reporte rpt;

	private HashMap<String, Object> parametros;

	/**
	 * Creates a new instance of IngresoBean
	 */
	public IngresoBean() {
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

	public String getLogo() {

		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String logo = servletContext.getRealPath("") + File.separator
				+ "resources" + File.separator + "images" + File.separator
				+ "LOGO_HTMC.png";
		return logo;
	}

	/**** SECCION DE REPORTES **/

	public void exportarPDF() {
		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		parametros.put("inYear", this.anio);
		//parametros.put("ruta", this.getLogo());

		String path = "/reportes/consolidadoIngreso.jasper";

		try {
			rpt.exportarPDF(parametros, path, "consolidado_ingreso");

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
	}

	public void verPdf() {
		try {
			rpt = new Reporte();
			parametros = new HashMap<String, Object>();

			parametros.put("inYear", this.anio);
		
			String path = "/reportes/consolidadoIngreso.jasper";
			rpt.verPDF(parametros, path, "consolidado_ingreso");

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
			e.printStackTrace();
		}

	}

}
