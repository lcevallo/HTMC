/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "vista_item_detalle_stock_sf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaItemDetalleStockSf.findAll", query = "SELECT v FROM VistaItemDetalleStockSf v"),
    @NamedQuery(name = "VistaItemDetalleStockSf.findById", query = "SELECT v FROM VistaItemDetalleStockSf v WHERE v.id = :id"),
    @NamedQuery(name = "VistaItemDetalleStockSf.findByMes", query = "SELECT v FROM VistaItemDetalleStockSf v WHERE v.mes = :mes"),
    @NamedQuery(name = "VistaItemDetalleStockSf.findByItemFk", query = "SELECT v FROM VistaItemDetalleStockSf v WHERE v.itemFk = :itemFk"),
    @NamedQuery(name = "VistaItemDetalleStockSf.findBySaldoMesAnterior", query = "SELECT v FROM VistaItemDetalleStockSf v WHERE v.saldoMesAnterior = :saldoMesAnterior"),
    @NamedQuery(name = "VistaItemDetalleStockSf.findByIngreso", query = "SELECT v FROM VistaItemDetalleStockSf v WHERE v.ingreso = :ingreso"),
    @NamedQuery(name = "VistaItemDetalleStockSf.findByAjusteIngreso", query = "SELECT v FROM VistaItemDetalleStockSf v WHERE v.ajusteIngreso = :ajusteIngreso"),
    @NamedQuery(name = "VistaItemDetalleStockSf.findByEgreso", query = "SELECT v FROM VistaItemDetalleStockSf v WHERE v.egreso = :egreso"),
    @NamedQuery(name = "VistaItemDetalleStockSf.findBySaldoMes", query = "SELECT v FROM VistaItemDetalleStockSf v WHERE v.saldoMes = :saldoMes")})
public class VistaItemDetalleStockSf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private BigInteger id;
    @Column(name = "mes")
    private Short mes;
    @Size(max = 25)
    @Column(name = "item_fk")
    private String itemFk;
    @Column(name = "saldo_mes_anterior")
    private BigInteger saldoMesAnterior;
    @Column(name = "ingreso")
    private BigInteger ingreso;
    @Column(name = "ajuste_ingreso")
    private BigInteger ajusteIngreso;
    @Column(name = "egreso")
    private BigInteger egreso;
    @Column(name = "saldo_mes")
    private BigInteger saldoMes;

    public VistaItemDetalleStockSf() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Short getMes() {
        return mes;
    }

    public void setMes(Short mes) {
        this.mes = mes;
    }

    public String getItemFk() {
        return itemFk;
    }

    public void setItemFk(String itemFk) {
        this.itemFk = itemFk;
    }

    public BigInteger getSaldoMesAnterior() {
        return saldoMesAnterior;
    }

    public void setSaldoMesAnterior(BigInteger saldoMesAnterior) {
        this.saldoMesAnterior = saldoMesAnterior;
    }

    public BigInteger getIngreso() {
        return ingreso;
    }

    public void setIngreso(BigInteger ingreso) {
        this.ingreso = ingreso;
    }

    public BigInteger getAjusteIngreso() {
        return ajusteIngreso;
    }

    public void setAjusteIngreso(BigInteger ajusteIngreso) {
        this.ajusteIngreso = ajusteIngreso;
    }

    public BigInteger getEgreso() {
        return egreso;
    }

    public void setEgreso(BigInteger egreso) {
        this.egreso = egreso;
    }

    public BigInteger getSaldoMes() {
        return saldoMes;
    }

    public void setSaldoMes(BigInteger saldoMes) {
        this.saldoMes = saldoMes;
    }
    
}
