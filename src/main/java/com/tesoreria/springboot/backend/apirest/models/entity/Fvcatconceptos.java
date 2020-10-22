package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fvcatconceptos")
public class Fvcatconceptos {
	
	@Id
	private String concepto;
	
	private String descripcion;
	private String punit;
	private String paquete;
	private String alumnos;
	private String personal;
	private String incorporadas;
	private String ures;
	private String publico;
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPunit() {
		return punit;
	}
	public void setPunit(String punit) {
		this.punit = punit;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public String getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(String alumnos) {
		this.alumnos = alumnos;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getIncorporadas() {
		return incorporadas;
	}
	public void setIncorporadas(String incorporadas) {
		this.incorporadas = incorporadas;
	}
	public String getUres() {
		return ures;
	}
	public void setUres(String ures) {
		this.ures = ures;
	}
	public String getPublico() {
		return publico;
	}
	public void setPublico(String publico) {
		this.publico = publico;
	}
	
	

}
