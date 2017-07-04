/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import net.sf.jasperreports.engine.JRException;

import org.primefaces.context.RequestContext;

import Entities.ConsolidadoItemPercentil;
import SessionBeans.ConsolidadoItemPercentilFacadeLocal;
import Utility.Reporte;

/**
 *
 * @author lcevallos
 */
@ManagedBean
@ViewScoped
public class PercentilBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer anio;
	private Integer mes;
	private String percentil;
	private Reporte rpt;
	private HashMap<String, Object> parametros;

	@EJB
	private ConsolidadoItemPercentilFacadeLocal consolidadoItemPercentilFacadeLocal;

	private List<ConsolidadoItemPercentil> listaConsolidadoItemPercentil;

	/**
	 * Creates a new instance of PercentilBean
	 */

	/*
	 * this.listaConsolidadoItemPercentil=this.consolidadoItemPercentilFacadeLocal
	 * .findAll(this.anio);
	 */

	public PercentilBean() {

	}

	public String getPercentil() {
		return percentil;
	}

	public void setPercentil(String percentil) {
		this.percentil = percentil;
	}

	public HashMap<String, Object> getParametros() {
		return parametros;
	}

	public void setParametros(HashMap<String, Object> parametros) {
		this.parametros = parametros;
	}

	public Reporte getRpt() {
		return rpt;
	}

	public void setRpt(Reporte rpt) {
		this.rpt = rpt;
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

	public List<ConsolidadoItemPercentil> getListaConsolidadoItemPercentil() {
		return listaConsolidadoItemPercentil;
	}

	public void setListaConsolidadoItemPercentil(
			List<ConsolidadoItemPercentil> listaConsolidadoItemPercentil) {
		this.listaConsolidadoItemPercentil = listaConsolidadoItemPercentil;
	}

	public void generarTablaPercentil() {

		try {

			this.listaConsolidadoItemPercentil = this.consolidadoItemPercentilFacadeLocal
					.findAll();
			// this.listaConsolidadoItemPercentil =
			// this.consolidadoItemPercentilFacadeLocal.generarPercentil(this.anio,
			// "0.90");

			// RequestContext.getCurrentInstance().update(
			// "tabView:fmrPercentiles");

		}

		catch (PersistenceException he) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", he
							.getMessage()));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e
							.getMessage()));
		}

	}// fin del generarTablaPercentil

	public void exportarPDF() {

		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		parametros.put("anio", this.anio);

		String path = "/reportes/consolidadoPercentil.jasper";

		try {
			rpt.exportarPDF(parametros, path, "percentil_item");

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

		parametros.put("anio", this.anio);

		String path = "/reportes/consolidadoPercentil.jasper";

		try {
			rpt.verPDF(parametros, path, "percentil_item");

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

	}// fin del metodo VerPdf

}
