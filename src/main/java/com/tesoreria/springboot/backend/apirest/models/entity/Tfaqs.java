package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tfaqs")
public class Tfaqs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="TSQFAQS", allocationSize = 1 )
	private Long faqs_id;
	
	private String faqs_pregunta;
	private String faqs_respuesta;
	private String faqs_estatus;


	public Long getFaqs_id() {
		return faqs_id;
	}

	public void setFaqs_id(Long faqs_id) {
		this.faqs_id = faqs_id;
	}

	public String getFaqs_pregunta() {
		return faqs_pregunta;
	}

	public void setFaqs_pregunta(String faqs_pregunta) {
		this.faqs_pregunta = faqs_pregunta;
	}

	public String getFaqs_respuesta() {
		return faqs_respuesta;
	}

	public void setFaqs_respuesta(String faqs_respuesta) {
		this.faqs_respuesta = faqs_respuesta;
	}

	public String getFaqs_estatus() {
		return faqs_estatus;
	}

	public void setFaqs_estatus(String faqs_estatus) {
		this.faqs_estatus = faqs_estatus;
	}	

}
