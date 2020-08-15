package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tvdescuentos")
public class Tvdescuentos {

	@Id
	private Long vdes_foldescto;
	
	private String vdes_nombre;
	private String vdes_ures;
	private String vdes_uresdescrip;
	private String vdes_matricula;
	private String vdes_descdescrip;
	private String vdes_fecha;
	private String vdes_autoriza;
	
	public Long getVdes_foldescto() {
		return vdes_foldescto;
	}
	public void setVdes_foldescto(Long vdes_foldescto) {
		this.vdes_foldescto = vdes_foldescto;
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
	public String getVdes_fecha() {
		return vdes_fecha;
	}
	public void setVdes_fecha(String vdes_fecha) {
		this.vdes_fecha = vdes_fecha;
	}
	public String getVdes_autoriza() {
		return vdes_autoriza;
	}
	public void setVdes_autoriza(String vdes_autoriza) {
		this.vdes_autoriza = vdes_autoriza;
	}

	
}
