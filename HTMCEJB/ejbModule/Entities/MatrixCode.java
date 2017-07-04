package Entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the matrix_code database table.
 * 
 */
@Entity
@Table(name = "matrix_code")
@NamedQuery(name = "MatrixCode.findAll", query = "SELECT m FROM MatrixCode m")
public class MatrixCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatrixCodePK id;

	// bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name = "item_fk", insertable = false, updatable = false)
	private Item item;

	// bi-directional many-to-one association to UnidadDependencia
	@ManyToOne
	@JoinColumn(name = "id_dependencia", insertable = false, updatable = false)
	private UnidadDependencia unidadDependencia;

	private String codigo;

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public MatrixCode() {
	}

	public MatrixCodePK getId() {
		return this.id;
	}

	public void setId(MatrixCodePK id) {
		this.id = id;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public UnidadDependencia getUnidadDependencia() {
		return this.unidadDependencia;
	}

	public void setUnidadDependencia(UnidadDependencia unidadDependencia) {
		this.unidadDependencia = unidadDependencia;
	}

}