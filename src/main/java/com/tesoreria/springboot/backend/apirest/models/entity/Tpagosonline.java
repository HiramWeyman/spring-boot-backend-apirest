package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tpagosonline")
public class Tpagosonline {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="TSQPAGOSONLINE", allocationSize = 1 )
	private Long pago_folpago;
	private String pago_usuaid;
	private String pago_concepto;
	private String pago_montoapagar;
	private String pago_referencia;
	private String pago_user;
	private String pago_estatus;
	private String pago_foldescto;
	
	public String getPago_user() {
		return pago_user;
	}

	public void setPago_user(String pago_user) {
		this.pago_user = pago_user;
	}
	public String getPago_foldescto() {
		return pago_foldescto;
	}

	public void setPago_foldescto(String pago_foldescto) {
		this.pago_foldescto = pago_foldescto;
	}

	public String getPago_estatus() {
		return pago_estatus;
	}

	public void setPago_estatus(String pago_estatus) {
		this.pago_estatus = pago_estatus;
	}

	public String getPago_referencia() {
		return pago_referencia;
	}

	public void setPago_referencia(String pago_referencia) {
		this.pago_referencia = pago_referencia;
	}

	public String getPago_usuaid() {
		return pago_usuaid;
	}

	public void setPago_usuaid(String pago_usuaid) {
		this.pago_usuaid = pago_usuaid;
	}

	public String getPago_concepto() {
		return pago_concepto;
	}

	public void setPago_concepto(String pago_concepto) {
		this.pago_concepto = pago_concepto;
	}

	public String getPago_montoapagar() {
		return pago_montoapagar;
	}

	public void setPago_montoapagar(String pago_montoapagar) {
		this.pago_montoapagar = pago_montoapagar;
	}

	public Long getPago_folpago() {
		return pago_folpago;
	}

	public void setPago_folpago(Long pago_folpago) {
		this.pago_folpago = pago_folpago;
	}

}
