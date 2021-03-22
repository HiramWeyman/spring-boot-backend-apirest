package com.tesoreria.springboot.backend.apirest.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tvpagoenescolar")
public class Tvpagoenescolar {

	@Id
	private  Integer reci_folio;
	
	
	private Date reci_fecha;
	private String reci_alumno;
	private String reci_ures;
	private String reci_concepto;
	private Integer reci_cantidad;
	private double reci_punit;
	private double reci_importe;
	private double reci_descuento;
	private double reci_total;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date reci_frecepcion;
	private String reci_comentarios;
	
	public Integer getReci_folio() {
		return reci_folio;
	}
	public void setReci_folio(Integer reci_folio) {
		this.reci_folio = reci_folio;
	}
	public Date getReci_fecha() {
		return reci_fecha;
	}
	public void setReci_fecha(Date reci_fecha) {
		this.reci_fecha = reci_fecha;
	}
	public String getReci_alumno() {
		return reci_alumno;
	}
	public void setReci_alumno(String reci_alumno) {
		this.reci_alumno = reci_alumno;
	}
	public String getReci_ures() {
		return reci_ures;
	}
	public void setReci_ures(String reci_ures) {
		this.reci_ures = reci_ures;
	}
	public String getReci_concepto() {
		return reci_concepto;
	}
	public void setReci_concepto(String reci_concepto) {
		this.reci_concepto = reci_concepto;
	}
	public Integer getReci_cantidad() {
		return reci_cantidad;
	}
	public void setReci_cantidad(Integer reci_cantidad) {
		this.reci_cantidad = reci_cantidad;
	}
	public double getReci_punit() {
		return reci_punit;
	}
	public void setReci_punit(double reci_punit) {
		this.reci_punit = reci_punit;
	}
	public double getReci_importe() {
		return reci_importe;
	}
	public void setReci_importe(double reci_importe) {
		this.reci_importe = reci_importe;
	}
	public double getReci_descuento() {
		return reci_descuento;
	}
	public void setReci_descuento(double reci_descuento) {
		this.reci_descuento = reci_descuento;
	}
	public double getReci_total() {
		return reci_total;
	}
	public void setReci_total(double reci_total) {
		this.reci_total = reci_total;
	}
	public Date getReci_frecepcion() {
		return reci_frecepcion;
	}
	public void setReci_frecepcion(Date reci_frecepcion) {
		this.reci_frecepcion = reci_frecepcion;
	}
	public String getReci_comentarios() {
		return reci_comentarios;
	}
	public void setReci_comentarios(String reci_comentarios) {
		this.reci_comentarios = reci_comentarios;
	}
	
	
}
