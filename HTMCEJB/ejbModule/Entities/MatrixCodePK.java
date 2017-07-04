package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the matrix_code database table.
 * 
 */
@Embeddable
public class MatrixCodePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "item_fk", insertable = false, updatable = false)
	private String itemFk;

	@Column(name = "id_dependencia", insertable = false, updatable = false)
	private Integer idDependencia;

	public MatrixCodePK() {
	}

	public String getItemFk() {
		return this.itemFk;
	}

	public void setItemFk(String itemFk) {
		this.itemFk = itemFk;
	}

	public Integer getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MatrixCodePK)) {
			return false;
		}
		MatrixCodePK castOther = (MatrixCodePK) other;
		return this.itemFk.equals(castOther.itemFk)
				&& this.idDependencia.equals(castOther.idDependencia);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemFk.hashCode();
		hash = hash * prime + this.idDependencia.hashCode();

		return hash;
	}
}