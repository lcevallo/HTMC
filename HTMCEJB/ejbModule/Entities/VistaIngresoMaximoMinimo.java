package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vista_ingreso_maximo_minimo database table.
 * 
 */
@Entity
@Table(name="vista_ingreso_maximo_minimo")
@NamedQuery(name="VistaIngresoMaximoMinimo.findAll", query="SELECT v FROM VistaIngresoMaximoMinimo v")
public class VistaIngresoMaximoMinimo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigo;
	
	@Id
	@Column(name="codigo_item")
	private String codigoItem;

	private String descripcion;

	@Column(name="maximo_112")
	private Integer maximo112;

	@Column(name="maximo_113")
	private Integer maximo113;

	@Column(name="maximo_114")
	private Integer maximo114;

	@Column(name="minimo_112")
	private Integer minimo112;

	@Column(name="minimo_113")
	private Integer minimo113;

	@Column(name="minimo_114")
	private Integer minimo114;

	@Column(name="numero_fila")
	private Long numeroFila;

	public VistaIngresoMaximoMinimo() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoItem() {
		return this.codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMaximo112() {
		return this.maximo112;
	}

	public void setMaximo112(Integer maximo112) {
		this.maximo112 = maximo112;
	}

	public Integer getMaximo113() {
		return this.maximo113;
	}

	public void setMaximo113(Integer maximo113) {
		this.maximo113 = maximo113;
	}

	public Integer getMaximo114() {
		return this.maximo114;
	}

	public void setMaximo114(Integer maximo114) {
		this.maximo114 = maximo114;
	}

	public Integer getMinimo112() {
		return this.minimo112;
	}

	public void setMinimo112(Integer minimo112) {
		this.minimo112 = minimo112;
	}

	public Integer getMinimo113() {
		return this.minimo113;
	}

	public void setMinimo113(Integer minimo113) {
		this.minimo113 = minimo113;
	}

	public Integer getMinimo114() {
		return this.minimo114;
	}

	public void setMinimo114(Integer minimo114) {
		this.minimo114 = minimo114;
	}

	public Long getNumeroFila() {
		return this.numeroFila;
	}

	public void setNumeroFila(Long numeroFila) {
		this.numeroFila = numeroFila;
	}

}