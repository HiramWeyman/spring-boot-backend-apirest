package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ttipouser")
public class Ttipouser {
	
	@Id
	private String tipo_userid;
	
	private String tipo_descrip;
	
	private String tipo_tipo;

	public String getTipo_userid() {
		return tipo_userid;
	}

	public void setTipo_userid(String tipo_userid) {
		this.tipo_userid = tipo_userid;
	}

	public String getTipo_descrip() {
		return tipo_descrip;
	}

	public void setTipo_descrip(String tipo_descrip) {
		this.tipo_descrip = tipo_descrip;
	}

	public String getTipo_tipo() {
		return tipo_tipo;
	}

	public void setTipo_tipo(String tipo_tipo) {
		this.tipo_tipo = tipo_tipo;
	}

}
