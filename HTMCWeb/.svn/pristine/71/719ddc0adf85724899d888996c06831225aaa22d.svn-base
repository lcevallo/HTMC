/*
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

import Entities.ApplicationArea;
import Entities.AreaItem;
import Entities.AreaItemPK;
import Entities.Item;
import SessionBeans.ApplicationAreaFacadeLocal;
import SessionBeans.AreaItemFacadeLocal;
import SessionBeans.ItemFacadeLocal;

/**
 *
 * @author BryanV
 */
@ManagedBean
@ViewScoped
public class ItemEspecialidadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ItemFacadeLocal ItemFacadeLocal;
	@EJB
	private ApplicationAreaFacadeLocal applicationAreaFacadeLocal;
	@EJB
	private AreaItemFacadeLocal areaItemFacadeLocal;

	private List<Item> listaMedicamento;
	private List<Item> filteredListaMedicamento;

	private List<ApplicationArea> applicationAreas;
	private List<AreaItem> areaItems;
	private List<ApplicationArea> respaldoApplicationAreas = new ArrayList<ApplicationArea>();

	// private List<Object[]> dataModel;

	private HashMap<String, Boolean> map;

	private ArrayList<String> selectedColumns = new ArrayList<>();
	private ArrayList<String> columns = new ArrayList<>();

	public ItemEspecialidadBean() {

	}

	private List<Double> prueba = new ArrayList<Double>();
	private List<Double> filteredPrueba;

	public List<Double> getFilteredPrueba() {
		return filteredPrueba;
	}

	public void setFilteredPrueba(List<Double> filteredPrueba) {
		this.filteredPrueba = filteredPrueba;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean filtrarConRango(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals(""))
			return true;

		if (value == null)
			return false;

		String pattern = "([-]?\\d+(?:\\.\\d+)?)";
		if (filterText.matches(pattern))
			return new BigDecimal(value.toString()).compareTo(new BigDecimal(
					filterText)) == 0;

		pattern = "([-]?\\d+(?:\\.\\d+)?):([-]?\\d+(?:\\.\\d+)?)";
		if (filterText.matches(pattern)) {
			String[] array = filterText.split(":");
			BigDecimal min = new BigDecimal(array[0]);
			BigDecimal max = new BigDecimal(array[1]);
			return new BigDecimal(value.toString()).compareTo(min) >= 0
					&& new BigDecimal(value.toString()).compareTo(max) <= 0;
		}

		pattern = "^<([-]?\\d+(?:\\.\\d+)?)$";
		if (filterText.matches(pattern)) {
			String texto = filterText.replace("<", "");
			return ((Comparable) new BigDecimal(value.toString()))
					.compareTo(new BigDecimal(texto)) < 0;
		}

		pattern = "^<=([-]?\\d+(?:\\.\\d+)?)$";
		if (filterText.matches(pattern)) {
			String texto = filterText.replace("<=", "");
			return ((Comparable) new BigDecimal(value.toString()))
					.compareTo(new BigDecimal(texto)) <= 0;
		}

		pattern = "^>=([-]?\\d+(?:\\.\\d+)?)$";
		if (filterText.matches(pattern)) {
			String texto = filterText.replace(">=", "");
			return ((Comparable) new BigDecimal(value.toString()))
					.compareTo(new BigDecimal(texto)) >= 0;
		}

		return value.toString().compareTo(filterText) == 0;

	}

	@PostConstruct
	public void inicio() {
		prueba.add(new Double(0.25));
		prueba.add(new Double(1));
		prueba.add(new Double(2));
		prueba.add(new Double(-58));
		prueba.add(new Double(69));
		prueba.add(new Double(3.25));
		prueba.add(new Double(7.25));
		prueba.add(new Double(-96));

		listaMedicamento = ItemFacadeLocal.findAll();

		applicationAreas = applicationAreaFacadeLocal.findAll();

		// areaItems = areaItemFacadeLocal.findAllOrdered();
		areaItems = areaItemFacadeLocal.findAll();
		// dataModel = areaItemFacadeLocal.getData();

		respaldoApplicationAreas.addAll(applicationAreas);

		map = new HashMap<String, Boolean>();

		for (int index = 0; index < areaItems.size(); index++) {

			AreaItem areaItem = areaItems.get(index);
			map.put(areaItem.getItem().getCodigoItem() + "-"
					+ areaItem.getApplicationArea().getIdArea(),
					areaItem.getEstado());
		}

	}

	@SuppressWarnings("unchecked")
	public void valueChange(ValueChangeEvent event) {

		ArrayList<String> nuevosElementos = (ArrayList<String>) event
				.getNewValue();
		applicationAreas = new ArrayList<ApplicationArea>();
		for (String string : nuevosElementos) {

			applicationAreas.add(findApplicationArea(string));
		}

	}

	public ApplicationArea findApplicationArea(String especialidad) {

		for (ApplicationArea applicationArea : respaldoApplicationAreas) {
			if (applicationArea.getAreaDescripcion().equals(especialidad))
				return applicationArea;
		}
		return null;

	}

	public List<Double> getPrueba() {
		return prueba;
	}

	public void setPrueba(List<Double> prueba) {
		this.prueba = prueba;
	}

	public void actualizarEstado(AjaxBehaviorEvent event) {
		String codItem = "";
		Integer idEspecialidad = new Integer(0);
		UIInput component = (UIInput) event.getComponent();
		codItem = (String) component.getAttributes().get("idItem");
		System.out.println(component.getAttributes().get("idItem").getClass());
		idEspecialidad = (Integer) component.getAttributes().get(
				"idEspecialidad");
		SelectBooleanCheckbox checkbox = (SelectBooleanCheckbox) event
				.getSource();
		Boolean value = (Boolean) checkbox.getValue();
		System.out.println(value);

		System.out.println(codItem + "-" + idEspecialidad);
		AreaItem areaItem = new AreaItem();
		areaItem = areaItemFacadeLocal.exists(codItem, idEspecialidad);
		if (areaItem != null) {
			System.out.println("Existe, cambio estado.");
			areaItem.setEstado(value);
			areaItemFacadeLocal.edit(areaItem);

		} else {

			System.out.println("No existe, creando estado.");
			areaItem = new AreaItem();

			ApplicationArea applicationArea = new ApplicationArea();
			applicationArea.setIdArea(idEspecialidad);

			Item item = new Item();
			item.setCodigoItem(codItem);

			AreaItemPK areaItemPK = new AreaItemPK();
			areaItemPK.setAreaFk(idEspecialidad);
			areaItemPK.setItemFk(codItem);

			areaItem.setId(areaItemPK);
			areaItem.setApplicationArea(applicationArea);
			areaItem.setItem(item);
			areaItem.setEstado(value);

			areaItemFacadeLocal.create(areaItem);

		}

		map.put(areaItem.getItem().getCodigoItem() + "-"
				+ areaItem.getApplicationArea().getIdArea(), value);

	}

	public void fillColumns(String tableName) {
		// DataTable table = (DataTable) FacesContext.getCurrentInstance()
		// .getViewRoot().findComponent(tableName);
		// List<UIColumn> tableColumns = table.getColumns();
		// for (int index = 0; index < tableColumns.size(); index++) {
		// String value = tableColumns.get(index).getHeaderText();
		// if (!(value.equals("Fármaco") || value.equals("Código"))) {
		// selectedColumns.add(value);
		// columns.add(value);
		// }
		// }

		// <c:forEach var="column"
		// items="#{itemEspecialidadBean.applicationAreas}">
		// <p:column headerText="#{column.areaDescripcion}"
		// style="width:150px;"
		// rendered="#{itemEspecialidadBean.selectedColumns.contains(column.areaDescripcion)}">
		// <p:selectBooleanCheckbox
		// value="#{itemEspecialidadBean.map.get(record.codigoItem.concat('-').concat(column.idArea))}">
		// <p:ajax event="change"
		// listener="#{itemEspecialidadBean.actualizarEstado}"
		// /><!-- update=":#{p:component('itemsTable')}, :form:panel" -->
		// <f:attribute name="idItem" value="#{record.codigoItem}" />
		// <f:attribute name="idEspecialidad" value="#{column.idArea}" />
		// </p:selectBooleanCheckbox>
		// </p:column>
		// </c:forEach>
		//

		String[] defaultApplications = { "ONCOLOGÍA", "RETROVIRAL" };
		List<String> list = (List<String>) Arrays.asList(defaultApplications);
		selectedColumns.addAll(list);

		for (ApplicationArea applicationArea : applicationAreas) {
			columns.add(applicationArea.getAreaDescripcion());
		}
	}

	public void postProcessXLS(Object document) {
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

	private void log(Object object) {
		String methodName = Thread.currentThread().getStackTrace()[2]
				.getMethodName();
		System.out.println("MyBean " + methodName + ": " + object);
	}

	public ArrayList<String> getSelectedColumns() {
		// log(selectedColumns);
		return selectedColumns;
	}

	public void setSelectedColumns(ArrayList<String> selectedColumns) {
		// log(selectedColumns);
		this.selectedColumns = selectedColumns;
	}

	public ArrayList<String> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}

	public List<Item> getListaMedicamento() {
		return listaMedicamento;
	}

	public void setListaMedicamento(List<Item> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}

	public List<Item> getFilteredListaMedicamento() {
		return filteredListaMedicamento;
	}

	public void setFilteredListaMedicamento(List<Item> filteredListaMedicamento) {
		this.filteredListaMedicamento = filteredListaMedicamento;
	}

	public List<ApplicationArea> getApplicationAreas() {
		return applicationAreas;
	}

	public void setApplicationAreas(List<ApplicationArea> applicationAreas) {
		this.applicationAreas = applicationAreas;
	}

	public List<AreaItem> getAreaItems() {
		return areaItems;
	}

	public void setAreaItem(List<AreaItem> areaItems) {
		this.areaItems = areaItems;
	}

	public HashMap<String, Boolean> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Boolean> map) {
		this.map = map;
	}

	// public List<Object[]> getDataModel() {
	// return dataModel;
	// }
	//
	// public void setDataModel(List<Object[]> dataModel) {
	// this.dataModel = dataModel;
	// }

}
