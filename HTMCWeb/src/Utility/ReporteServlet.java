/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import Entities.Usuario;

/**
 *
 * @author Luis Cevallos
 */
@WebServlet(name = "Retrieve PDF Reports", urlPatterns = "/pdf")
public class ReporteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection conn;
	private DateFormat dateFormat;
	private String path = "/reportes/";
	private Calendar calendar;
	private String fecha_ruta;
	private String nombre_usuario;
	private String logo;
	private String ruta_ExcelCorteFecha;
	HashMap<String, Object> parametros;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InitialContext initialContext;
		this.parametros = new HashMap<String, Object>();
		this.calendar = Calendar.getInstance();
		this.dateFormat = new SimpleDateFormat("dd_MM_YYYY_HH_mm");
		this.fecha_ruta = this.dateFormat.format(this.calendar.getTime());
		this.logo = request.getServletContext().getRealPath("") + File.separator + "resources" + File.separator
				+ "images" + File.separator + "LOGO_HTMC.png";

		this.ruta_ExcelCorteFecha = request.getServletContext().getRealPath("") + File.separator + "reportes"
				+ File.separator + "plantilla_HTMC_Farmaco_FINAL.xlsx";

		try {
			initialContext = new InitialContext();
			DataSource dataSource = (DataSource) initialContext.lookup("java:/PostgreSQL");
			this.conn = dataSource.getConnection();
		} catch (NamingException | SQLException e) {

			e.printStackTrace();
		}

		Usuario usuario = (Usuario) request.getSession().getAttribute("userInSession");

		if (usuario != null) {

			this.nombre_usuario = usuario.getApellido() + "_" + usuario.getNombre();

		} else {
			this.nombre_usuario = "Desconocido";
		}

		Map<String, String[]> requestParams = request.getParameterMap();
		if (this.escogerArchivo(requestParams)) {
			File jasper = new File(request.getRealPath(path));

			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(jasper.getPath(), parametros, conn);
			} catch (JRException e) {

				e.printStackTrace();
			}

			this.refrescarVariables();
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);

			response.getOutputStream().write(bytes, 0, bytes.length);

		} else {

			this.refrescarVariables();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>" + "No existe ese archivo men" + "</h1>");

		}

	}

	public boolean escogerArchivo(Map<String, String[]> params) {
		boolean salida = false;
		Integer inYear;
		for (Map.Entry<String, String[]> entry : params.entrySet()) {
			String key = entry.getKey(); // parameter name
			String[] value = entry.getValue(); // parameter values as array
			String valueString = "";

			if (value.length > 1) {
				for (int i = 0; i < value.length; i++) {
					valueString += value[i] + " ";
				}
			} else {
				valueString = value[0];
			}

			if (key.equals("archivo")) {
				this.path = this.path + valueString.replace("\"", "");
			} else {
				parametros.put(key, valueString);

			}

		}// fin del bloque for

		switch (this.path) {
		case "/reportes/rpt_alerta_stock_pdf.jasper":
			parametros.put("nombre_usuario", this.nombre_usuario);
			parametros.put("logo", this.logo);
			inYear = Integer.parseInt(parametros.get("inYear").toString());
			parametros.put("inYear", inYear);
			salida = true;
			break;
		
			
			
		case "/reportes/rptAlertaMaxMinGlobal.jasper":
			parametros.put("nombre_usuario", this.nombre_usuario);
			parametros.put("logo", this.logo);
			inYear = Integer.parseInt(parametros.get("inYear").toString());
			Integer inBodega=Integer.parseInt(parametros.get("inBodega").toString());
			parametros.put("inYear", inYear);
			parametros.put("inBodega", inBodega);
			salida = true;
			break;
			
			
			
		default:
			salida = false;

		}

		return salida;

	}

	public void refrescarVariables() {
		this.path = "/reportes/";
		this.conn = null;
		this.parametros.clear();

	}

}
