package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the area_item database table.
 * 
 */
@Embeddable
public class AreaItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_fk", insertable=false, updatable=false)
	private String itemFk;

	@Column(name="area_fk", insertable=false, updatable=false)
	private Integer areaFk;

	public AreaItemPK() {
	}
	public String getItemFk() {
		return this.itemFk;
	}
	public void setItemFk(String itemFk) {
		this.itemFk = itemFk;
	}
	public Integer getAreaFk() {
		return this.areaFk;
	}
	public void setAreaFk(Integer areaFk) {
		this.areaFk = areaFk;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AreaItemPK)) {
			return false;
		}
		AreaItemPK castOther = (AreaItemPK)other;
		return 
			this.itemFk.equals(castOther.itemFk)
			&& this.areaFk.equals(castOther.areaFk);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemFk.hashCode();
		hash = hash * prime + this.areaFk.hashCode();
		
		return hash;
	}
}