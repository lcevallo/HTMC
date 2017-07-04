package Entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the consolidado_stock_real_minimo_pivote database
 * table.
 * 
 */
@Entity

@Table(name = "consolidado_stock_real_minimo_pivote")
@NamedQueries({
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findAll", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByItem", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.id.item = :item"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByYear", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.id.year = :year"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByDescripcion", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.descripcion = :descripcion"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByEne", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.ene = :ene"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByFeb", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.feb = :feb"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByMar", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.mar = :mar"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByAbr", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.abr = :abr"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByMay", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.may = :may"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByJun", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.jun = :jun"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByJul", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.jul = :jul"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByAgo", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.ago = :ago"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findBySep", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.sep = :sep"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByOct", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.oct = :oct"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByNov", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.nov = :nov"),
		@NamedQuery(name = "ConsolidadoStockRealMinimoPivote.findByDic", query = "SELECT c FROM ConsolidadoStockRealMinimoPivote c WHERE c.dic = :dic") })
public class ConsolidadoStockRealMinimoPivote implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsolidadoStockRealMinimoPivotePK id;

	private double abr;

	private double ago;

	private String descripcion;

	private double dic;

	private double ene;

	private double feb;

	private double jul;

	private double jun;

	private double mar;

	private double may;

	private double nov;

	private double oct;

	private double sep;
	
	@Column(name="cuadro_base")
	private String cuadroBase;
	
	

	public String getCuadroBase() {
		return cuadroBase;
	}

	public void setCuadroBase(String cuadroBase) {
		this.cuadroBase = cuadroBase;
	}

	public ConsolidadoStockRealMinimoPivote() {
	}

	public ConsolidadoStockRealMinimoPivotePK getId() {
		return this.id;
	}

	public void setId(ConsolidadoStockRealMinimoPivotePK id) {
		this.id = id;
	}

	public double getAbr() {
		return this.abr;
	}

	public void setAbr(double abr) {
		this.abr = abr;
	}

	public double getAgo() {
		return this.ago;
	}

	public void setAgo(double ago) {
		this.ago = ago;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getDic() {
		return this.dic;
	}

	public void setDic(double dic) {
		this.dic = dic;
	}

	public double getEne() {
		return this.ene;
	}

	public void setEne(double ene) {
		this.ene = ene;
	}

	public double getFeb() {
		return this.feb;
	}

	public void setFeb(double feb) {
		this.feb = feb;
	}

	public double getJul() {
		return this.jul;
	}

	public void setJul(double jul) {
		this.jul = jul;
	}

	public double getJun() {
		return this.jun;
	}

	public void setJun(double jun) {
		this.jun = jun;
	}

	public double getMar() {
		return this.mar;
	}

	public void setMar(double mar) {
		this.mar = mar;
	}

	public double getMay() {
		return this.may;
	}

	public void setMay(double may) {
		this.may = may;
	}

	public double getNov() {
		return this.nov;
	}

	public void setNov(double nov) {
		this.nov = nov;
	}

	public double getOct() {
		return this.oct;
	}

	public void setOct(double oct) {
		this.oct = oct;
	}

	public double getSep() {
		return this.sep;
	}

	public void setSep(double sep) {
		this.sep = sep;
	}

}