package com.tesoreria.springboot.backend.apirest.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fcating")
public class Tvpagossiia {
	
	@Id
	private String vdet_foliopago;
	
	private Date vdet_fpago;
	private String vdet_usuario;
	private String vdet_nombre_usuario;
	private String vdet_unidad_academica;
	private String vdet_descripcion;
	private String vdet_foldescto;
	private String vdet_referencia;
	private String vdet_estatus;
	private String vdet_concepto;
	private String vdet_cantidad;
	private String vdet_punit;
	private String vdet_importe;
	private String vdet_descuento;
	private String vdet_monto_total;
	
	public String getVdet_foliopago() {
		return vdet_foliopago;
	}
	public void setVdet_foliopago(String vdet_foliopago) {
		this.vdet_foliopago = vdet_foliopago;
	}
	public Date getVdet_fpago() {
		return vdet_fpago;
	}
	public void setVdet_fpago(Date vdet_fpago) {
		this.vdet_fpago = vdet_fpago;
	}
	public String getVdet_usuario() {
		return vdet_usuario;
	}
	public void setVdet_usuario(String vdet_usuario) {
		this.vdet_usuario = vdet_usuario;
	}
	public String getVdet_nombre_usuario() {
		return vdet_nombre_usuario;
	}
	public void setVdet_nombre_usuario(String vdet_nombre_usuario) {
		this.vdet_nombre_usuario = vdet_nombre_usuario;
	}
	public String getVdet_unidad_academica() {
		return vdet_unidad_academica;
	}
	public void setVdet_unidad_academica(String vdet_unidad_academica) {
		this.vdet_unidad_academica = vdet_unidad_academica;
	}
	public String getVdet_descripcion() {
		return vdet_descripcion;
	}
	public void setVdet_descripcion(String vdet_descripcion) {
		this.vdet_descripcion = vdet_descripcion;
	}
	public String getVdet_foldescto() {
		return vdet_foldescto;
	}
	public void setVdet_foldescto(String vdet_foldescto) {
		this.vdet_foldescto = vdet_foldescto;
	}
	public String getVdet_referencia() {
		return vdet_referencia;
	}
	public void setVdet_referencia(String vdet_referencia) {
		this.vdet_referencia = vdet_referencia;
	}
	public String getVdet_estatus() {
		return vdet_estatus;
	}
	public void setVdet_estatus(String vdet_estatus) {
		this.vdet_estatus = vdet_estatus;
	}
	public String getVdet_concepto() {
		return vdet_concepto;
	}
	public void setVdet_concepto(String vdet_concepto) {
		this.vdet_concepto = vdet_concepto;
	}
	public String getVdet_cantidad() {
		return vdet_cantidad;
	}
	public void setVdet_cantidad(String vdet_cantidad) {
		this.vdet_cantidad = vdet_cantidad;
	}
	public String getVdet_punit() {
		return vdet_punit;
	}
	public void setVdet_punit(String vdet_punit) {
		this.vdet_punit = vdet_punit;
	}
	public String getVdet_importe() {
		return vdet_importe;
	}
	public void setVdet_importe(String vdet_importe) {
		this.vdet_importe = vdet_importe;
	}
	public String getVdet_descuento() {
		return vdet_descuento;
	}
	public void setVdet_descuento(String vdet_descuento) {
		this.vdet_descuento = vdet_descuento;
	}
	public String getVdet_monto_total() {
		return vdet_monto_total;
	}
	public void setVdet_monto_total(String vdet_monto_total) {
		this.vdet_monto_total = vdet_monto_total;
	}
	
	

}
