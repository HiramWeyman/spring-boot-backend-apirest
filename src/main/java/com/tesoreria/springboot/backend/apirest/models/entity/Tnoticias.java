package com.tesoreria.springboot.backend.apirest.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tnoticias")
public class Tnoticias {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="tsqnoticias", allocationSize = 1 )
	private Long tnot_id;
	
	private String tnot_titulo;
	private String tnot_nota;
	private String tnot_ruta_img;
	private String tnot_autor;
	private String tnot_estatus;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date tnot_fecha;
	
	public Long getTnot_id() {
		return tnot_id;
	}
	public void setTnot_id(Long tnot_id) {
		this.tnot_id = tnot_id;
	}
	public String getTnot_titulo() {
		return tnot_titulo;
	}
	public void setTnot_titulo(String tnot_titulo) {
		this.tnot_titulo = tnot_titulo;
	}
	public String getTnot_nota() {
		return tnot_nota;
	}
	public void setTnot_nota(String tnot_nota) {
		this.tnot_nota = tnot_nota;
	}
	public String getTnot_ruta_img() {
		return tnot_ruta_img;
	}
	public void setTnot_ruta_img(String tnot_ruta_img) {
		this.tnot_ruta_img = tnot_ruta_img;
	}
	public String getTnot_autor() {
		return tnot_autor;
	}
	public void setTnot_autor(String tnot_autor) {
		this.tnot_autor = tnot_autor;
	}
	public Date getTnot_fecha() {
		return tnot_fecha;
	}
	public void setTnot_fecha(Date tnot_fecha) {
		this.tnot_fecha = tnot_fecha;
	}
	public String getTnot_estatus() {
		return tnot_estatus;
	}
	public void setTnot_estatus(String tnot_estatus) {
		this.tnot_estatus = tnot_estatus;
	}
	
}
