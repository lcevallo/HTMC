package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_item")
	private String codigoItem;

	private String coespe;

	private String cogrup;

	private String coordi;

	private String cosubg;

	private String cotipo;

	private String descripcion;

	//bi-directional many-to-one association to AreaItem
	@OneToMany(mappedBy="item")
	private List<AreaItem> areaItems;

	//bi-directional many-to-one association to EgresoItem
	@OneToMany(mappedBy="item")
	private List<EgresoItem> egresoItems;

	//bi-directional many-to-one association to IngresoItem
	@OneToMany(mappedBy="item")
	private List<IngresoItem> ingresoItems;

	//bi-directional many-to-one association to ConsolidadoAnual
	@OneToMany(mappedBy="item")	
	private List<ConsolidadoAnual> consolidadoAnuals;
	
	//bi-directional many-to-one association to MatrixCode
	@OneToMany(mappedBy="item")
	private List<MatrixCode> matrixCodes;
	
	//bi-directional many-to-one association to ItemMaxMin
		@OneToMany(mappedBy="item")
		private List<ItemMaxMin> itemMaxMins;

	public Item() {
	}

	public String getCodigoItem() {
		return this.codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getCoespe() {
		return this.coespe;
	}

	public void setCoespe(String coespe) {
		this.coespe = coespe;
	}

	public String getCogrup() {
		return this.cogrup;
	}

	public void setCogrup(String cogrup) {
		this.cogrup = cogrup;
	}

	public String getCoordi() {
		return this.coordi;
	}

	public void setCoordi(String coordi) {
		this.coordi = coordi;
	}

	public String getCosubg() {
		return this.cosubg;
	}

	public void setCosubg(String cosubg) {
		this.cosubg = cosubg;
	}

	public String getCotipo() {
		return this.cotipo;
	}

	public void setCotipo(String cotipo) {
		this.cotipo = cotipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AreaItem> getAreaItems() {
		return this.areaItems;
	}

	public void setAreaItems(List<AreaItem> areaItems) {
		this.areaItems = areaItems;
	}

	public AreaItem addAreaItem(AreaItem areaItem) {
		getAreaItems().add(areaItem);
		areaItem.setItem(this);

		return areaItem;
	}

	public AreaItem removeAreaItem(AreaItem areaItem) {
		getAreaItems().remove(areaItem);
		areaItem.setItem(null);

		return areaItem;
	}

	public List<EgresoItem> getEgresoItems() {
		return this.egresoItems;
	}

	public void setEgresoItems(List<EgresoItem> egresoItems) {
		this.egresoItems = egresoItems;
	}

	public EgresoItem addEgresoItem(EgresoItem egresoItem) {
		getEgresoItems().add(egresoItem);
		egresoItem.setItem(this);

		return egresoItem;
	}

	public EgresoItem removeEgresoItem(EgresoItem egresoItem) {
		getEgresoItems().remove(egresoItem);
		egresoItem.setItem(null);

		return egresoItem;
	}

	public List<IngresoItem> getIngresoItems() {
		return this.ingresoItems;
	}

	public void setIngresoItems(List<IngresoItem> ingresoItems) {
		this.ingresoItems = ingresoItems;
	}

	public IngresoItem addIngresoItem(IngresoItem ingresoItem) {
		getIngresoItems().add(ingresoItem);
		ingresoItem.setItem(this);

		return ingresoItem;
	}

	public IngresoItem removeIngresoItem(IngresoItem ingresoItem) {
		getIngresoItems().remove(ingresoItem);
		ingresoItem.setItem(null);

		return ingresoItem;
	}

	public List<ConsolidadoAnual> getConsolidadoAnuals() {
		return this.consolidadoAnuals;
	}

	public void setConsolidadoAnuals(List<ConsolidadoAnual> consolidadoAnuals) {
		this.consolidadoAnuals = consolidadoAnuals;
	}
	

	public List<MatrixCode> getMatrixCodes() {
		return matrixCodes;
	}

	public void setMatrixCodes(List<MatrixCode> matrixCodes) {
		this.matrixCodes = matrixCodes;
	}
	
	public List<ItemMaxMin> getItemMaxMins() {
		return this.itemMaxMins;
	}

	public void setItemMaxMins(List<ItemMaxMin> itemMaxMins) {
		this.itemMaxMins = itemMaxMins;
	}

	public ItemMaxMin addItemMaxMin(ItemMaxMin itemMaxMin) {
		getItemMaxMins().add(itemMaxMin);
		itemMaxMin.setItem(this);

		return itemMaxMin;
	}

	public ItemMaxMin removeItemMaxMin(ItemMaxMin itemMaxMin) {
		getItemMaxMins().remove(itemMaxMin);
		itemMaxMin.setItem(null);

		return itemMaxMin;
	}

}