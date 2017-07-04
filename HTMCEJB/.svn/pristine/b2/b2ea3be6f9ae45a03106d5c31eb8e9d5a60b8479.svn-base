package Entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the consolidado_alerta database table.
 * 
 */
@Entity
@Table(name="consolidado_alerta")
@NamedQuery(name="ConsolidadoAlerta.findAll", query="SELECT c FROM ConsolidadoAlerta c")
public class ConsolidadoAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsolidadoAlertaPK id;

	private Boolean abr;

	private Boolean ago;

	private String descripcion;

	private Boolean dic;

	private Boolean ene;

	private Boolean feb;

	private Boolean jul;

	private Boolean jun;

	private Boolean mar;

	private Boolean may;

	private Boolean nov;

	private Boolean oct;

	private Boolean sep;
	
	@Column(name="cuadro_base")
	private String cuadroBase;
	
	

	public String getCuadroBase() {
		return cuadroBase;
	}

	public void setCuadroBase(String cuadroBase) {
		this.cuadroBase = cuadroBase;
	}

	public ConsolidadoAlerta() {
	}

	public ConsolidadoAlertaPK getId() {
		return this.id;
	}

	public void setId(ConsolidadoAlertaPK id) {
		this.id = id;
	}

	public Boolean getAbr() {
		return this.abr;
	}

	public void setAbr(Boolean abr) {
		this.abr = abr;
	}

	public Boolean getAgo() {
		return this.ago;
	}

	public void setAgo(Boolean ago) {
		this.ago = ago;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getDic() {
		return this.dic;
	}

	public void setDic(Boolean dic) {
		this.dic = dic;
	}

	public Boolean getEne() {
		return this.ene;
	}

	public void setEne(Boolean ene) {
		this.ene = ene;
	}

	public Boolean getFeb() {
		return this.feb;
	}

	public void setFeb(Boolean feb) {
		this.feb = feb;
	}

	public Boolean getJul() {
		return this.jul;
	}

	public void setJul(Boolean jul) {
		this.jul = jul;
	}

	public Boolean getJun() {
		return this.jun;
	}

	public void setJun(Boolean jun) {
		this.jun = jun;
	}

	public Boolean getMar() {
		return this.mar;
	}

	public void setMar(Boolean mar) {
		this.mar = mar;
	}

	public Boolean getMay() {
		return this.may;
	}

	public void setMay(Boolean may) {
		this.may = may;
	}

	public Boolean getNov() {
		return this.nov;
	}

	public void setNov(Boolean nov) {
		this.nov = nov;
	}

	public Boolean getOct() {
		return this.oct;
	}

	public void setOct(Boolean oct) {
		this.oct = oct;
	}

	public Boolean getSep() {
		return this.sep;
	}

	public void setSep(Boolean sep) {
		this.sep = sep;
	}

}