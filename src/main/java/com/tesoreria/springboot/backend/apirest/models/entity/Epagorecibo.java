package com.tesoreria.springboot.backend.apirest.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="epagorecibo", schema = "escolarteso")
public class Epagorecibo {

	private Long pago_folpago;
	
	@Id
	private Long pago_folregid;
	private String pago_comentarios;
	private String pago_user_recepcion;
	private Date pago_frecep;
	
	public Long getPago_folpago() {
		return pago_folpago;
	}
	public void setPago_folpago(Long pago_folpago) {
		this.pago_folpago = pago_folpago;
	}
	public Long getPago_folregid() {
		return pago_folregid;
	}
	public void setPago_folregid(Long pago_folregid) {
		this.pago_folregid = pago_folregid;
	}
	public String getPago_comentarios() {
		return pago_comentarios;
	}
	public void setPago_comentarios(String pago_comentarios) {
		this.pago_comentarios = pago_comentarios;
	}
	public String getPago_user_recepcion() {
		return pago_user_recepcion;
	}
	public void setPago_user_recepcion(String pago_user_recepcion) {
		this.pago_user_recepcion = pago_user_recepcion;
	}
	public Date getPago_frecep() {
		return pago_frecep;
	}
	public void setPago_frecep(Date pago_frecep) {
		this.pago_frecep = pago_frecep;
	}
	
	
}
