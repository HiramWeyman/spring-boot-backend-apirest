package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fcating")
public class Fcating {

	@Id
	private String cati_ingid;
	
	private String cati_punit;
	
	private String cati_descrip;

	public String getCati_ingid() {
		return cati_ingid;
	}

	public void setCati_ingid(String cati_ingid) {
		this.cati_ingid = cati_ingid;
	}

	public String getCati_punit() {
		return cati_punit;
	}

	public void setCati_punit(String cati_punit) {
		this.cati_punit = cati_punit;
	}

	public String getCati_descrip() {
		return cati_descrip;
	}

	public void setCati_descrip(String cati_descrip) {
		this.cati_descrip = cati_descrip;
	}

	
	
}
