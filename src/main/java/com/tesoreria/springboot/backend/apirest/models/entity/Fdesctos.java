package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fdesctos")
public class Fdesctos {

	@Id
	private Long desc_foliodesc;
	
	private String desc_nombre;
	private String desc_ures;
	private String desc_matricula;
	private String desc_descrip;
	private String desc_fcancel;
	private String desc_ucancel;
	public Long getDesc_foliodesc() {
		return desc_foliodesc;
	}
	public void setDesc_foliodesc(Long desc_foliodesc) {
		this.desc_foliodesc = desc_foliodesc;
	}
	public String getDesc_nombre() {
		return desc_nombre;
	}
	public void setDesc_nombre(String desc_nombre) {
		this.desc_nombre = desc_nombre;
	}
	public String getDesc_ures() {
		return desc_ures;
	}
	public void setDesc_ures(String desc_ures) {
		this.desc_ures = desc_ures;
	}
	public String getDesc_matricula() {
		return desc_matricula;
	}
	public void setDesc_matricula(String desc_matricula) {
		this.desc_matricula = desc_matricula;
	}
	public String getDesc_descrip() {
		return desc_descrip;
	}
	public void setDesc_descrip(String desc_descrip) {
		this.desc_descrip = desc_descrip;
	}
	public String getDesc_fcancel() {
		return desc_fcancel;
	}
	public void setDesc_fcancel(String desc_fcancel) {
		this.desc_fcancel = desc_fcancel;
	}
	public String getDesc_ucancel() {
		return desc_ucancel;
	}
	public void setDesc_ucancel(String desc_ucancel) {
		this.desc_ucancel = desc_ucancel;
	}
	
	
	
}
