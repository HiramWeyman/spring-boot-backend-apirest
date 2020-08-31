package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trespbanco")
public class Trespbanco {

	@Id
	private Long tres_folio;
	
	private String tres_result;
	private String tres_receipt;
	private String tres_authorizationcode;
	private String tres_amount;
	
	public Long getTres_folio() {
		return tres_folio;
	}
	public void setTres_folio(Long tres_folio) {
		this.tres_folio = tres_folio;
	}
	public String getTres_result() {
		return tres_result;
	}
	public void setTres_result(String tres_result) {
		this.tres_result = tres_result;
	}
	public String getTres_receipt() {
		return tres_receipt;
	}
	public void setTres_receipt(String tres_receipt) {
		this.tres_receipt = tres_receipt;
	}
	public String getTres_authorizationcode() {
		return tres_authorizationcode;
	}
	public void setTres_authorizationcode(String tres_authorizationcode) {
		this.tres_authorizationcode = tres_authorizationcode;
	}
	public String getTres_amount() {
		return tres_amount;
	}
	public void setTres_amount(String tres_amount) {
		this.tres_amount = tres_amount;
	}	
	
}
