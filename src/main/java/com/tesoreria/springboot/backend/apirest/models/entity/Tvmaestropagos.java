package com.tesoreria.springboot.backend.apirest.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tvmaestropagos")
public class Tvmaestropagos {
	
	@Id
	private String vmae_foliopago;
	
	private Date vmae_fecha;
	private String vmae_usuario;
	private String vmae_nombre_usuario;
	private String vmae_ures;
	private String vmae_program;
	private String vmae_tipouser;
	private String vmae_descripcion;
	private String vmae_referencia;
	private String vmae_estatus;
	private String vmae_est_descrip;
	private String vmae_foldescto; 
	private String vmae_importe;
	
	
	public String getVmae_foldescto() {
		return vmae_foldescto;
	}
	public void setVmae_foldescto(String vmae_foldescto) {
		this.vmae_foldescto = vmae_foldescto;
	}
	public String getVmae_foliopago() {
		return vmae_foliopago;
	}
	public void setVmae_foliopago(String vmae_foliopago) {
		this.vmae_foliopago = vmae_foliopago;
	}
	public Date getVmae_fecha() {
		return vmae_fecha;
	}
	public void setVmae_fecha(Date vmae_fecha) {
		this.vmae_fecha = vmae_fecha;
	}
	public String getVmae_usuario() {
		return vmae_usuario;
	}
	public void setVmae_usuario(String vmae_usuario) {
		this.vmae_usuario = vmae_usuario;
	}
	public String getVmae_nombre_usuario() {
		return vmae_nombre_usuario;
	}
	public void setVmae_nombre_usuario(String vmae_nombre_usuario) {
		this.vmae_nombre_usuario = vmae_nombre_usuario;
	}
	public String getVmae_ures() {
		return vmae_ures;
	}
	public void setVmae_ures(String vmae_ures) {
		this.vmae_ures = vmae_ures;
	}
	public String getVmae_program() {
		return vmae_program;
	}
	public void setVmae_program(String vmae_program) {
		this.vmae_program = vmae_program;
	}
	public String getVmae_tipouser() {
		return vmae_tipouser;
	}
	public void setVmae_tipouser(String vmae_tipouser) {
		this.vmae_tipouser = vmae_tipouser;
	}
	public String getVmae_descripcion() {
		return vmae_descripcion;
	}
	public void setVmae_descripcion(String vmae_descripcion) {
		this.vmae_descripcion = vmae_descripcion;
	}
	public String getVmae_referencia() {
		return vmae_referencia;
	}
	public void setVmae_referencia(String vmae_referencia) {
		this.vmae_referencia = vmae_referencia;
	}
	public String getVmae_estatus() {
		return vmae_estatus;
	}
	public void setVmae_estatus(String vmae_estatus) {
		this.vmae_estatus = vmae_estatus;
	}
	public String getVmae_est_descrip() {
		return vmae_est_descrip;
	}
	public void setVmae_est_descrip(String vmae_est_descrip) {
		this.vmae_est_descrip = vmae_est_descrip;
	}
	public String getVmae_importe() {
		return vmae_importe;
	}
	public void setVmae_importe(String vmae_importe) {
		this.vmae_importe = vmae_importe;
	}
	
	

}
