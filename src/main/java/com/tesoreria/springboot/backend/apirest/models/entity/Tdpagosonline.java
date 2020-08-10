package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tdpagosonline")
public class Tdpagosonline {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="tsqdpagosonline", allocationSize = 1 )
	private Long dpago_regid;
	private int dpago_folpago;
	private String dpago_idingreso;
	private int dpago_cantidad;
	private double dpago_punit;
	private double dpago_descto;
	
	public Long getDpago_regid() {
		return dpago_regid;
	}
	public void setDpago_regid(Long dpago_regid) {
		this.dpago_regid = dpago_regid;
	}
	public int getDpago_folpago() {
		return dpago_folpago;
	}
	public void setDpago_folpago(int dpago_folpago) {
		this.dpago_folpago = dpago_folpago;
	}
	public String getDpago_idingreso() {
		return dpago_idingreso;
	}
	public void setDpago_idingreso(String dpago_idingreso) {
		this.dpago_idingreso = dpago_idingreso;
	}
	public int getDpago_cantidad() {
		return dpago_cantidad;
	}
	public void setDpago_cantidad(int dpago_cantidad) {
		this.dpago_cantidad = dpago_cantidad;
	}
	public double getDpago_punit() {
		return dpago_punit;
	}
	public void setDpago_punit(double dpago_punit) {
		this.dpago_punit = dpago_punit;
	}
	public double getDpago_descto() {
		return dpago_descto;
	}
	public void setDpago_descto(double dpago_descto) {
		this.dpago_descto = dpago_descto;
	}
	
	
	
}
