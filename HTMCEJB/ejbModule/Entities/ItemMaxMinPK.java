package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_max_min database table.
 * 
 */
@Embeddable
public class ItemMaxMinPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="fk_codigo_item", insertable=false, updatable=false)
	private String fkCodigoItem;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicial")
	private java.util.Date fechaInicial;

	private Boolean estado;

	public ItemMaxMinPK() {
	}
	public String getFkCodigoItem() {
		return this.fkCodigoItem;
	}
	public void setFkCodigoItem(String fkCodigoItem) {
		this.fkCodigoItem = fkCodigoItem;
	}
	public java.util.Date getFechaInicial() {
		return this.fechaInicial;
	}
	public void setFechaInicial(java.util.Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Boolean getEstado() {
		return this.estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItemMaxMinPK)) {
			return false;
		}
		ItemMaxMinPK castOther = (ItemMaxMinPK)other;
		return 
			this.fkCodigoItem.equals(castOther.fkCodigoItem)
			&& this.fechaInicial.equals(castOther.fechaInicial)
			&& this.estado.equals(castOther.estado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fkCodigoItem.hashCode();
		hash = hash * prime + this.fechaInicial.hashCode();
		hash = hash * prime + this.estado.hashCode();
		
		return hash;
	}
}