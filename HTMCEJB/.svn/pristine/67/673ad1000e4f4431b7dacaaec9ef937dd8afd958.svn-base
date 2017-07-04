package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the consolidado_item_percentil database table.
 * 
 */
@Entity
@Table(name="consolidado_item_percentil")
@NamedQuery(name="ConsolidadoItemPercentil.findAll", query="SELECT c FROM ConsolidadoItemPercentil c")
public class ConsolidadoItemPercentil implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsolidadoItemPercentilPK id;

	private String descripcion;

	public ConsolidadoItemPercentil() {
	}

	public ConsolidadoItemPercentilPK getId() {
		return this.id;
	}

	public void setId(ConsolidadoItemPercentilPK id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}