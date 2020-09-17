package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tequipo")
public class Tequipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="tsqequipo", allocationSize = 1 )
	private Long teq_id;
	
	private String teq_nombre;
	private String teq_puesto;
	private String teq_ruta_img;
	private String teq_estatus;
	public Long getTeq_id() {
		return teq_id;
	}
	public void setTeq_id(Long teq_id) {
		this.teq_id = teq_id;
	}
	public String getTeq_nombre() {
		return teq_nombre;
	}
	public void setTeq_nombre(String teq_nombre) {
		this.teq_nombre = teq_nombre;
	}
	public String getTeq_puesto() {
		return teq_puesto;
	}
	public void setTeq_puesto(String teq_puesto) {
		this.teq_puesto = teq_puesto;
	}
	public String getTeq_ruta_img() {
		return teq_ruta_img;
	}
	public void setTeq_ruta_img(String teq_ruta_img) {
		this.teq_ruta_img = teq_ruta_img;
	}
	public String getTeq_estatus() {
		return teq_estatus;
	}
	public void setTeq_estatus(String teq_estatus) {
		this.teq_estatus = teq_estatus;
	}

	
}
