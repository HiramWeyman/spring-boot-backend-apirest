package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tpagosonline")
public class Tsqpagosonline {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="tsqpagosonline", allocationSize = 1 )
	private Long pago_folpago;

	public Long getPago_folpago() {
		return pago_folpago;
	}

	public void setPago_folpago(Long pago_folpago) {
		this.pago_folpago = pago_folpago;
	}

}
