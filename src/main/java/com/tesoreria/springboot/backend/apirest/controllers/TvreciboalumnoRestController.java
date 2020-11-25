package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvreciboalumnoDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvreciboalumno;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TvreciboalumnoRestController {
	
	@Autowired
	private ITvreciboalumnoDao tvreciboalumnoDao;	
	
	@GetMapping("/reciboalumno")
	public List<Tvreciboalumno> index() {
		return tvreciboalumnoDao.Recibos();
	}
	
	@GetMapping("/reciboalumno/{folio}")
	public List<Tvreciboalumno> show(@PathVariable int folio) {
		return tvreciboalumnoDao.Recibo(folio);
	}

}
