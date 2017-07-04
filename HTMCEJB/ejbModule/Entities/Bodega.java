/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findByCodigoBodega", query = "SELECT b FROM Bodega b WHERE b.codigoBodega = :codigoBodega"),
    @NamedQuery(name = "Bodega.findByNombreBodega", query = "SELECT b FROM Bodega b WHERE b.nombreBodega = :nombreBodega"),
    @NamedQuery(name = "Bodega.findByEstado", query = "SELECT b FROM Bodega b WHERE b.estado = :estado")})
public class Bodega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_bodega")
    private Integer codigoBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_bodega")
    private String nombreBodega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public Bodega() {
    }

    public Bodega(Integer codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public Bodega(Integer codigoBodega, String nombreBodega, boolean estado) {
        this.codigoBodega = codigoBodega;
        this.nombreBodega = nombreBodega;
        this.estado = estado;
    }

    public Integer getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(Integer codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoBodega != null ? codigoBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.codigoBodega == null && other.codigoBodega != null) || (this.codigoBodega != null && !this.codigoBodega.equals(other.codigoBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Bodega[ codigoBodega=" + codigoBodega + " ]";
    }
    
}
