package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the consolidado_anual database table.
 * 
 */
@Entity
@Table(name="consolidado_anual")
@NamedQuery(name="ConsolidadoAnual.findAll", query="SELECT c FROM ConsolidadoAnual c")
public class ConsolidadoAnual implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsolidadoAnualPK id;

	@Column(name="ajuste_ingreso")
	private Long ajusteIngreso;

	private Boolean alerta;

	@Column(name="area_departamento")
	private String areaDepartamento;

	private Long egreso;

	private Long ingreso;

	@Column(name="ingreso_saldo_anterior")
	private Long ingresoSaldoAnterior;

	@Column(name="saldo_mes")
	private Long saldoMes;
	
	@ManyToOne
	@JoinColumn(name="item_fk", insertable = false, updatable = false)
	private Item item;
	
	@Column(name="cuadro_base")
	private String cuadroBase;
		

	public String getCuadroBase() {
		return cuadroBase;
	}

	public void setCuadroBase(String cuadroBase) {
		this.cuadroBase = cuadroBase;
	}

	public ConsolidadoAnual() {
	}

	public ConsolidadoAnualPK getId() {
		return this.id;
	}

	public void setId(ConsolidadoAnualPK id) {
		this.id = id;
	}

	public Long getAjusteIngreso() {
		return this.ajusteIngreso;
	}

	public void setAjusteIngreso(Long ajusteIngreso) {
		this.ajusteIngreso = ajusteIngreso;
	}

	public Boolean getAlerta() {
		return this.alerta;
	}

	public void setAlerta(Boolean alerta) {
		this.alerta = alerta;
	}

	public String getAreaDepartamento() {
		return this.areaDepartamento;
	}

	public void setAreaDepartamento(String areaDepartamento) {
		this.areaDepartamento = areaDepartamento;
	}

	public Long getEgreso() {
		return this.egreso;
	}

	public void setEgreso(Long egreso) {
		this.egreso = egreso;
	}

	public Long getIngreso() {
		return this.ingreso;
	}

	public void setIngreso(Long ingreso) {
		this.ingreso = ingreso;
	}

	public Long getIngresoSaldoAnterior() {
		return this.ingresoSaldoAnterior;
	}

	public void setIngresoSaldoAnterior(Long ingresoSaldoAnterior) {
		this.ingresoSaldoAnterior = ingresoSaldoAnterior;
	}

	public Long getSaldoMes() {
		return this.saldoMes;
	}

	public void setSaldoMes(Long saldoMes) {
		this.saldoMes = saldoMes;
	}

}