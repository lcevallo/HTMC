/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import net.sf.jasperreports.engine.JRException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import Entities.ConsolidadoStockRealMinimoPivote;
import SessionBeans.ConsolidadoStockRealMinimoPivoteFacadeLocal;
import Utility.Reporte;

/**
 *
 * @author lcevallos
 */
@ManagedBean
@ViewScoped
public class StockRealItemBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer anio;
	private Integer mes;
	private List<ConsolidadoStockRealMinimoPivote> listaConsolidadoItemStockMinimo;
	private List<ConsolidadoStockRealMinimoPivote> listaFiltradoConsolidadoItemStockMinimo;
	private Reporte rpt;
	private HashMap<String, Object> parametros;
	
	@EJB
	private ConsolidadoStockRealMinimoPivoteFacadeLocal consolidadoStockRealMinimoPivoteFacadeLocal;

	private ArrayList<String> selectedColumnsStocksMinimo = new ArrayList<>();
	private ArrayList<String> columnsStocksMinimo = new ArrayList<>();

	/**
	 * Creates a new instance of StockRealItemBean
	 */

	public StockRealItemBean() {
	}

	@PostConstruct
	public void init() {
		fillColumns();
	}

	public void fillColumns() {

		String[] columnas = { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre",
				"Noviembre", "Diciembre" };

		int limit = 0;
		if (mes == null)
			limit = columnas.length;
		else
			limit = mes.intValue();

		selectedColumnsStocksMinimo.clear();
		columnsStocksMinimo.clear();

		for (int index = 0; index < limit; index++) {
			String value = columnas[index];

			this.selectedColumnsStocksMinimo.add(value);
			this.columnsStocksMinimo.add(value);

		}
	}

	public void generarTablaStockMinimo() {

		try {

			this.listaConsolidadoItemStockMinimo = this.consolidadoStockRealMinimoPivoteFacadeLocal
					.findAll(this.anio);
			fillColumns();
			//RequestContext.getCurrentInstance()
				//	.update("tabView:frmStockMinimo");

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

	}// fin del generarTablaStockReal

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

	public List<ConsolidadoStockRealMinimoPivote> getListaConsolidadoItemStockMinimo() {
		return listaConsolidadoItemStockMinimo;
	}

	public void setListaConsolidadoItemStockMinimo(
			List<ConsolidadoStockRealMinimoPivote> listaConsolidadoItemStockMinimo) {
		this.listaConsolidadoItemStockMinimo = listaConsolidadoItemStockMinimo;
	}

	public List<ConsolidadoStockRealMinimoPivote> getListaFiltradoConsolidadoItemStockMinimo() {
		return listaFiltradoConsolidadoItemStockMinimo;
	}

	public void setListaFiltradoConsolidadoItemStockMinimo(
			List<ConsolidadoStockRealMinimoPivote> listaFiltradoConsolidadoItemStockMinimo) {
		this.listaFiltradoConsolidadoItemStockMinimo = listaFiltradoConsolidadoItemStockMinimo;
	}

	public ArrayList<String> getSelectedColumnsStocksMinimo() {
		return selectedColumnsStocksMinimo;
	}

	public void setSelectedColumnsStocksMinimo(
			ArrayList<String> selectedColumnsStocksMinimo) {
		this.selectedColumnsStocksMinimo = selectedColumnsStocksMinimo;
	}

	public ArrayList<String> getColumnsStocksMinimo() {
		return columnsStocksMinimo;
	}

	public void setColumnsStocksMinimo(ArrayList<String> columnsStocksMinimo) {
		this.columnsStocksMinimo = columnsStocksMinimo;
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

	public void exportarPDF() {

		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		parametros.put("inYear", this.anio);
		

		String path = "/reportes/stock_minimo_consolidado.jasper";

		try {
			rpt.exportarPDF(parametros, path, "stock_minimo_consolidado_"+this.anio);

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
		

		String path = "/reportes/stock_minimo_consolidado.jasper";

		try {
			rpt.verPDF(parametros, path, "stock_minimo_consolidado_"+this.anio);

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
	
	  public void exportarExcel(Object document) {
			HSSFWorkbook wb = (HSSFWorkbook) document;
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow header = sheet.getRow(0);

			HSSFCellStyle cellStyle = wb.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
				HSSFCell cell = header.getCell(i);

				cell.setCellStyle(cellStyle);
			}
		}
	
	
	

}
