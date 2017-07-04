package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the area_item database table.
 * 
 */
@Entity
@Table(name="area_item")
@NamedQuery(name="AreaItem.findAll", query="SELECT a FROM AreaItem a")
public class AreaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AreaItemPK id;

	private Boolean estado;

	//bi-directional many-to-one association to ApplicationArea
	@ManyToOne
	@JoinColumn(name="area_fk", insertable = false, updatable = false)
	private ApplicationArea applicationArea;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="item_fk", insertable = false, updatable = false)
	private Item item;

	public AreaItem() {
	}

	public AreaItemPK getId() {
		return this.id;
	}

	public void setId(AreaItemPK id) {
		this.id = id;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public ApplicationArea getApplicationArea() {
		return this.applicationArea;
	}

	public void setApplicationArea(ApplicationArea applicationArea) {
		this.applicationArea = applicationArea;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}