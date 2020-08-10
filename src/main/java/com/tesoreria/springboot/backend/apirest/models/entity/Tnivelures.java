package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tnivelures")
public class Tnivelures {
	
	@Id
	private Long nive_nivel;
	
	private String nive_descrip;

	public Long getNive_nivel() {
		return nive_nivel;
	}

	public void setNive_nivel(Long nive_nivel) {
		this.nive_nivel = nive_nivel;
	}

	public String getNive_descrip() {
		return nive_descrip;
	}

	public void setNive_descrip(String nive_descrip) {
		this.nive_descrip = nive_descrip;
	}

}
