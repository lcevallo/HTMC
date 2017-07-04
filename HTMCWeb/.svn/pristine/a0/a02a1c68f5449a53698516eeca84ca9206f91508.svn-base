/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import Entities.VistaConsolidadoStockRealPivote;
import SessionBeans.VistaConsolidadoStockRealPivoteFacadeLocal;

@ManagedBean
@ViewScoped
public class DashboardBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EJB
	VistaConsolidadoStockRealPivoteFacadeLocal consolidadoStockRealPivoteFacadeLocal;

	static String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
			"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
			"Diciembre" };

	private String[] especialidades = {};

	private Integer year;
	private Integer month;

	private DashboardModel model;

	private LineChartModel lineModelOnco;
	private LineChartModel lineModelRetro;
	private LineChartModel lineModelHemo;
	private LineChartModel lineModelCNMB;

	private List<VistaConsolidadoStockRealPivote> lista;

	private List<LineChartModel> charts;

	@PostConstruct
	public void init() {

	}

	private void createLineModels() {

		charts = new ArrayList<LineChartModel>();
		especialidades = new String[lista.size()];
		// for (int i = 0; i < especialidades.length; i++)
		// charts.add(new LineChartModel());

		int index = 0;

		// for (LineChartModel chart : charts) {
				
		for (VistaConsolidadoStockRealPivote vista : lista) {

			LineChartModel chart = initCategoryModel(vista);

			// chart.setTitle(especialidades[index]);
			// chart.setTitle(vista.getAreaDescripcion());
			especialidades[index++] = vista.getAreaDescripcion();

			// lineModelOnco.setLegendPosition("e");
			chart.setShowPointLabels(true);
			chart.setZoom(true);
			chart.getAxes().put(AxisType.X, new CategoryAxis("Meses"));

			Axis xAxis = chart.getAxis(AxisType.X);
			xAxis.setLabel("Meses");
			xAxis.setTickAngle(-50);

			Axis yAxis = chart.getAxis(AxisType.Y);
			yAxis.setLabel("Cantidad");

			List<Long> numbers = orderList(vista);

			// int min = String.valueOf(Math.abs(numbers.get(0))).length();
			// int max = String.valueOf(Math.abs(numbers.get(11))).length();

			// System.out.println(min);
			// System.out.println(max);

			yAxis.setMin((numbers.get(0) * 2) - 100);
			yAxis.setMax((numbers.get(11) * 2) + 100);

			// charts.set(index++, chart);
			charts.add(chart);
		}

	}

	private LineChartModel initCategoryModel(
			VistaConsolidadoStockRealPivote vista) {
		LineChartModel model = new LineChartModel();

		ChartSeries serie = new ChartSeries();
		serie.setLabel("Fármacos");

		serie.set(meses[0].substring(0, 3), vista.getSumaEne());
		serie.set(meses[1].substring(0, 3), vista.getSumaFeb());
		serie.set(meses[2].substring(0, 3), vista.getSumaMar());
		serie.set(meses[3].substring(0, 3), vista.getSumaAbr());
		serie.set(meses[4].substring(0, 3), vista.getSumaMay());
		serie.set(meses[5].substring(0, 3), vista.getSumaJun());
		serie.set(meses[6].substring(0, 3), vista.getSumaJul());
		serie.set(meses[7].substring(0, 3), vista.getSumaAgo());
		serie.set(meses[8].substring(0, 3), vista.getSumaSep());
		serie.set(meses[9].substring(0, 3), vista.getSumaOct());
		serie.set(meses[10].substring(0, 3), vista.getSumaNov());
		serie.set(meses[11].substring(0, 3), vista.getSumaDic());

		model.addSeries(serie);

		return model;
	}

	public List<Long> orderList(VistaConsolidadoStockRealPivote vista) {

		List<Long> numbers = new ArrayList<Long>();
		numbers.add(vista.getSumaEne());
		numbers.add(vista.getSumaFeb());
		numbers.add(vista.getSumaMar());
		numbers.add(vista.getSumaAbr());
		numbers.add(vista.getSumaMay());
		numbers.add(vista.getSumaJun());
		numbers.add(vista.getSumaJul());
		numbers.add(vista.getSumaAgo());
		numbers.add(vista.getSumaSep());
		numbers.add(vista.getSumaOct());
		numbers.add(vista.getSumaNov());
		numbers.add(vista.getSumaDic());
		Collections.sort(numbers);
		return numbers;

	}

	public void drawModels() {
		try {

			//lista = consolidadoStockRealPivoteFacadeLocal.findAll();
			lista = consolidadoStockRealPivoteFacadeLocal.findAllByYear(this.year);
			
			createLineModels();

			//RequestContext.getCurrentInstance().update("tabView:form");
		} catch (Exception exception) {
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
							exception.getMessage()));
		}

	}

	public LineChartModel getLineModelRetro() {
		return lineModelRetro;
	}

	public LineChartModel getLineModelHemo() {
		return lineModelHemo;
	}

	public LineChartModel getLineModelCNMB() {
		return lineModelCNMB;
	}

	public LineChartModel getLineModelOnco() {
		return lineModelOnco;
	}

	public DashboardModel getModel() {
		return model;
	}

	public void setModel(DashboardModel model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public List<LineChartModel> getCharts() {
		return charts;
	}

	public void setCharts(List<LineChartModel> charts) {
		this.charts = charts;
	}

	public String[] getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(String[] especialidades) {
		this.especialidades = especialidades;
	}

}