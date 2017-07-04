package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ingreso_items database table.
 * 
 */
@Embeddable
public class IngresoItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String itemfk;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	private Integer cantidad;

	private Integer bodega;

	private String lote;

	public IngresoItemPK() {
	}
	public String getItemfk() {
		return this.itemfk;
	}
	public void setItemfk(String itemfk) {
		this.itemfk = itemfk;
	}
	public java.util.Date getFecha() {
		return this.fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public Integer getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getBodega() {
		return this.bodega;
	}
	public void setBodega(Integer bodega) {
		this.bodega = bodega;
	}
	public String getLote() {
		return this.lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IngresoItemPK)) {
			return false;
		}
		IngresoItemPK castOther = (IngresoItemPK)other;
		return 
			this.itemfk.equals(castOther.itemfk)
			&& this.fecha.equals(castOther.fecha)
			&& this.cantidad.equals(castOther.cantidad)
			&& this.bodega.equals(castOther.bodega)
			&& this.lote.equals(castOther.lote);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemfk.hashCode();
		hash = hash * prime + this.fecha.hashCode();
		hash = hash * prime + this.cantidad.hashCode();
		hash = hash * prime + this.bodega.hashCode();
		hash = hash * prime + this.lote.hashCode();
		
		return hash;
	}
}