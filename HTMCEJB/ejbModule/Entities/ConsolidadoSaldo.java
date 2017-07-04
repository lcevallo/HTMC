package Entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the consolidado_saldo database table.
 * 
 */
@Entity
@Table(name="consolidado_saldo")
@NamedQuery(name="ConsolidadoSaldo.findAll", query="SELECT c FROM ConsolidadoSaldo c")
public class ConsolidadoSaldo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String item;

	private Integer abr;

	private Integer ago;

	private String descripcion;

	private Integer dic;

	private Integer ene;

	private Integer feb;

	private Integer jul;

	private Integer jun;

	private Integer mar;

	private Integer may;

	private Integer nov;

	private Integer oct;

	private Integer sep;

	private Integer year;
	
	@Column(name="cuadro_base")
	private String cuadroBase;
	
	

	public String getCuadroBase() {
		return cuadroBase;
	}

	public void setCuadroBase(String cuadroBase) {
		this.cuadroBase = cuadroBase;
	}

	public ConsolidadoSaldo() {
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getAbr() {
		return this.abr;
	}

	public void setAbr(Integer abr) {
		this.abr = abr;
	}

	public Integer getAgo() {
		return this.ago;
	}

	public void setAgo(Integer ago) {
		this.ago = ago;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDic() {
		return this.dic;
	}

	public void setDic(Integer dic) {
		this.dic = dic;
	}

	public Integer getEne() {
		return this.ene;
	}

	public void setEne(Integer ene) {
		this.ene = ene;
	}

	public Integer getFeb() {
		return this.feb;
	}

	public void setFeb(Integer feb) {
		this.feb = feb;
	}

	public Integer getJul() {
		return this.jul;
	}

	public void setJul(Integer jul) {
		this.jul = jul;
	}

	public Integer getJun() {
		return this.jun;
	}

	public void setJun(Integer jun) {
		this.jun = jun;
	}

	public Integer getMar() {
		return this.mar;
	}

	public void setMar(Integer mar) {
		this.mar = mar;
	}

	public Integer getMay() {
		return this.may;
	}

	public void setMay(Integer may) {
		this.may = may;
	}

	public Integer getNov() {
		return this.nov;
	}

	public void setNov(Integer nov) {
		this.nov = nov;
	}

	public Integer getOct() {
		return this.oct;
	}

	public void setOct(Integer oct) {
		this.oct = oct;
	}

	public Integer getSep() {
		return this.sep;
	}

	public void setSep(Integer sep) {
		this.sep = sep;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}