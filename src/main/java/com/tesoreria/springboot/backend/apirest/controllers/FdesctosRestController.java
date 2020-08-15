package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.IFdesctosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Fdesctos;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FdesctosRestController {
	
	@Autowired
	private IFdesctosDao fdesctosDao;	
	
	@GetMapping("/fdesctos")
	public List<Fdesctos> index() {
		return fdesctosDao.FindAll();
	}
	
	@GetMapping("/fdesctos/{desc_ures}/{desc_matricula}")
	public List<Fdesctos> show(@PathVariable String desc_ures,@PathVariable String desc_matricula) {
		return fdesctosDao.FindDescuento(desc_ures, desc_matricula);
	}

}
