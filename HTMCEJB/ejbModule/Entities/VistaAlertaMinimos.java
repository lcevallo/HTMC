/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "vista_alerta_minimos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaAlertaMinimos.findAll", query = "SELECT v FROM VistaAlertaMinimos v"),
    @NamedQuery(name = "VistaAlertaMinimos.findByCuadroBase", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.cuadroBase = :cuadroBase"),
    @NamedQuery(name = "VistaAlertaMinimos.findByItem", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.item = :item"),
    @NamedQuery(name = "VistaAlertaMinimos.findByYear", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.year = :year"),
    @NamedQuery(name = "VistaAlertaMinimos.findByDescripcion", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "VistaAlertaMinimos.findByBodega", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.bodega = :bodega"),
    @NamedQuery(name = "VistaAlertaMinimos.findByBodegaAndYear", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.bodega = :bodega and v.year = :year"),
    @NamedQuery(name = "VistaAlertaMinimos.findByEne", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.ene = :ene"),
    @NamedQuery(name = "VistaAlertaMinimos.findByFeb", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.feb = :feb"),
    @NamedQuery(name = "VistaAlertaMinimos.findByMar", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.mar = :mar"),
    @NamedQuery(name = "VistaAlertaMinimos.findByAbr", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.abr = :abr"),
    @NamedQuery(name = "VistaAlertaMinimos.findByMay", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.may = :may"),
    @NamedQuery(name = "VistaAlertaMinimos.findByJun", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.jun = :jun"),
    @NamedQuery(name = "VistaAlertaMinimos.findByJul", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.jul = :jul"),
    @NamedQuery(name = "VistaAlertaMinimos.findByAgo", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.ago = :ago"),
    @NamedQuery(name = "VistaAlertaMinimos.findBySep", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.sep = :sep"),
    @NamedQuery(name = "VistaAlertaMinimos.findByOct", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.oct = :oct"),
    @NamedQuery(name = "VistaAlertaMinimos.findByNov", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.nov = :nov"),
    @NamedQuery(name = "VistaAlertaMinimos.findByDic", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.dic = :dic"),
    @NamedQuery(name = "VistaAlertaMinimos.findByMaximo", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.maximo = :maximo"),
    @NamedQuery(name = "VistaAlertaMinimos.findByMinimo", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.minimo = :minimo"),
    @NamedQuery(name = "VistaAlertaMinimos.findByPorcentajeMaximo", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.porcentajeMaximo = :porcentajeMaximo"),
    @NamedQuery(name = "VistaAlertaMinimos.findByPorcentajeMinimo", query = "SELECT v FROM VistaAlertaMinimos v WHERE v.porcentajeMinimo = :porcentajeMinimo")})
public class VistaAlertaMinimos implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private Integer abr;

	private Integer ago;

	private Integer bodega;

	@Column(name="cuadro_base")
	private String cuadroBase;

	private String descripcion;

	private Integer dic;

	private Integer ene;

	private Integer feb;
    
	@Id
	private Long fila;

	private String item;

	private Integer jul;

	private Integer jun;

	private Integer mar;

	private Integer maximo;

	private Integer may;

	private Integer minimo;

	private Integer nov;

	private Integer oct;

	@Column(name="porcentaje_maximo")
	private BigDecimal porcentajeMaximo;

	@Column(name="porcentaje_minimo")
	private BigDecimal porcentajeMinimo;

	private Integer sep;

	private Integer year;

	public VistaAlertaMinimos() {
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

	public Integer getBodega() {
		return this.bodega;
	}

	public void setBodega(Integer bodega) {
		this.bodega = bodega;
	}

	public String getCuadroBase() {
		return this.cuadroBase;
	}

	public void setCuadroBase(String cuadroBase) {
		this.cuadroBase = cuadroBase;
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

	public Long getFila() {
		return this.fila;
	}

	public void setFila(Long fila) {
		this.fila = fila;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
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

	public Integer getMaximo() {
		return this.maximo;
	}

	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}

	public Integer getMay() {
		return this.may;
	}

	public void setMay(Integer may) {
		this.may = may;
	}

	public Integer getMinimo() {
		return this.minimo;
	}

	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
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

	public BigDecimal getPorcentajeMaximo() {
		return this.porcentajeMaximo;
	}

	public void setPorcentajeMaximo(BigDecimal porcentajeMaximo) {
		this.porcentajeMaximo = porcentajeMaximo;
	}

	public BigDecimal getPorcentajeMinimo() {
		return this.porcentajeMinimo;
	}

	public void setPorcentajeMinimo(BigDecimal porcentajeMinimo) {
		this.porcentajeMinimo = porcentajeMinimo;
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
