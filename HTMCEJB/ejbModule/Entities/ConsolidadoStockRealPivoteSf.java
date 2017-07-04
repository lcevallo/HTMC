/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;

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
@Table(name = "consolidado_stock_real_pivote_sf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findAll", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByItem", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.consolidadoStockRealPivoteSfPK.item = :item"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByYear", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.consolidadoStockRealPivoteSfPK.year = :year"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByDescripcion", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByEne", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.ene = :ene"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByFeb", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.feb = :feb"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByMar", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.mar = :mar"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByAbr", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.abr = :abr"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByMay", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.may = :may"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByJun", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.jun = :jun"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByJul", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.jul = :jul"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByAgo", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.ago = :ago"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findBySep", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.sep = :sep"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByOct", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.oct = :oct"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByNov", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.nov = :nov"),
    @NamedQuery(name = "ConsolidadoStockRealPivoteSf.findByDic", query = "SELECT c FROM ConsolidadoStockRealPivoteSf c WHERE c.dic = :dic")})
public class ConsolidadoStockRealPivoteSf implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsolidadoStockRealPivoteSfPK consolidadoStockRealPivoteSfPK;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "ene")
    private Integer ene;
    @Column(name = "feb")
    private Integer feb;
    @Column(name = "mar")
    private Integer mar;
    @Column(name = "abr")
    private Integer abr;
    @Column(name = "may")
    private Integer may;
    @Column(name = "jun")
    private Integer jun;
    @Column(name = "jul")
    private Integer jul;
    @Column(name = "ago")
    private Integer ago;
    @Column(name = "sep")
    private Integer sep;
    @Column(name = "oct")
    private Integer oct;
    @Column(name = "nov")
    private Integer nov;
    @Column(name = "dic")
    private Integer dic;
    
    @Column(name="cuadro_base")
	private String cuadroBase;
	
	

	public String getCuadroBase() {
		return cuadroBase;
	}

	public void setCuadroBase(String cuadroBase) {
		this.cuadroBase = cuadroBase;
	}

    public ConsolidadoStockRealPivoteSf() {
    }

    public ConsolidadoStockRealPivoteSf(ConsolidadoStockRealPivoteSfPK consolidadoStockRealPivoteSfPK) {
        this.consolidadoStockRealPivoteSfPK = consolidadoStockRealPivoteSfPK;
    }

    public ConsolidadoStockRealPivoteSf(String item, int year) {
        this.consolidadoStockRealPivoteSfPK = new ConsolidadoStockRealPivoteSfPK(item, year);
    }

    public ConsolidadoStockRealPivoteSfPK getConsolidadoStockRealPivoteSfPK() {
        return consolidadoStockRealPivoteSfPK;
    }

    public void setConsolidadoStockRealPivoteSfPK(ConsolidadoStockRealPivoteSfPK consolidadoStockRealPivoteSfPK) {
        this.consolidadoStockRealPivoteSfPK = consolidadoStockRealPivoteSfPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEne() {
        return ene;
    }

    public void setEne(Integer ene) {
        this.ene = ene;
    }

    public Integer getFeb() {
        return feb;
    }

    public void setFeb(Integer feb) {
        this.feb = feb;
    }

    public Integer getMar() {
        return mar;
    }

    public void setMar(Integer mar) {
        this.mar = mar;
    }

    public Integer getAbr() {
        return abr;
    }

    public void setAbr(Integer abr) {
        this.abr = abr;
    }

    public Integer getMay() {
        return may;
    }

    public void setMay(Integer may) {
        this.may = may;
    }

    public Integer getJun() {
        return jun;
    }

    public void setJun(Integer jun) {
        this.jun = jun;
    }

    public Integer getJul() {
        return jul;
    }

    public void setJul(Integer jul) {
        this.jul = jul;
    }

    public Integer getAgo() {
        return ago;
    }

    public void setAgo(Integer ago) {
        this.ago = ago;
    }

    public Integer getSep() {
        return sep;
    }

    public void setSep(Integer sep) {
        this.sep = sep;
    }

    public Integer getOct() {
        return oct;
    }

    public void setOct(Integer oct) {
        this.oct = oct;
    }

    public Integer getNov() {
        return nov;
    }

    public void setNov(Integer nov) {
        this.nov = nov;
    }

    public Integer getDic() {
        return dic;
    }

    public void setDic(Integer dic) {
        this.dic = dic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consolidadoStockRealPivoteSfPK != null ? consolidadoStockRealPivoteSfPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ConsolidadoStockRealPivoteSf)) {
            return false;
        }
        ConsolidadoStockRealPivoteSf other = (ConsolidadoStockRealPivoteSf) object;
        if ((this.consolidadoStockRealPivoteSfPK == null && other.consolidadoStockRealPivoteSfPK != null) || (this.consolidadoStockRealPivoteSfPK != null && !this.consolidadoStockRealPivoteSfPK.equals(other.consolidadoStockRealPivoteSfPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ConsolidadoStockRealPivoteSf[ consolidadoStockRealPivoteSfPK=" + consolidadoStockRealPivoteSfPK + " ]";
    }
    
}
