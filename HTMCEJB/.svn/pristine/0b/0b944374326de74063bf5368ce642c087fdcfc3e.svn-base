package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ingreso_items database table.
 * 
 */
@Entity
@Table(name="ingreso_items")
@NamedQuery(name="IngresoItem.findAll", query="SELECT i FROM IngresoItem i")
public class IngresoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IngresoItemPK id;

	private Integer anio;

	private Integer dia;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cad")
	private Date fechaCad;

	private Integer mes;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="itemfk", insertable = false, updatable = false)
	private Item item;

	public IngresoItem() {
	}

	public IngresoItemPK getId() {
		return this.id;
	}

	public void setId(IngresoItemPK id) {
		this.id = id;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Date getFechaCad() {
		return this.fechaCad;
	}

	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}