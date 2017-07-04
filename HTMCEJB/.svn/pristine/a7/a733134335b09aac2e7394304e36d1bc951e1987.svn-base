package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the egreso_items database table.
 * 
 */
@Embeddable
public class EgresoItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String itemfk;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	private String lote;

	private Long cantidad;

	@Column(name="orden_medica")
	private String ordenMedica;

	private Integer bodega;

	public EgresoItemPK() {
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
	public String getLote() {
		return this.lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Long getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public String getOrdenMedica() {
		return this.ordenMedica;
	}
	public void setOrdenMedica(String ordenMedica) {
		this.ordenMedica = ordenMedica;
	}
	public Integer getBodega() {
		return this.bodega;
	}
	public void setBodega(Integer bodega) {
		this.bodega = bodega;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EgresoItemPK)) {
			return false;
		}
		EgresoItemPK castOther = (EgresoItemPK)other;
		return 
			this.itemfk.equals(castOther.itemfk)
			&& this.fecha.equals(castOther.fecha)
			&& this.lote.equals(castOther.lote)
			&& this.cantidad.equals(castOther.cantidad)
			&& this.ordenMedica.equals(castOther.ordenMedica)
			&& this.bodega.equals(castOther.bodega);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemfk.hashCode();
		hash = hash * prime + this.fecha.hashCode();
		hash = hash * prime + this.lote.hashCode();
		hash = hash * prime + this.cantidad.hashCode();
		hash = hash * prime + this.ordenMedica.hashCode();
		hash = hash * prime + this.bodega.hashCode();
		
		return hash;
	}
}