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
import javax.persistence.Table;

/**
 * The persistent class for the unidad_dependencia database table.
 * 
 */
@Entity
@Table(name = "unidad_dependencia")
@NamedQuery(name = "UnidadDependencia.findAll", query = "SELECT u FROM UnidadDependencia u")
public class UnidadDependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre_unidad")
	private String nombreUnidad;

	// bi-directional many-to-one association to MatrixCode
	@OneToMany(mappedBy = "unidadDependencia")
	private List<MatrixCode> matrixCodes;

	public UnidadDependencia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUnidad() {
		return this.nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public List<MatrixCode> getMatrixCodes() {
		return matrixCodes;
	}

	public void setMatrixCodes(List<MatrixCode> matrixCodes) {
		this.matrixCodes = matrixCodes;
	}

}