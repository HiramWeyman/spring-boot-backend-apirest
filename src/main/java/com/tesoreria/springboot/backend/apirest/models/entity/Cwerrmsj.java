package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CWERRMSJ" , schema = "CONTROLWEB")
public class Cwerrmsj {

	@Id
	private String cerr_refer;
	
	private String cerr_mensaje;

	public String getCerr_refer() {
		return cerr_refer;
	}

	public void setCerr_refer(String cerr_refer) {
		this.cerr_refer = cerr_refer;
	}

	public String getCerr_mensaje() {
		return cerr_mensaje;
	}

	public void setCerr_mensaje(String cerr_mensaje) {
		this.cerr_mensaje = cerr_mensaje;
	}
	
}
