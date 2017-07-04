package Utility;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import Entities.Usuario;

public class Reporte {

	Connection conn;
	private DateFormat dateFormat;
	private Calendar calendar;
	private String fecha_ruta;
	private String nombre_usuario;

	public Reporte() {
		this.calendar = Calendar.getInstance();
		this.dateFormat = new SimpleDateFormat("dd_MM_YYYY_HH_mm");
		this.fecha_ruta = this.dateFormat.format(this.calendar.getTime());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		Usuario usuario = (Usuario) session.getAttribute("userInSession");

		if (usuario != null) {

			this.nombre_usuario = usuario.getApellido() + "_"
					+ usuario.getNombre();

		} else {
			this.nombre_usuario = "Desconocido";

		}

	}
	
	public String getRutaExcelCorteFecha()
	{
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		
		String ruta=servletContext.getRealPath("") + File.separator+"reportes"+File.separator+"plantilla_HTMC_Farmaco_FINAL.xlsx";
		return ruta;
		
	}	
	
	public String getLogo() {

		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String logo = servletContext.getRealPath("") + File.separator
				+ "resources" + File.separator + "images" + File.separator
				+ "LOGO_HTMC.png";
		return logo;
	}

	public void exportarPDF(HashMap<String, Object> parametros, String path,
			String nombre_reporte) throws JRException, IOException {

		nombre_reporte = this.nombre_usuario + "_" + nombre_reporte + "_"
				+ this.fecha_ruta;

		parametros.put("nombre_usuario", this.nombre_usuario);
		parametros.put("logo", this.getLogo());

		this.conn = ConnectionPostgres.Conectar();
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(path));
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				jasper.getPath(), parametros, conn);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();

		response.addHeader("Content-disposition", "attachment; filename="
				+ nombre_reporte + ".pdf");
		ServletOutputStream stream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();

	}// Fin del metodo exportarPDFIngreso

	public void verPDF(HashMap<String, Object> parametros, String path,
			String nombre_reporte) throws JRException, IOException {

		parametros.put("nombre_usuario", this.nombre_usuario);
		parametros.put("logo", this.getLogo());

		this.conn = ConnectionPostgres.Conectar();

		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(path));
		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(),
				parametros, conn);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);

		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0, bytes.length);

		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();

	}// FIN DEL METODO verPDFIngreso

	public void exportarXLS(HashMap<String, Object> parametros, String path,
			String nombre_reporte) throws JRException, IOException {
	
		
		parametros.put("nombre_usuario", this.nombre_usuario);
		
		this.conn = ConnectionPostgres.Conectar();
		
		
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath(path));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conn);
	
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename="+nombre_reporte+".xls");
		ServletOutputStream stream = response.getOutputStream();
		JRXlsExporter exporter = new JRXlsExporter();
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
		exporter.exportReport();
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}// EXPORTAR A EXCEL

}
