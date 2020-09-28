package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tservicios")
public class Tservicios {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="tsqservicios", allocationSize = 1 )
	private Long tser_id;
	
	private String tser_servicio;
	private String tser_descripcion;
	private String teq_ruta_img;
	private String teq_estatus;
	
	public Long getTser_id() {
		return tser_id;
	}
	public void setTser_id(Long tser_id) {
		this.tser_id = tser_id;
	}
	public String getTser_servicio() {
		return tser_servicio;
	}
	public void setTser_servicio(String tser_servicio) {
		this.tser_servicio = tser_servicio;
	}
	public String getTser_descripcion() {
		return tser_descripcion;
	}
	public void setTser_descripcion(String tser_descripcion) {
		this.tser_descripcion = tser_descripcion;
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
