package com.tesoreria.springboot.backend.apirest.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tvdesctodetalle")
public class Tvdesctodetalle {

	@Id
	private String vdes_id;
	
	private Long vdes_foldescto;
	private String vdes_regid;
	private String vdes_nombre;
	private String vdes_ures;
	private String vdes_uresdescrip;
	private String vdes_matricula;
	private String vdes_descdescrip;
	private Date vdes_fecha;
	private String vdes_autoriza;
	private String vdes_concepto;
	private String vdes_cantidad;
	private String vdes_punit;
	private String vdes_porc;
	private String vdes_importe;
	private String vdes_monto_descto;
	private String vdes_a_pagar;
	public Long getVdes_foldescto() {
		return vdes_foldescto;
	}
	public void setVdes_foldescto(Long vdes_foldescto) {
		this.vdes_foldescto = vdes_foldescto;
	}
	public String getVdes_regid() {
		return vdes_regid;
	}
	public void setVdes_regid(String vdes_regid) {
		this.vdes_regid = vdes_regid;
	}
	public String getVdes_nombre() {
		return vdes_nombre;
	}
	public void setVdes_nombre(String vdes_nombre) {
		this.vdes_nombre = vdes_nombre;
	}
	public String getVdes_ures() {
		return vdes_ures;
	}
	public void setVdes_ures(String vdes_ures) {
		this.vdes_ures = vdes_ures;
	}
	public String getVdes_uresdescrip() {
		return vdes_uresdescrip;
	}
	public void setVdes_uresdescrip(String vdes_uresdescrip) {
		this.vdes_uresdescrip = vdes_uresdescrip;
	}
	public String getVdes_matricula() {
		return vdes_matricula;
	}
	public void setVdes_matricula(String vdes_matricula) {
		this.vdes_matricula = vdes_matricula;
	}
	public String getVdes_descdescrip() {
		return vdes_descdescrip;
	}
	public void setVdes_descdescrip(String vdes_descdescrip) {
		this.vdes_descdescrip = vdes_descdescrip;
	}
	public Date getVdes_fecha() {
		return vdes_fecha;
	}
	public void setVdes_fecha(Date vdes_fecha) {
		this.vdes_fecha = vdes_fecha;
	}
	public String getVdes_autoriza() {
		return vdes_autoriza;
	}
	public void setVdes_autoriza(String vdes_autoriza) {
		this.vdes_autoriza = vdes_autoriza;
	}
	public String getVdes_id() {
		return vdes_id;
	}
	public void setVdes_id(String vdes_id) {
		this.vdes_id = vdes_id;
	}
	public String getVdes_concepto() {
		return vdes_concepto;
	}
	public void setVdes_concepto(String vdes_concepto) {
		this.vdes_concepto = vdes_concepto;
	}
	public String getVdes_cantidad() {
		return vdes_cantidad;
	}
	public void setVdes_cantidad(String vdes_cantidad) {
		this.vdes_cantidad = vdes_cantidad;
	}
	public String getVdes_punit() {
		return vdes_punit;
	}
	public void setVdes_punit(String vdes_punit) {
		this.vdes_punit = vdes_punit;
	}
	public String getVdes_porc() {
		return vdes_porc;
	}
	public void setVdes_porc(String vdes_porc) {
		this.vdes_porc = vdes_porc;
	}
	public String getVdes_importe() {
		return vdes_importe;
	}
	public void setVdes_importe(String vdes_importe) {
		this.vdes_importe = vdes_importe;
	}
	public String getVdes_monto_descto() {
		return vdes_monto_descto;
	}
	public void setVdes_monto_descto(String vdes_monto_descto) {
		this.vdes_monto_descto = vdes_monto_descto;
	}
	public String getVdes_a_pagar() {
		return vdes_a_pagar;
	}
	public void setVdes_a_pagar(String vdes_a_pagar) {
		this.vdes_a_pagar = vdes_a_pagar;
	}
	
	
	
}
