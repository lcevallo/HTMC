/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.util.Date;

/**
 *
 * @author lcevallos
 */
public class SPDetalleItem {

	private String item;
	private Integer cantidad;
	private Integer bodega;
	private Date fecha;
	private String descripcion;
	private String ordenMedica;

	public SPDetalleItem() {

	}

	public SPDetalleItem(String item, Integer cantidad, Integer bodega,
			Date fecha, String descripcion, String ordenMedica) {

		this.item = item;
		this.cantidad = cantidad;
		this.bodega = bodega;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.ordenMedica = ordenMedica;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getBodega() {
		return bodega;
	}

	public void setBodega(Integer bodega) {
		this.bodega = bodega;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrdenMedica() {
		return ordenMedica;
	}

	public void setOrdenMedica(String ordenMedica) {
		this.ordenMedica = ordenMedica;
	}

}