/*
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.component.api.UIColumn;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;

import Entities.Item;
import Entities.MatrixCode;
import Entities.MatrixCodePK;
import Entities.UnidadDependencia;
import SessionBeans.ItemFacadeLocal;
import SessionBeans.MatrixCodeFacadeLocal;
import SessionBeans.UnidadDependenciaFacadeLocal;

/**
 *
 * @author BryanV
 */
@ManagedBean
@ViewScoped
public class MatrixCodeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ItemFacadeLocal ItemFacadeLocal;
	@EJB
	private UnidadDependenciaFacadeLocal unidadDependenciaFacadeLocal;
	@EJB
	private MatrixCodeFacadeLocal matrixCodeFacadeLocal;

	private List<Item> listaMedicamento;
	private List<Item> filteredListaMedicamento;

	private List<UnidadDependencia> unidadDependencias;
	private List<MatrixCode> matrixCodes;
	private List<UnidadDependencia> respaldoUnidadDependencias = new ArrayList<UnidadDependencia>();

	private HashMap<String, String> map;

	private ArrayList<String> selectedColumns = new ArrayList<>();
	private ArrayList<String> columns = new ArrayList<>();

	public MatrixCodeBean() {

	}

	@PostConstruct
	public void inicio() {

		listaMedicamento = ItemFacadeLocal.findAll();
		unidadDependencias = unidadDependenciaFacadeLocal.findAll();
		matrixCodes = matrixCodeFacadeLocal.findAll();
		respaldoUnidadDependencias.addAll(unidadDependencias);

		map = new HashMap<String, String>();

		for (int index = 0; index < matrixCodes.size(); index++) {

			MatrixCode matrixCode = matrixCodes.get(index);
			map.put(matrixCode.getItem().getCodigoItem() + "-"
					+ matrixCode.getUnidadDependencia().getId(),
					matrixCode.getCodigo());
		}

	}

	public void actualizarEstado(AjaxBehaviorEvent event) {
		String codItem = "";
		Integer idDependencia = new Integer(0);
		UIInput component = (UIInput) event.getComponent();
		codItem = (String) component.getAttributes().get("idItem");
		idDependencia = (Integer) component.getAttributes()
				.get("idDependencia");
		InputText inputText = (InputText) event.getSource();

		String value = (String) inputText.getValue();

		System.out.println(value);
		System.out.println(codItem + "-" + idDependencia);

		if (value != null && !value.isEmpty()) {

			MatrixCode matrixCode = new MatrixCode();
			MatrixCodePK matrixCodePK = new MatrixCodePK();
			matrixCodePK.setItemFk(codItem);
			matrixCodePK.setIdDependencia(idDependencia);
			matrixCode.setId(matrixCodePK);
			try {
				matrixCode = matrixCodeFacadeLocal.find(matrixCodePK);
				if (matrixCode != null) {
					System.out.println("Existe.");
					if (!value.equals(matrixCode.getCodigo())) {
						System.out.println("Editando.");
						matrixCode.setCodigo(value);
						matrixCodeFacadeLocal.edit(matrixCode);
					} else
						System.out.println("Nothing to change.");
				} else {
					System.out.println("No existe.");
					matrixCode = new MatrixCode();
					matrixCode.setId(matrixCodePK);
					Item item = new Item();
					item.setCodigoItem(codItem);
					matrixCode.setItem(item);
					UnidadDependencia unidadDependencia = new UnidadDependencia();
					unidadDependencia.setId(idDependencia);
					matrixCode.setUnidadDependencia(unidadDependencia);
					matrixCode.setCodigo(value);
					matrixCodeFacadeLocal.create(matrixCode);
				}

				map.put(matrixCode.getItem().getCodigoItem() + "-"
						+ matrixCode.getUnidadDependencia().getId(),
						matrixCode.getCodigo());
			} catch (Exception exception) {
				System.out.println(exception.getMessage());

			}
		} else
			System.out.println("Nothing to do.");

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
		//
		// }
		// }

		String value;
		for (int index = 0; index < unidadDependencias.size(); index++) {
			value = unidadDependencias.get(index).getNombreUnidad();
			selectedColumns.add(value);
			columns.add(value);

		}

	}

	@SuppressWarnings("unchecked")
	public void valueChange(ValueChangeEvent event) {

		ArrayList<String> nuevosElementos = (ArrayList<String>) event
				.getNewValue();
		unidadDependencias = new ArrayList<UnidadDependencia>();
		for (String string : nuevosElementos) {
			unidadDependencias.add(findUnidadDependencia(string));
		}

	}

	public UnidadDependencia findUnidadDependencia(String code) {

		for (UnidadDependencia unidadDependencia : respaldoUnidadDependencias) {
			if (unidadDependencia.getNombreUnidad().equals(code))
				return unidadDependencia;
		}
		return null;

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

	public ArrayList<String> getSelectedColumns() {
		return selectedColumns;
	}

	public void setSelectedColumns(ArrayList<String> selectedColumns) {
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

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public List<UnidadDependencia> getUnidadDependencias() {
		return unidadDependencias;
	}

	public void setUnidadDependencias(List<UnidadDependencia> unidadDependencias) {
		this.unidadDependencias = unidadDependencias;
	}

	public List<MatrixCode> getMatrixCodes() {
		return matrixCodes;
	}

	public void setMatrixCodes(List<MatrixCode> matrixCodes) {
		this.matrixCodes = matrixCodes;
	}

	public List<UnidadDependencia> getRespaldoUnidadDependencias() {
		return respaldoUnidadDependencias;
	}

	public void setRespaldoUnidadDependencias(
			List<UnidadDependencia> respaldoUnidadDependencias) {
		this.respaldoUnidadDependencias = respaldoUnidadDependencias;
	}

}
