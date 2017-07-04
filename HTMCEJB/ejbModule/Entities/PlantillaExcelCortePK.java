/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lcevallos
 */
@Embeddable
public class PlantillaExcelCortePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "fila")
    private int fila;
    @Basic(optional = false)
    @NotNull
    @Column(name = "columna")
    private int columna;

    public PlantillaExcelCortePK() {
    }

    public PlantillaExcelCortePK(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fila;
        hash += (int) columna;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantillaExcelCortePK)) {
            return false;
        }
        PlantillaExcelCortePK other = (PlantillaExcelCortePK) object;
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PlantillaExcelCortePK[ fila=" + fila + ", columna=" + columna + " ]";
    }
    
}
