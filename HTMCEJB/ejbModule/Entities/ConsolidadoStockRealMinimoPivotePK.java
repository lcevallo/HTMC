package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the consolidado_stock_real_minimo_pivote database table.
 * 
 */
@Embeddable
public class ConsolidadoStockRealMinimoPivotePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String item;

	private Integer year;

	public ConsolidadoStockRealMinimoPivotePK() {
	}
	public String getItem() {
		return this.item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getYear() {
		return this.year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsolidadoStockRealMinimoPivotePK)) {
			return false;
		}
		ConsolidadoStockRealMinimoPivotePK castOther = (ConsolidadoStockRealMinimoPivotePK)other;
		return 
			this.item.equals(castOther.item)
			&& this.year.equals(castOther.year);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.item.hashCode();
		hash = hash * prime + this.year.hashCode();
		
		return hash;
	}
}