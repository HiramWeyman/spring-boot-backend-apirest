package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbanner")
public class Tbanner {
	
	@Id
	private Long tban_id;
	private String tban_descripcion;
	private String tban_ruta_img;
	public Long getTban_id() {
		return tban_id;
	}
	public void setTban_id(Long tban_id) {
		this.tban_id = tban_id;
	}
	public String getTban_descripcion() {
		return tban_descripcion;
	}
	public void setTban_descripcion(String tban_descripcion) {
		this.tban_descripcion = tban_descripcion;
	}
	public String getTban_ruta_img() {
		return tban_ruta_img;
	}
	public void setTban_ruta_img(String tban_ruta_img) {
		this.tban_ruta_img = tban_ruta_img;
	}

	
}
