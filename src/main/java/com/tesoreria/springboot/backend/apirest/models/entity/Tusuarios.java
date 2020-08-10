package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tusuarios")
public class Tusuarios {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="TSQUSERID", allocationSize = 1 )
	private Long usua_id;
	
	public Long getUsua_id() {
		return usua_id;
	}
	public void setUsua_id(Long usua_id) {
		this.usua_id = usua_id;
	}
	private String usua_usuario;
	private String usua_tipo_usuario;
	private String usua_nombre;
	private String usua_email;
	private String usua_tel;
	private String usua_paswd;
	private String usua_ures;
	private String usua_nivel;
	private String usua_prog;
	private String usua_persona;
	
	
	public String getUsua_prog() {
		return usua_prog;
	}
	public void setUsua_prog(String usua_prog) {
		this.usua_prog = usua_prog;
	}
	public String getUsua_persona() {
		return usua_persona;
	}
	public void setUsua_persona(String usua_persona) {
		this.usua_persona = usua_persona;
	}
	public String getUsua_usuario() {
		return usua_usuario;
	}
	public void setUsua_usuario(String usua_usuario) {
		this.usua_usuario = usua_usuario;
	}
	public String getUsua_tipo_usuario() {
		return usua_tipo_usuario;
	}
	public void setUsua_tipo_usuario(String usua_tipo_usuario) {
		this.usua_tipo_usuario = usua_tipo_usuario;
	}
	public String getUsua_nombre() {
		return usua_nombre;
	}
	public void setUsua_nombre(String usua_nombre) {
		this.usua_nombre = usua_nombre;
	}
	public String getUsua_email() {
		return usua_email;
	}
	public void setUsua_email(String usua_email) {
		this.usua_email = usua_email;
	}
	public String getUsua_tel() {
		return usua_tel;
	}
	public void setUsua_tel(String usua_tel) {
		this.usua_tel = usua_tel;
	}
	public String getUsua_paswd() {
		return usua_paswd;
	}
	public void setUsua_paswd(String usua_paswd) {
		this.usua_paswd = usua_paswd;
	}
	public String getUsua_ures() {
		return usua_ures;
	}
	public void setUsua_ures(String usua_ures) {
		this.usua_ures = usua_ures;
	}
	public String getUsua_nivel() {
		return usua_nivel;
	}
	public void setUsua_nivel(String usua_nivel) {
		this.usua_nivel = usua_nivel;
	}

}
