package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the consolidado_anual database table.
 * 
 */
@Embeddable
public class ConsolidadoAnualPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_fk", insertable=false, updatable=false)
	private String itemFk;

	private Integer anio;

	private Integer mes;

	public ConsolidadoAnualPK() {
	}
	public String getItemFk() {
		return this.itemFk;
	}
	public void setItemFk(String itemFk) {
		this.itemFk = itemFk;
	}
	public Integer getAnio() {
		return this.anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getMes() {
		return this.mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsolidadoAnualPK)) {
			return false;
		}
		ConsolidadoAnualPK castOther = (ConsolidadoAnualPK)other;
		return 
			this.itemFk.equals(castOther.itemFk)
			&& this.anio.equals(castOther.anio)
			&& this.mes.equals(castOther.mes);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemFk.hashCode();
		hash = hash * prime + this.anio.hashCode();
		hash = hash * prime + this.mes.hashCode();
		
		return hash;
	}
}