package ManagedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import net.sf.jasperreports.engine.JRException;
import Utility.Reporte;




@ManagedBean
@ViewScoped
public class OpcionesCaducidadBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Reporte rpt;
	private HashMap<String, Object> parametros;
	
	private Integer mes;
	private Integer anio;
	private String color;
	private String nombre_archivo;
	
	public OpcionesCaducidadBean() {
		this.rpt = new Reporte();
	}

	
	
	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
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

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
		
		switch (this.color) {
		case "V":
			this.nombre_archivo=this.nombre_archivo+"_estables";
			break;
		case "R":
			this.nombre_archivo=this.nombre_archivo+"_caducados";
			break;
		case "A":
			this.nombre_archivo=this.nombre_archivo+"_por_vencer";
			break;
		}
	}
	
	
	/**
    Seccion para repotes *
    */
	public void exportarPDF() {

		rpt = new Reporte();
		parametros = new HashMap<String, Object>();
       
		
		parametros.put("inYear", this.anio);
		parametros.put("inMes", this.mes);
		parametros.put("incolor",this.color);
		
		
		
		
	
		String path = "/reportes/caducidad_x_anio_x_mes.jasper";

		try {
			rpt.exportarPDF(parametros, path, "caducidad_x_year_and_month");

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

	}// Fin del metodo exportarPDFEgreso

	public void verPdf() {
		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		parametros.put("inYear", this.anio);
		parametros.put("inMes", this.mes);
		parametros.put("incolor",this.color);
			
				
		String path = "/reportes/caducidad_x_anio_x_mes.jasper";

		try {
			rpt.verPDF(parametros, path, "caducidad_x_year_and_month");

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

	}//fin del metodo VerPdf
	
	public void exportarExcel()
	{
		
		rpt = new Reporte();
		parametros = new HashMap<String, Object>();

		parametros.put("inYear", this.anio);
		parametros.put("inMes", this.mes);
		parametros.put("incolor",this.color);
			
				
		String path = "/reportes/caducidad_x_anio_x_mes_excel.jasper";

		try {
			rpt.exportarXLS(parametros, path, "caducidad_x_year_and_month");

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
	
		
		
	}
	
	
   /**
      FIN DE LA SECCION PARA REPOTE *
   */
	
	
	
}
