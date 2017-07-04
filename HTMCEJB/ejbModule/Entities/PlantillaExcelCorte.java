/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lcevallos
 */
@Entity
@Table(name = "plantilla_excel_corte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlantillaExcelCorte.findAll", query = "SELECT p FROM PlantillaExcelCorte p"),
    @NamedQuery(name = "PlantillaExcelCorte.findByDescripcion", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PlantillaExcelCorte.findByNivelI", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.nivelI = :nivelI"),
    @NamedQuery(name = "PlantillaExcelCorte.findByNivelIi", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.nivelIi = :nivelIi"),
    @NamedQuery(name = "PlantillaExcelCorte.findByNivelIii", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.nivelIii = :nivelIii"),
    @NamedQuery(name = "PlantillaExcelCorte.findBySaldosAnteriores", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.saldosAnteriores = :saldosAnteriores"),
    @NamedQuery(name = "PlantillaExcelCorte.findByIngresos", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.ingresos = :ingresos"),
    @NamedQuery(name = "PlantillaExcelCorte.findByEgresos", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.egresos = :egresos"),
    @NamedQuery(name = "PlantillaExcelCorte.findBySaldos", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.saldos = :saldos"),
    @NamedQuery(name = "PlantillaExcelCorte.findByItemfk", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.itemfk = :itemfk"),
    @NamedQuery(name = "PlantillaExcelCorte.findByFila", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.plantillaExcelCortePK.fila = :fila"),
    @NamedQuery(name = "PlantillaExcelCorte.findByColumna", query = "SELECT p FROM PlantillaExcelCorte p WHERE p.plantillaExcelCortePK.columna = :columna")})
public class PlantillaExcelCorte implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlantillaExcelCortePK plantillaExcelCortePK;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nivel_i")
    private Character nivelI;
    @Column(name = "nivel_ii")
    private Character nivelIi;
    @Column(name = "nivel_iii")
    private Character nivelIii;
    @Column(name = "saldos_anteriores")
    private BigInteger saldosAnteriores;
    @Column(name = "ingresos")
    private BigInteger ingresos;
    @Column(name = "egresos")
    private BigInteger egresos;
    @Column(name = "saldos")
    private BigInteger saldos;
    @Size(max = 25)
    @Column(name = "itemfk")
    private String itemfk;

    public PlantillaExcelCorte() {
    }

    public PlantillaExcelCorte(PlantillaExcelCortePK plantillaExcelCortePK) {
        this.plantillaExcelCortePK = plantillaExcelCortePK;
    }

    public PlantillaExcelCorte(int fila, int columna) {
        this.plantillaExcelCortePK = new PlantillaExcelCortePK(fila, columna);
    }

    public PlantillaExcelCortePK getPlantillaExcelCortePK() {
        return plantillaExcelCortePK;
    }

    public void setPlantillaExcelCortePK(PlantillaExcelCortePK plantillaExcelCortePK) {
        this.plantillaExcelCortePK = plantillaExcelCortePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getNivelI() {
        return nivelI;
    }

    public void setNivelI(Character nivelI) {
        this.nivelI = nivelI;
    }

    public Character getNivelIi() {
        return nivelIi;
    }

    public void setNivelIi(Character nivelIi) {
        this.nivelIi = nivelIi;
    }

    public Character getNivelIii() {
        return nivelIii;
    }

    public void setNivelIii(Character nivelIii) {
        this.nivelIii = nivelIii;
    }

    public BigInteger getSaldosAnteriores() {
        return saldosAnteriores;
    }

    public void setSaldosAnteriores(BigInteger saldosAnteriores) {
        this.saldosAnteriores = saldosAnteriores;
    }

    public BigInteger getIngresos() {
        return ingresos;
    }

    public void setIngresos(BigInteger ingresos) {
        this.ingresos = ingresos;
    }

    public BigInteger getEgresos() {
        return egresos;
    }

    public void setEgresos(BigInteger egresos) {
        this.egresos = egresos;
    }

    public BigInteger getSaldos() {
        return saldos;
    }

    public void setSaldos(BigInteger saldos) {
        this.saldos = saldos;
    }

    public String getItemfk() {
        return itemfk;
    }

    public void setItemfk(String itemfk) {
        this.itemfk = itemfk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plantillaExcelCortePK != null ? plantillaExcelCortePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantillaExcelCorte)) {
            return false;
        }
        PlantillaExcelCorte other = (PlantillaExcelCorte) object;
        if ((this.plantillaExcelCortePK == null && other.plantillaExcelCortePK != null) || (this.plantillaExcelCortePK != null && !this.plantillaExcelCortePK.equals(other.plantillaExcelCortePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PlantillaExcelCorte[ plantillaExcelCortePK=" + plantillaExcelCortePK + " ]";
    }
    
}
