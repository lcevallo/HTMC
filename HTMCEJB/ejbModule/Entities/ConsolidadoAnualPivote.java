package Entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the consolidado_anual_pivote database table.
 * 
 */
@Entity
@Table(name = "consolidado_anual_pivote")
@NamedQuery(name = "ConsolidadoAnualPivote.findAll", query = "SELECT c FROM ConsolidadoAnualPivote c")
public class ConsolidadoAnualPivote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="cuadro_base")
	private String cuadroBase;
	
	@EmbeddedId
	private ConsolidadoAnualPivotePK id;

	@Column(name = "abr_alerta")
	private Boolean abrAlerta;

	@Column(name = "abr_egreso")
	private Integer abrEgreso;

	@Column(name = "abr_ingreso")
	private Integer abrIngreso;

	@Column(name = "abr_saldo")
	private Integer abrSaldo;

	@Column(name = "ago_alerta")
	private Boolean agoAlerta;

	@Column(name = "ago_egreso")
	private Integer agoEgreso;

	@Column(name = "ago_ingreso")
	private Integer agoIngreso;

	@Column(name = "ago_saldo")
	private Integer agoSaldo;

	private String descripcion;

	@Column(name = "dic_alerta")
	private Boolean dicAlerta;

	@Column(name = "dic_egreso")
	private Integer dicEgreso;

	@Column(name = "dic_ingreso")
	private Integer dicIngreso;

	@Column(name = "dic_saldo")
	private Integer dicSaldo;

	@Column(name = "ene_alerta")
	private Boolean eneAlerta;

	@Column(name = "ene_egreso")
	private Integer eneEgreso;

	@Column(name = "ene_ingreso")
	private Integer eneIngreso;

	@Column(name = "ene_saldo")
	private Integer eneSaldo;

	@Column(name = "feb_alerta")
	private Boolean febAlerta;

	@Column(name = "feb_egreso")
	private Integer febEgreso;

	@Column(name = "feb_ingreso")
	private Integer febIngreso;

	@Column(name = "feb_saldo")
	private Integer febSaldo;

	@Column(name = "jul_alerta")
	private Boolean julAlerta;

	@Column(name = "jul_egreso")
	private Integer julEgreso;

	@Column(name = "jul_ingreso")
	private Integer julIngreso;

	@Column(name = "jul_saldo")
	private Integer julSaldo;

	@Column(name = "jun_alerta")
	private Boolean junAlerta;

	@Column(name = "jun_egreso")
	private Integer junEgreso;

	@Column(name = "jun_ingreso")
	private Integer junIngreso;

	@Column(name = "jun_saldo")
	private Integer junSaldo;

	@Column(name = "mar_alerta")
	private Boolean marAlerta;

	@Column(name = "mar_egreso")
	private Integer marEgreso;

	@Column(name = "mar_ingreso")
	private Integer marIngreso;

	@Column(name = "mar_saldo")
	private Integer marSaldo;

	@Column(name = "may_alerta")
	private Boolean mayAlerta;

	@Column(name = "may_egreso")
	private Integer mayEgreso;

	@Column(name = "may_ingreso")
	private Integer mayIngreso;

	@Column(name = "may_saldo")
	private Integer maySaldo;

	@Column(name = "nov_alerta")
	private Boolean novAlerta;

	@Column(name = "nov_egreso")
	private Integer novEgreso;

	@Column(name = "nov_ingreso")
	private Integer novIngreso;

	@Column(name = "nov_saldo")
	private Integer novSaldo;

	@Column(name = "oct_alerta")
	private Boolean octAlerta;

	@Column(name = "oct_egreso")
	private Integer octEgreso;

	@Column(name = "oct_ingreso")
	private Integer octIngreso;

	@Column(name = "oct_saldo")
	private Integer octSaldo;

	@Column(name = "sep_alerta")
	private Boolean sepAlerta;

	@Column(name = "sep_egreso")
	private Integer sepEgreso;

	@Column(name = "sep_ingreso")
	private Integer sepIngreso;

	@Column(name = "sep_saldo")
	private Integer sepSaldo;

	@Column(name = "stock_real")
	private Integer stockReal;

	@Column(name = "total_egreso")
	private Integer totalEgreso;

	@Column(name = "total_ingreso")
	private Integer totalIngreso;
	
	
	
	

	public String getCuadroBase() {
		return cuadroBase;
	}

	public void setCuadroBase(String cuadroBase) {
		this.cuadroBase = cuadroBase;
	}

	public ConsolidadoAnualPivote() {
	}

	public ConsolidadoAnualPivotePK getId() {
		return this.id;
	}

	public void setId(ConsolidadoAnualPivotePK id) {
		this.id = id;
	}

	public Boolean getAbrAlerta() {
		return this.abrAlerta;
	}

	public void setAbrAlerta(Boolean abrAlerta) {
		this.abrAlerta = abrAlerta;
	}

	public Integer getAbrEgreso() {
		return this.abrEgreso;
	}

	public void setAbrEgreso(Integer abrEgreso) {
		this.abrEgreso = abrEgreso;
	}

	public Integer getAbrIngreso() {
		return this.abrIngreso;
	}

	public void setAbrIngreso(Integer abrIngreso) {
		this.abrIngreso = abrIngreso;
	}

	public Integer getAbrSaldo() {
		return this.abrSaldo;
	}

	public void setAbrSaldo(Integer abrSaldo) {
		this.abrSaldo = abrSaldo;
	}

	public Boolean getAgoAlerta() {
		return this.agoAlerta;
	}

	public void setAgoAlerta(Boolean agoAlerta) {
		this.agoAlerta = agoAlerta;
	}

	public Integer getAgoEgreso() {
		return this.agoEgreso;
	}

	public void setAgoEgreso(Integer agoEgreso) {
		this.agoEgreso = agoEgreso;
	}

	public Integer getAgoIngreso() {
		return this.agoIngreso;
	}

	public void setAgoIngreso(Integer agoIngreso) {
		this.agoIngreso = agoIngreso;
	}

	public Integer getAgoSaldo() {
		return this.agoSaldo;
	}

	public void setAgoSaldo(Integer agoSaldo) {
		this.agoSaldo = agoSaldo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getDicAlerta() {
		return this.dicAlerta;
	}

	public void setDicAlerta(Boolean dicAlerta) {
		this.dicAlerta = dicAlerta;
	}

	public Integer getDicEgreso() {
		return this.dicEgreso;
	}

	public void setDicEgreso(Integer dicEgreso) {
		this.dicEgreso = dicEgreso;
	}

	public Integer getDicIngreso() {
		return this.dicIngreso;
	}

	public void setDicIngreso(Integer dicIngreso) {
		this.dicIngreso = dicIngreso;
	}

	public Integer getDicSaldo() {
		return this.dicSaldo;
	}

	public void setDicSaldo(Integer dicSaldo) {
		this.dicSaldo = dicSaldo;
	}

	public Boolean getEneAlerta() {
		return this.eneAlerta;
	}

	public void setEneAlerta(Boolean eneAlerta) {
		this.eneAlerta = eneAlerta;
	}

	public Integer getEneEgreso() {
		return this.eneEgreso;
	}

	public void setEneEgreso(Integer eneEgreso) {
		this.eneEgreso = eneEgreso;
	}

	public Integer getEneIngreso() {
		return this.eneIngreso;
	}

	public void setEneIngreso(Integer eneIngreso) {
		this.eneIngreso = eneIngreso;
	}

	public Integer getEneSaldo() {
		return this.eneSaldo;
	}

	public void setEneSaldo(Integer eneSaldo) {
		this.eneSaldo = eneSaldo;
	}

	public Boolean getFebAlerta() {
		return this.febAlerta;
	}

	public void setFebAlerta(Boolean febAlerta) {
		this.febAlerta = febAlerta;
	}

	public Integer getFebEgreso() {
		return this.febEgreso;
	}

	public void setFebEgreso(Integer febEgreso) {
		this.febEgreso = febEgreso;
	}

	public Integer getFebIngreso() {
		return this.febIngreso;
	}

	public void setFebIngreso(Integer febIngreso) {
		this.febIngreso = febIngreso;
	}

	public Integer getFebSaldo() {
		return this.febSaldo;
	}

	public void setFebSaldo(Integer febSaldo) {
		this.febSaldo = febSaldo;
	}

	public Boolean getJulAlerta() {
		return this.julAlerta;
	}

	public void setJulAlerta(Boolean julAlerta) {
		this.julAlerta = julAlerta;
	}

	public Integer getJulEgreso() {
		return this.julEgreso;
	}

	public void setJulEgreso(Integer julEgreso) {
		this.julEgreso = julEgreso;
	}

	public Integer getJulIngreso() {
		return this.julIngreso;
	}

	public void setJulIngreso(Integer julIngreso) {
		this.julIngreso = julIngreso;
	}

	public Integer getJulSaldo() {
		return this.julSaldo;
	}

	public void setJulSaldo(Integer julSaldo) {
		this.julSaldo = julSaldo;
	}

	public Boolean getJunAlerta() {
		return this.junAlerta;
	}

	public void setJunAlerta(Boolean junAlerta) {
		this.junAlerta = junAlerta;
	}

	public Integer getJunEgreso() {
		return this.junEgreso;
	}

	public void setJunEgreso(Integer junEgreso) {
		this.junEgreso = junEgreso;
	}

	public Integer getJunIngreso() {
		return this.junIngreso;
	}

	public void setJunIngreso(Integer junIngreso) {
		this.junIngreso = junIngreso;
	}

	public Integer getJunSaldo() {
		return this.junSaldo;
	}

	public void setJunSaldo(Integer junSaldo) {
		this.junSaldo = junSaldo;
	}

	public Boolean getMarAlerta() {
		return this.marAlerta;
	}

	public void setMarAlerta(Boolean marAlerta) {
		this.marAlerta = marAlerta;
	}

	public Integer getMarEgreso() {
		return this.marEgreso;
	}

	public void setMarEgreso(Integer marEgreso) {
		this.marEgreso = marEgreso;
	}

	public Integer getMarIngreso() {
		return this.marIngreso;
	}

	public void setMarIngreso(Integer marIngreso) {
		this.marIngreso = marIngreso;
	}

	public Integer getMarSaldo() {
		return this.marSaldo;
	}

	public void setMarSaldo(Integer marSaldo) {
		this.marSaldo = marSaldo;
	}

	public Boolean getMayAlerta() {
		return this.mayAlerta;
	}

	public void setMayAlerta(Boolean mayAlerta) {
		this.mayAlerta = mayAlerta;
	}

	public Integer getMayEgreso() {
		return this.mayEgreso;
	}

	public void setMayEgreso(Integer mayEgreso) {
		this.mayEgreso = mayEgreso;
	}

	public Integer getMayIngreso() {
		return this.mayIngreso;
	}

	public void setMayIngreso(Integer mayIngreso) {
		this.mayIngreso = mayIngreso;
	}

	public Integer getMaySaldo() {
		return this.maySaldo;
	}

	public void setMaySaldo(Integer maySaldo) {
		this.maySaldo = maySaldo;
	}

	public Boolean getNovAlerta() {
		return this.novAlerta;
	}

	public void setNovAlerta(Boolean novAlerta) {
		this.novAlerta = novAlerta;
	}

	public Integer getNovEgreso() {
		return this.novEgreso;
	}

	public void setNovEgreso(Integer novEgreso) {
		this.novEgreso = novEgreso;
	}

	public Integer getNovIngreso() {
		return this.novIngreso;
	}

	public void setNovIngreso(Integer novIngreso) {
		this.novIngreso = novIngreso;
	}

	public Integer getNovSaldo() {
		return this.novSaldo;
	}

	public void setNovSaldo(Integer novSaldo) {
		this.novSaldo = novSaldo;
	}

	public Boolean getOctAlerta() {
		return this.octAlerta;
	}

	public void setOctAlerta(Boolean octAlerta) {
		this.octAlerta = octAlerta;
	}

	public Integer getOctEgreso() {
		return this.octEgreso;
	}

	public void setOctEgreso(Integer octEgreso) {
		this.octEgreso = octEgreso;
	}

	public Integer getOctIngreso() {
		return this.octIngreso;
	}

	public void setOctIngreso(Integer octIngreso) {
		this.octIngreso = octIngreso;
	}

	public Integer getOctSaldo() {
		return this.octSaldo;
	}

	public void setOctSaldo(Integer octSaldo) {
		this.octSaldo = octSaldo;
	}

	public Boolean getSepAlerta() {
		return this.sepAlerta;
	}

	public void setSepAlerta(Boolean sepAlerta) {
		this.sepAlerta = sepAlerta;
	}

	public Integer getSepEgreso() {
		return this.sepEgreso;
	}

	public void setSepEgreso(Integer sepEgreso) {
		this.sepEgreso = sepEgreso;
	}

	public Integer getSepIngreso() {
		return this.sepIngreso;
	}

	public void setSepIngreso(Integer sepIngreso) {
		this.sepIngreso = sepIngreso;
	}

	public Integer getSepSaldo() {
		return this.sepSaldo;
	}

	public void setSepSaldo(Integer sepSaldo) {
		this.sepSaldo = sepSaldo;
	}

	public Integer getStockReal() {
		return this.stockReal;
	}

	public void setStockReal(Integer stockReal) {
		this.stockReal = stockReal;
	}

	public Integer getTotalEgreso() {
		return this.totalEgreso;
	}

	public void setTotalEgreso(Integer totalEgreso) {
		this.totalEgreso = totalEgreso;
	}

	public Integer getTotalIngreso() {
		return this.totalIngreso;
	}

	public void setTotalIngreso(Integer totalIngreso) {
		this.totalIngreso = totalIngreso;
	}

}