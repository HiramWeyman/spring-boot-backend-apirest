package com.tesoreria.springboot.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tvprogramas")
public class Tvprogramas {

	@Id
	private Long prog_prog;
	
	private String prog_progdesc;
	
	private String prog_ures;

	public Long getProg_prog() {
		return prog_prog;
	}

	public void setProg_prog(Long prog_prog) {
		this.prog_prog = prog_prog;
	}

	public String getProg_progdesc() {
		return prog_progdesc;
	}

	public void setProg_progdesc(String prog_progdesc) {
		this.prog_progdesc = prog_progdesc;
	}

	public String getProg_ures() {
		return prog_ures;
	}

	public void setProg_ures(String prog_ures) {
		this.prog_ures = prog_ures;
	}
	
}
