package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tvures")
public class Tvures {

	@Id
	private String ures_ures;
	
	private String ures_uresdesc;

	public String getUres_ures() {
		return ures_ures;
	}

	public void setUres_ures(String ures_ures) {
		this.ures_ures = ures_ures;
	}

	public String getUres_uresdesc() {
		return ures_uresdesc;
	}

	public void setUres_uresdesc(String ures_uresdesc) {
		this.ures_uresdesc = ures_uresdesc;
	}
	
}
