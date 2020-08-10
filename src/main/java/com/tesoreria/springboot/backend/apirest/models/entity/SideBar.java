package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trolesusuario")
public class SideBar {
	
	@Id
	private Long rolu_id;
	
	private String rolu_modulo_id;
	
	private String rolu_tipo_user;
	
	private String rolu_modulo_descrip;
	
	private String rolu_modulo_route;
	
	private String rolu_modulo_pred;
	
	public Long getRolu_id() {
		return rolu_id;
	}
	public void setRolu_id(Long rolu_id) {
		this.rolu_id = rolu_id;
	}
	
	public String getRolu_tipo_user() {
		return rolu_tipo_user;
	}
	public void setRolu_tipo_user(String rolu_tipo_user) {
		this.rolu_tipo_user = rolu_tipo_user;
	}
	public String getRolu_modulo_id() {
		return rolu_modulo_id;
	}
	public void setRolu_modulo_id(String rolu_modulo_id) {
		this.rolu_modulo_id = rolu_modulo_id;
	}
	public String getRolu_modulo_descrip() {
		return rolu_modulo_descrip;
	}
	public void setRolu_modulo_descrip(String rolu_modulo_descrip) {
		this.rolu_modulo_descrip = rolu_modulo_descrip;
	}
	public String getRolu_modulo_route() {
		return rolu_modulo_route;
	}
	public void setRolu_modulo_route(String rolu_modulo_route) {
		this.rolu_modulo_route = rolu_modulo_route;
	}
	public String getRolu_modulo_pred() {
		return rolu_modulo_pred;
	}
	public void setRolu_modulo_pred(String rolu_modulo_pred) {
		this.rolu_modulo_pred = rolu_modulo_pred;
	}

}
