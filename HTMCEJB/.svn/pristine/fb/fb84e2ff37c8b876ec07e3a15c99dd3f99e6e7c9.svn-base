package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the consolidado_item_percentil database table.
 * 
 */
@Embeddable
public class ConsolidadoItemPercentilPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_fk")
	private String itemFk;

	private Integer year;

	private float myresult;

	public ConsolidadoItemPercentilPK() {
	}
	public String getItemFk() {
		return this.itemFk;
	}
	public void setItemFk(String itemFk) {
		this.itemFk = itemFk;
	}
	public Integer getYear() {
		return this.year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public float getMyresult() {
		return this.myresult;
	}
	public void setMyresult(float myresult) {
		this.myresult = myresult;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsolidadoItemPercentilPK)) {
			return false;
		}
		ConsolidadoItemPercentilPK castOther = (ConsolidadoItemPercentilPK)other;
		return 
			this.itemFk.equals(castOther.itemFk)
			&& this.year.equals(castOther.year)
			&& (this.myresult == castOther.myresult);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemFk.hashCode();
		hash = hash * prime + this.year.hashCode();
		hash = hash * prime + java.lang.Float.floatToIntBits(this.myresult);
		
		return hash;
	}
}