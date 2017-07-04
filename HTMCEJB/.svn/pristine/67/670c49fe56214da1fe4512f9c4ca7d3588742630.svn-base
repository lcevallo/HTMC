/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "vista_consolidado_stock_real_pivote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findAll", query = "SELECT v FROM VistaConsolidadoStockRealPivote v"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findByAreaDescripcion", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.areaDescripcion = :areaDescripcion"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findByYear", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.year = :year"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaEne", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaEne = :sumaEne"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaFeb", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaFeb = :sumaFeb"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaMar", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaMar = :sumaMar"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaAbr", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaAbr = :sumaAbr"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaMay", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaMay = :sumaMay"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaJun", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaJun = :sumaJun"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaJul", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaJul = :sumaJul"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaAgo", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaAgo = :sumaAgo"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaSep", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaSep = :sumaSep"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaOct", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaOct = :sumaOct"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaNov", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaNov = :sumaNov"),
    @NamedQuery(name = "VistaConsolidadoStockRealPivote.findBySumaDic", query = "SELECT v FROM VistaConsolidadoStockRealPivote v WHERE v.sumaDic = :sumaDic")})
public class VistaConsolidadoStockRealPivote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 75)
    @Id
    @Column(name = "area_descripcion")
    private String areaDescripcion;
    @Column(name = "year")
    private Integer year;
    @Column(name = "suma_ene")
    private Long sumaEne;
    @Column(name = "suma_feb")
    private Long sumaFeb;
    @Column(name = "suma_mar")
    private Long sumaMar;
    @Column(name = "suma_abr")
    private Long sumaAbr;
    @Column(name = "suma_may")
    private Long sumaMay;
    @Column(name = "suma_jun")
    private Long sumaJun;
    @Column(name = "suma_jul")
    private Long sumaJul;
    @Column(name = "suma_ago")
    private Long sumaAgo;
    @Column(name = "suma_sep")
    private Long sumaSep;
    @Column(name = "suma_oct")
    private Long sumaOct;
    @Column(name = "suma_nov")
    private Long sumaNov;
    @Column(name = "suma_dic")
    private Long sumaDic;

    public VistaConsolidadoStockRealPivote() {
    }

    public String getAreaDescripcion() {
        return areaDescripcion;
    }

    public void setAreaDescripcion(String areaDescripcion) {
        this.areaDescripcion = areaDescripcion;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getSumaEne() {
        return sumaEne;
    }

    public void setSumaEne(Long sumaEne) {
        this.sumaEne = sumaEne;
    }

    public Long getSumaFeb() {
        return sumaFeb;
    }

    public void setSumaFeb(Long sumaFeb) {
        this.sumaFeb = sumaFeb;
    }

    public Long getSumaMar() {
        return sumaMar;
    }

    public void setSumaMar(Long sumaMar) {
        this.sumaMar = sumaMar;
    }

    public Long getSumaAbr() {
        return sumaAbr;
    }

    public void setSumaAbr(Long sumaAbr) {
        this.sumaAbr = sumaAbr;
    }

    public Long getSumaMay() {
        return sumaMay;
    }

    public void setSumaMay(Long sumaMay) {
        this.sumaMay = sumaMay;
    }

    public Long getSumaJun() {
        return sumaJun;
    }

    public void setSumaJun(Long sumaJun) {
        this.sumaJun = sumaJun;
    }

    public Long getSumaJul() {
        return sumaJul;
    }

    public void setSumaJul(Long sumaJul) {
        this.sumaJul = sumaJul;
    }

    public Long getSumaAgo() {
        return sumaAgo;
    }

    public void setSumaAgo(Long sumaAgo) {
        this.sumaAgo = sumaAgo;
    }

    public Long getSumaSep() {
        return sumaSep;
    }

    public void setSumaSep(Long sumaSep) {
        this.sumaSep = sumaSep;
    }

    public Long getSumaOct() {
        return sumaOct;
    }

    public void setSumaOct(Long sumaOct) {
        this.sumaOct = sumaOct;
    }

    public Long getSumaNov() {
        return sumaNov;
    }

    public void setSumaNov(Long sumaNov) {
        this.sumaNov = sumaNov;
    }

    public Long getSumaDic() {
        return sumaDic;
    }

    public void setSumaDic(Long sumaDic) {
        this.sumaDic = sumaDic;
    }
    
}
