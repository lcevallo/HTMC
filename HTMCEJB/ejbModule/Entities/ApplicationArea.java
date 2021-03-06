package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the application_area database table.
 * 
 */
@Entity
@Table(name="application_area")
@NamedQuery(name="ApplicationArea.findAll", query="SELECT a FROM ApplicationArea a")
public class ApplicationArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_area")
	private Integer idArea;
	

	@Column(name="area_descripcion")
	private String areaDescripcion;

	//bi-directional many-to-one association to AreaItem
	@OneToMany(mappedBy="applicationArea")
	private List<AreaItem> areaItems;

	public ApplicationArea() {
	}

	public Integer getIdArea() {
		return this.idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getAreaDescripcion() {
		return this.areaDescripcion;
	}

	public void setAreaDescripcion(String areaDescripcion) {
		this.areaDescripcion = areaDescripcion;
	}

	public List<AreaItem> getAreaItems() {
		return this.areaItems;
	}

	public void setAreaItems(List<AreaItem> areaItems) {
		this.areaItems = areaItems;
	}

	public AreaItem addAreaItem(AreaItem areaItem) {
		getAreaItems().add(areaItem);
		areaItem.setApplicationArea(this);

		return areaItem;
	}

	public AreaItem removeAreaItem(AreaItem areaItem) {
		getAreaItems().remove(areaItem);
		areaItem.setApplicationArea(null);

		return areaItem;
	}

}