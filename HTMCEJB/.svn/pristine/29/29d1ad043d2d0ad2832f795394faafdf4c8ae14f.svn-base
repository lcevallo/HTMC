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
import javax.validation.constraints.Size;

/**
 *
 * @author lcevallos
 */
@Embeddable
public class ConsolidadoStockRealPivoteSfPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "item")
    private String item;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;

    public ConsolidadoStockRealPivoteSfPK() {
    }

    public ConsolidadoStockRealPivoteSfPK(String item, int year) {
        this.item = item;
        this.year = year;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (item != null ? item.hashCode() : 0);
        hash += (int) year;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
      
        if (!(object instanceof ConsolidadoStockRealPivoteSfPK)) {
            return false;
        }
        ConsolidadoStockRealPivoteSfPK other = (ConsolidadoStockRealPivoteSfPK) object;
        if ((this.item == null && other.item != null) || (this.item != null && !this.item.equals(other.item))) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ConsolidadoStockRealPivoteSfPK[ item=" + item + ", year=" + year + " ]";
    }
    
}
