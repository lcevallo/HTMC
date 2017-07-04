package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the item_max_min database table.
 * 
 */
@Entity
@Table(name = "item_max_min")
@NamedQuery(name = "ItemMaxMin.findAll", query = "SELECT i FROM ItemMaxMin i")
public class ItemMaxMin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemMaxMinPK id;

	@Column(name = "fecha_final")
	private Timestamp fechaFinal;

	private Integer maximo;

	private Integer minimo;

	// bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name = "fk_codigo_item", insertable = false, updatable = false)
	private Item item;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;

	public ItemMaxMin() {
	}

	public ItemMaxMinPK getId() {
		return this.id;
	}

	public void setId(ItemMaxMinPK id) {
		this.id = id;
	}

	public Timestamp getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Integer getMaximo() {
		return this.maximo;
	}

	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}

	public Integer getMinimo() {
		return this.minimo;
	}

	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}