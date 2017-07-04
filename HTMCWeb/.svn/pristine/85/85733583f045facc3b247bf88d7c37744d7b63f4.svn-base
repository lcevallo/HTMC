/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.context.RequestContext;
import org.primefaces.model.StreamedContent;

import Entities.ConsolidadoAnualPivote;
import Entities.PlantillaExcelCorte;
import SessionBeans.ConsolidadoAnualFacadeLocal;
import SessionBeans.ConsolidadoAnualPivoteFacadeLocal;
import SessionBeans.PlantillaExcelCorteFacadeLocal;
import Utility.MyUtil;
import Utility.Reporte;

/**
 *
 * @author lcevallos
 */
@ManagedBean
@ViewScoped
public class ConsolidadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Reporte rpt;
	private HashMap<String, Object> parametros;
	private ArrayList<String> selectedColumnsIngresos = new ArrayList<>();
	private ArrayList<String> columnsIngresos = new ArrayList<>();
	private ArrayList<String> selectedColumnsEgresos = new ArrayList<>();
	private ArrayList<String> columnsEgresos = new ArrayList<>();
	private StreamedContent fileExcel;

	private Integer anio;
	private Integer mes;
	private String percentil;
	
	private Date FechaCorteInicial;
	private Date FechaCorteFinal;
	
	
	Connection conn;

	private Integer cantidadMeses;

	@EJB
	private ConsolidadoAnualPivoteFacadeLocal consolidadoAnualPivoteFacadeLocal;
	@EJB
	private ConsolidadoAnualFacadeLocal consolidadoAnualFacadeLocal;

	@EJB
	private PlantillaExcelCorteFacadeLocal plantillaExcelCorteFacadeLocal;

	private List<ConsolidadoAnualPivote> listaConsolidadoAnualPivote;
	private List<PlantillaExcelCorte> listaExcelPlantillaCorte;

	private List<ConsolidadoAnualPivote> listaFiltradaConsolidadoAnualPivote;

	private ConsolidadoAnualPivote consolidadoAnualPivoteSeleccionado;

	private Date fechaCorte;

	@ManagedProperty(value = "#{percentilBean}")
	PercentilBean percentilBean;



	@ManagedProperty(value = "#{stockRealItemBean}")
	StockRealItemBean stockRealItemBean;

	@ManagedProperty(value = "#{dashboardBean}")
	DashboardBean dashboardBean;

	@ManagedProperty(value = "#{ingresoBean}")
	IngresoBean ingresoBean;

	@ManagedProperty(value = "#{egresoBean}")
	EgresoBean egresoBean;

	@ManagedProperty(value = "#{stockSFItemBean}")
	StockSFItemBean stockSFItemBean;

	@ManagedProperty(value = "#{caducidadBean}")
	CaducidadBean caducidadBean;

	public StockSFItemBean getStockSFItemBean() {
		return stockSFItemBean;
	}

	public void setStockSFItemBean(StockSFItemBean stockSFItemBean) {
		this.stockSFItemBean = stockSFItemBean;
	}

	@PostConstruct
	public void inicio() {
		
		Calendar calendario = Calendar.getInstance();

		fechaCorte = new Date();
		fechaCorte = consolidadoAnualFacadeLocal.getFechaCorte();
		calendario.setTime(fechaCorte);
		
		this.anio = calendario.get(Calendar.YEAR);
		this.mes=calendario.get(Calendar.MONTH)+1;
		
		
		fillColumns();

	}

	public ConsolidadoBean() {

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

	public CaducidadBean getCaducidadBean() {
		return caducidadBean;
	}

	public void setCaducidadBean(CaducidadBean caducidadBean) {
		this.caducidadBean = caducidadBean;
	}

	public IngresoBean getIngresoBean() {
		return ingresoBean;
	}

	public void setIngresoBean(IngresoBean ingresoBean) {
		this.ingresoBean = ingresoBean;
	}

	public PercentilBean getPercentilBean() {
		return percentilBean;
	}

	public void setPercentilBean(PercentilBean percentilBean) {
		this.percentilBean = percentilBean;
	}

	public EgresoBean getEgresoBean() {
		return egresoBean;
	}

	public void setEgresoBean(EgresoBean egresoBean) {
		this.egresoBean = egresoBean;
	}



	public StreamedContent getFileExcel() {
		return fileExcel;
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

		selectedColumnsIngresos.clear();
		columnsIngresos.clear();
		selectedColumnsEgresos.clear();
		columnsEgresos.clear();

		for (int index = 0; index < limit; index++) {
			String value = columnas[index];

			selectedColumnsIngresos.add(value);
			columnsIngresos.add(value);
			selectedColumnsEgresos.add(value);
			columnsEgresos.add(value);

		}
	}

	public Integer getCantidadMeses() {
		return cantidadMeses;
	}

	public void setCantidadMeses(Integer cantidadMeses) {
		this.cantidadMeses = cantidadMeses;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getAnio() {
		return anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}
	
	public Date getFechaCorteInicial() {
		return FechaCorteInicial;
	}

	public void setFechaCorteInicial(Date fechaCorteInicial) {
		FechaCorteInicial = fechaCorteInicial;
	}

	public Date getFechaCorteFinal() {
		return FechaCorteFinal;
	}

	public void setFechaCorteFinal(Date fechaCorteFinal) {
		FechaCorteFinal = fechaCorteFinal;
	}

	public StockRealItemBean getStockRealItemBean() {
		return stockRealItemBean;
	}

	public void setStockRealItemBean(StockRealItemBean stockRealItemBean) {
		this.stockRealItemBean = stockRealItemBean;
	}

	public List<ConsolidadoAnualPivote> getListaFiltradaConsolidadoAnualPivote() {
		return listaFiltradaConsolidadoAnualPivote;
	}

	public void setListaFiltradaConsolidadoAnualPivote(
			List<ConsolidadoAnualPivote> listaFiltradaConsolidadoAnualPivote) {
		this.listaFiltradaConsolidadoAnualPivote = listaFiltradaConsolidadoAnualPivote;
	}

	/* SECCION DE EVENTOS */
	public void fireSelectionAnio(ValueChangeEvent event) {
		try {

			this.anio = Integer.parseInt(event.getNewValue().toString());

		} catch (Exception exception) {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
							"Debe de seleccionar un año"));
		}

	}

	public void fireSelectionMes(ValueChangeEvent event) {
		try {
			this.mes = Integer.parseInt(event.getNewValue().toString());

		} catch (Exception exception) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
							"Debe de seleccionar un mes"));
		}

	}

	public void fireSelectionPercentil(ValueChangeEvent event) {

		try {
			if (event.getNewValue() != null)
				this.percentil = event.getNewValue().toString();
		} catch (Exception exception) {
			// FacesContext.getCurrentInstance().addMessage(
			// null,
			// new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
			// "Debe de seleccionar un mes"));
		}

	}

	/**** FIN DE SECCION DE EVENTOS **/

	public String getPercentil() {
		return percentil;
	}

	public void setPercentil(String percentil) {
		this.percentil = percentil;
	}

	/**
	 * @return the listaConsolidadoAnualPivote
	 */
	public List<ConsolidadoAnualPivote> getListaConsolidadoAnualPivote() {

		return this.listaConsolidadoAnualPivote;

	}

	/**
	 * @param listaConsolidadoAnualPivote
	 *            the listaConsolidadoAnualPivote to set
	 */
	public void setListaConsolidadoAnualPivote(
			List<ConsolidadoAnualPivote> listaConsolidadoAnualPivote) {
		this.listaConsolidadoAnualPivote = listaConsolidadoAnualPivote;
	}

	/**
	 * @return the consolidadoAnualPivoteSeleccionado
	 */
	public ConsolidadoAnualPivote getConsolidadoAnualPivoteSeleccionado() {
		return consolidadoAnualPivoteSeleccionado;
	}

	/**
	 * @param consolidadoAnualPivoteSeleccionado
	 *            the consolidadoAnualPivoteSeleccionado to set
	 */
	public void setConsolidadoAnualPivoteSeleccionado(
			ConsolidadoAnualPivote consolidadoAnualPivoteSeleccionado) {
		this.consolidadoAnualPivoteSeleccionado = consolidadoAnualPivoteSeleccionado;
	}

	public String ObtenerImagen(Boolean alerta) {
		String salida;
		if (alerta) {
			salida = "<img src=" + MyUtil.baseUrl()
					+ "resources/images/rojoSemaforo.jpg />";
		} else {
			salida = "";
		}

		return salida;
	}
	
	 public void abrirModalCorte()
     {
          RequestContext context = RequestContext.getCurrentInstance();
          context.execute("PF('excelCorteWidget').show();");
         
     }
	
	
	public void generarCorte() {
		
		
		this.listaExcelPlantillaCorte = this.plantillaExcelCorteFacadeLocal
				.findAllByFechas(this.FechaCorteInicial, this.FechaCorteFinal);

		this.abrirExcelCorte();
	
		
		
		
	}

	public void abrirExcelCorte() {
		Integer columna = 0;
		Integer fila = 0;
		Map<String,String> cabeceraValores = new HashMap<String,String>();
		
		try {
			rpt = new Reporte();

	
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			HttpServletResponse response = (HttpServletResponse) externalContext
					.getResponse();

			response.reset(); 
			response.setContentType("application/xlsx"); 
			response.setHeader("Content-disposition",
					"attachment; filename=\"Farmaco-SubDirección.xlsx\"");
		
	
			FileInputStream file = new FileInputStream(new File(
					rpt.getRutaExcelCorteFecha()));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(3);
					
			for (PlantillaExcelCorte temp : this.listaExcelPlantillaCorte) {
				columna = temp.getPlantillaExcelCortePK().getColumna();
				fila = temp.getPlantillaExcelCortePK().getFila();

				Cell cell = workbook.getSheetAt(3).getRow(fila - 1)
						.getCell(columna - 1);

				cell.setCellValue((double) temp.getSaldosAnteriores()
						.intValue());			
				
				columna++;
				cell = workbook.getSheetAt(3).getRow(fila - 1)
						.getCell(columna - 1);
				
				cell.setCellValue((double) temp.getIngresos().intValue());
				
				
				columna++;
				cell = workbook.getSheetAt(3).getRow(fila - 1)
						.getCell(columna - 1);

				cell.setCellValue((double) temp.getEgresos().intValue());
				
				
				columna++;
				cell = workbook.getSheetAt(3).getRow(fila - 1)
						.getCell(columna - 1);

				cell.setCellValue((double) temp.getSaldos().intValue());

				
			}
			/** COLOCO LOS TITULOS **/
			cabeceraValores=this.obtenerTitulosExcel(this.FechaCorteInicial, this.FechaCorteFinal);
			fila=12;
			columna=9;
			
			Cell cell = workbook.getSheetAt(3).getRow(fila - 1)
					.getCell(columna - 1);
			
			cell.setCellValue(cabeceraValores.get("I12"));
			
			columna++;
			
			
			cell = workbook.getSheetAt(3).getRow(fila - 1)
					.getCell(columna - 1);
			cell.setCellValue(cabeceraValores.get("J12"));
		
			columna++;
			
			
			cell = workbook.getSheetAt(3).getRow(fila - 1)
					.getCell(columna - 1);
			cell.setCellValue(cabeceraValores.get("K12"));
		
			columna++;
			
			
			cell = workbook.getSheetAt(3).getRow(fila - 1)
					.getCell(columna - 1);
			cell.setCellValue(cabeceraValores.get("L12"));
		
		
			
			/*** FIN DE LOS TITULOS **/
				
			OutputStream out = new BufferedOutputStream(response.getOutputStream());

			workbook.write(out);

			file.close();
			out.close();

			facesContext.responseComplete();
			
			/*
			RequestContext.getCurrentInstance().reset("formDialogCorteExcel");
			RequestContext.getCurrentInstance().execute("PF('excelCorteWidget').hide();");
			*/

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Map<String,String> obtenerTitulosExcel(Date ini, Date fin)
	{
		
		Map<String,String> cabeceraValores = new HashMap<String,String>();
		Date fechaAnteriorAlInicio=new Date();
		Calendar cal = Calendar.getInstance();		    
		cal.setTime(ini);			
		String mesInicial = MyUtil.getMes(cal.get(Calendar.MONTH));
		int diaDelMesInicial = cal.get(Calendar.DAY_OF_MONTH);
		int anioMesInicial=cal.get(Calendar.YEAR);
		
		cal.add(Calendar.DATE, -1);
		fechaAnteriorAlInicio=cal.getTime();			
		cal.setTime(fechaAnteriorAlInicio);
		
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");	
		String formatted = format1.format(cal.getTime());
		
		String I12="SALDOS EXISTENTES\nEN LA UNIDAD MÉDICA\nAL "+formatted +"\n(cantidad en unidades)";
		
		cal.setTime(fin);
		String mesFinal = MyUtil.getMes(cal.get(Calendar.MONTH));
		int diaDelMesFinal = cal.get(Calendar.DAY_OF_MONTH);
		int anioMesFinal=cal.get(Calendar.YEAR);
		String formatted2 = format1.format(cal.getTime());
		
		
		String J12="INGRESOS DEL "+diaDelMesInicial+" DE "+mesInicial.toUpperCase()+" AL "+diaDelMesFinal+"\nDE "+mesFinal.toUpperCase()+" "+anioMesFinal+"\n(cantidad en unidades)";
		
		
		String K12="EGRESOS DESPACHADOS\n DEL "+diaDelMesInicial+" DE "+mesInicial.toUpperCase()+" AL "+diaDelMesFinal+"\nDE "+mesFinal.toUpperCase()+" "+anioMesFinal+"\n(cantidad en unidades)";
		
		
		String L12="SALDOS\nAL "+formatted2+"\n(cantidad en unidades)";
		
		
		cabeceraValores.put("I12", I12);
		cabeceraValores.put("J12", J12);
		cabeceraValores.put("K12", K12);
		cabeceraValores.put("L12", L12);
		
		return cabeceraValores;
		
		
	}
	
	
	public void generarInformacionAnual() {

		if (this.anio != null && this.mes != null) {

			try {

				// this.consolidadoAnualFacadeLocal.generarProcesos(this.anio,this.mes);

				this.listaConsolidadoAnualPivote = this.consolidadoAnualPivoteFacadeLocal
						.findAll(this.anio, this.mes);

				percentilBean.setAnio(this.anio);
				percentilBean.generarTablaPercentil();
	

				stockRealItemBean.setAnio(this.anio);
				stockRealItemBean.setMes(this.mes);
				stockRealItemBean.generarTablaStockMinimo();

				ingresoBean.setAnio(this.anio);
				ingresoBean.setMes(this.mes);

				egresoBean.setAnio(this.anio);
				egresoBean.setMes(this.mes);

				stockSFItemBean.setAnio(this.anio);
				stockSFItemBean.setMes(this.mes);
				stockSFItemBean.getTableStockPivoteSf();

				caducidadBean.setAnio(this.anio);
				caducidadBean.setMes(this.mes);

				dashboardBean.setYear(this.anio);
				dashboardBean.setMonth(this.mes);
				dashboardBean.drawModels();

				fillColumns();

				// RequestContext.getCurrentInstance().update("tabView");

			} catch (PersistenceException he) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
								he.getMessage()));

			}

			catch (Exception e) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
								e.getMessage()));
			}

		} else {

			// FacesContext.getCurrentInstance().addMessage(
			// null,
			// new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
			// "Debe de seleccionar un Año!!"));
		}

	}// fin del metodo generarInformacionAnual

	public ArrayList<String> getSelectedColumnsIngresos() {
		return selectedColumnsIngresos;
	}

	public void setSelectedColumnsIngresos(
			ArrayList<String> selectedColumnsIngresos) {
		this.selectedColumnsIngresos = selectedColumnsIngresos;
	}

	public ArrayList<String> getColumnsIngresos() {
		return columnsIngresos;
	}

	public void setColumnsIngresos(ArrayList<String> columnsIngresos) {
		this.columnsIngresos = columnsIngresos;
	}

	public ArrayList<String> getSelectedColumnsEgresos() {
		return selectedColumnsEgresos;
	}

	public void setSelectedColumnsEgresos(
			ArrayList<String> selectedColumnsEgresos) {
		this.selectedColumnsEgresos = selectedColumnsEgresos;
	}

	public ArrayList<String> getColumnsEgresos() {
		return columnsEgresos;
	}

	public void setColumnsEgresos(ArrayList<String> columnsEgresos) {
		this.columnsEgresos = columnsEgresos;
	}

	public DashboardBean getDashboardBean() {
		return dashboardBean;
	}

	public void setDashboardBean(DashboardBean dashboardBean) {
		this.dashboardBean = dashboardBean;
	}

	public Date getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	public void exportarExcelGeneral() {

		if (this.listaConsolidadoAnualPivote != null) {
			rpt = new Reporte();
			parametros = new HashMap<String, Object>();

			parametros.put("inYear", this.anio);

			String path = "/reportes/rpt_consolidado_general_excel.jasper";

			try {
				rpt.exportarXLS(parametros, path, "reporte_general_"
						+ this.anio);

			} catch (JRException je) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
								je.getMessage()));
				je.printStackTrace();
			} catch (IOException ie) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
								ie.getMessage()));
				ie.printStackTrace();
			} catch (NumberFormatException e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
								"Debe de seleccionar un aï¿½o"));
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Error",
							"No existe informacion que exportar"));

		}

	}

}
