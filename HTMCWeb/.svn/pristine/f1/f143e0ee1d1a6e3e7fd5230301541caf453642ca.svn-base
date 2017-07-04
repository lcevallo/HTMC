package ManagedBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.RowEditEvent;

import Entities.Usuario;
import Entities.VistaIngresoMaximoMinimo;
import SessionBeans.VistaItemMaxMinFacadeLocal;

@ManagedBean
@ViewScoped
public class MaxMinBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7886567574044689211L;
	private VistaIngresoMaximoMinimo vistaIngresoMaximoMinimo;
	private List<VistaIngresoMaximoMinimo> listaMedicamento;
	private List<VistaIngresoMaximoMinimo> filteredListaMedicamento;
	private String fecha_actual;
	
	@EJB
    private VistaItemMaxMinFacadeLocal facadeVistaItemMaxMin;
	
	
	@PostConstruct
	public void inicio() {
		try {
			this.listaMedicamento = this.facadeVistaItemMaxMin.findAll();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
							e.getMessage()));
		}
		
	}

	public MaxMinBean()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		this.fecha_actual=dateFormat.format(cal.getTime());
		
		
	}
	
	
	public String getFecha_actual() {
		return fecha_actual;
	}

	public void setFecha_actual(String fecha_actual) {
		this.fecha_actual = fecha_actual;
	}




	public List<VistaIngresoMaximoMinimo> getListaMedicamento() {
		return listaMedicamento;
	}

	public void setListaMedicamento(List<VistaIngresoMaximoMinimo> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}

	public List<VistaIngresoMaximoMinimo> getFilteredListaMedicamento() {
		return filteredListaMedicamento;
	}

	public void setFilteredListaMedicamento(List<VistaIngresoMaximoMinimo> filteredListaMedicamento) {
		this.filteredListaMedicamento = filteredListaMedicamento;
	}
	
	
	
	public VistaIngresoMaximoMinimo getVistaIngresoMaximoMinimo() {
		return vistaIngresoMaximoMinimo;
	}

	public void setVistaIngresoMaximoMinimo(VistaIngresoMaximoMinimo vistaIngresoMaximoMinimo) {
		this.vistaIngresoMaximoMinimo = vistaIngresoMaximoMinimo;
	}
			
	public VistaItemMaxMinFacadeLocal getFacadeVistaItemMaxMin() {
		return facadeVistaItemMaxMin;
	}


	public void setFacadeVistaItemMaxMin(VistaItemMaxMinFacadeLocal facadeVistaItemMaxMin) {
		this.facadeVistaItemMaxMin = facadeVistaItemMaxMin;
	}
	
	public  void  validaVistaIngresoMaximoMinimo(Integer opcion)
	{
	   
		
		switch (opcion) {
		case 1:
			this.vistaIngresoMaximoMinimo.setMaximo112(this.vistaIngresoMaximoMinimo.getMaximo112()==null?0:this.vistaIngresoMaximoMinimo.getMaximo112());
		    this.vistaIngresoMaximoMinimo.setMinimo112(this.vistaIngresoMaximoMinimo.getMinimo112()==null?0:this.vistaIngresoMaximoMinimo.getMinimo112());
		    
		    if(this.vistaIngresoMaximoMinimo.getMaximo112()<this.vistaIngresoMaximoMinimo.getMinimo112()) 
		      {
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("En la bodega 112 el valor minimo no puede exceder al maximo : "));
				 this.vistaIngresoMaximoMinimo.setMaximo112(0);
				 this.vistaIngresoMaximoMinimo.setMinimo112(0);					  
			  }
		    
		    this.vistaIngresoMaximoMinimo.setMaximo113(this.vistaIngresoMaximoMinimo.getMaximo113()==null?0:this.vistaIngresoMaximoMinimo.getMaximo113());
		    this.vistaIngresoMaximoMinimo.setMinimo113(this.vistaIngresoMaximoMinimo.getMinimo113()==null?0:this.vistaIngresoMaximoMinimo.getMinimo113());
		    
		    if(this.vistaIngresoMaximoMinimo.getMaximo113()<this.vistaIngresoMaximoMinimo.getMinimo113()) 
		    {
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("En la bodega 113 el valor minimo no puede exceder al maximo : "));
				 this.vistaIngresoMaximoMinimo.setMaximo113(0);
				 this.vistaIngresoMaximoMinimo.setMinimo113(0);					  
			  }
		    
		    this.vistaIngresoMaximoMinimo.setMaximo114(this.vistaIngresoMaximoMinimo.getMaximo114()==null?0:this.vistaIngresoMaximoMinimo.getMaximo114());
		    this.vistaIngresoMaximoMinimo.setMinimo114(this.vistaIngresoMaximoMinimo.getMinimo114()==null?0:this.vistaIngresoMaximoMinimo.getMinimo114());
			
		    if(this.vistaIngresoMaximoMinimo.getMaximo114()<this.vistaIngresoMaximoMinimo.getMinimo114())
		    	
		      {
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("En la bodega 114 el valor minimo no puede exceder al maximo : "));
				 this.vistaIngresoMaximoMinimo.setMaximo114(0);
				 this.vistaIngresoMaximoMinimo.setMinimo114(0);					  
			  }
		    
		    break;
		 
		case 2:
			this.vistaIngresoMaximoMinimo.setMaximo112(this.vistaIngresoMaximoMinimo.getMaximo112()==0?null:this.vistaIngresoMaximoMinimo.getMaximo112());
		    this.vistaIngresoMaximoMinimo.setMinimo112(this.vistaIngresoMaximoMinimo.getMinimo112()==0?null:this.vistaIngresoMaximoMinimo.getMinimo112());
		    this.vistaIngresoMaximoMinimo.setMaximo113(this.vistaIngresoMaximoMinimo.getMaximo113()==0?null:this.vistaIngresoMaximoMinimo.getMaximo113());
		    this.vistaIngresoMaximoMinimo.setMinimo113(this.vistaIngresoMaximoMinimo.getMinimo113()==0?null:this.vistaIngresoMaximoMinimo.getMinimo113());
		    this.vistaIngresoMaximoMinimo.setMaximo114(this.vistaIngresoMaximoMinimo.getMaximo114()==0?null:this.vistaIngresoMaximoMinimo.getMaximo114());
		    this.vistaIngresoMaximoMinimo.setMinimo114(this.vistaIngresoMaximoMinimo.getMinimo114()==0?null:this.vistaIngresoMaximoMinimo.getMinimo114());
		    		    
			break;
		default:
			break;
		}
		
		
		
	}
	
	
	
	public void onEdit(RowEditEvent event) {
		
		
		
		this.vistaIngresoMaximoMinimo=(VistaIngresoMaximoMinimo)event.getObject();
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		Usuario usuario = (Usuario) session.getAttribute("userInSession");
		String salida="";
	    
		
		this.validaVistaIngresoMaximoMinimo(1);
		
		salida=this.facadeVistaItemMaxMin.guardarMaximoMinimo(usuario.getUsuario(), this.vistaIngresoMaximoMinimo);		
		
		salida=salida.substring(0,salida.lastIndexOf("#"));
		
		//		salidaError=salida.substring(salida.lastIndexOf("#") + 1);
		//		vistaIngresoMaximoMinimo.setFechaInicial(Timestamp.valueOf(fechaString));
		
		this.validaVistaIngresoMaximoMinimo(2);
		
		if (salida.length()>2)
		{
			FacesMessage msg = new FacesMessage("Editado item : " + salida);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
	}

	public void onCancel(RowEditEvent event)
	{
			
		
		this.vistaIngresoMaximoMinimo=(VistaIngresoMaximoMinimo)event.getObject();
		FacesMessage msg = new FacesMessage("Cancelada la edicion del  item : " + this.vistaIngresoMaximoMinimo.getCodigoItem());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		
	}
}// fin del Bean MaxMinBean
