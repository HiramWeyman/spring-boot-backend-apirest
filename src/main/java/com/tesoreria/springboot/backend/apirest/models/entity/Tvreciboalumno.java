package com.tesoreria.springboot.backend.apirest.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tvreciboalumno")
public class Tvreciboalumno {

	private Integer folio;
	private Integer folio_descto;
	private String referencia_banco;
	private Date fecha;
	private String nombre_usuario;
	private String unidad_academica;
	private String descripcion;
	@Id
	private Integer vdet_regid;
	private String concepto;
	private Integer cantidad;
	private double punit;
	private double importe;
	private Integer descuento;
	private double monto_total;
	private String comentarios;
	
	
	public String getReferencia_banco() {
		return referencia_banco;
	}
	public void setReferencia_banco(String referencia_banco) {
		this.referencia_banco = referencia_banco;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public Integer getFolio_descto() {
		return folio_descto;
	}
	public void setFolio_descto(Integer folio_descto) {
		this.folio_descto = folio_descto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getUnidad_academica() {
		return unidad_academica;
	}
	public void setUnidad_academica(String unidad_academica) {
		this.unidad_academica = unidad_academica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getVdet_regid() {
		return vdet_regid;
	}
	public void setVdet_regid(Integer vdet_regid) {
		this.vdet_regid = vdet_regid;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public double getPunit() {
		return punit;
	}
	public void setPunit(double punit) {
		this.punit = punit;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Integer getDescuento() {
		return descuento;
	}
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	public double getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}
	
	
	
}
