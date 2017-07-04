package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the egreso_items database table.
 * 
 */
@Entity
@Table(name="egreso_items")
@NamedQuery(name="EgresoItem.findAll", query="SELECT e FROM EgresoItem e")
public class EgresoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EgresoItemPK id;

	private Integer anio;

	private Integer dia;

	@Column(name="dia_texto")
	private String diaTexto;

	@Column(name="hora_texto")
	private String horaTexto;

	private Integer mes;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="itemfk", insertable = false, updatable = false)
	private Item item;

	public EgresoItem() {
	}

	public EgresoItemPK getId() {
		return this.id;
	}

	public void setId(EgresoItemPK id) {
		this.id = id;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDiaTexto() {
		return this.diaTexto;
	}

	public void setDiaTexto(String diaTexto) {
		this.diaTexto = diaTexto;
	}

	public String getHoraTexto() {
		return this.horaTexto;
	}

	public void setHoraTexto(String horaTexto) {
		this.horaTexto = horaTexto;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}