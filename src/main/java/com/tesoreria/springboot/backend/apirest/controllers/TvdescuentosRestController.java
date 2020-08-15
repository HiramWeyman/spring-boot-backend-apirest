package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvdescuentosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvdescuentos;


//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TvdescuentosRestController {
	
	@Autowired
	private ITvdescuentosDao tvdescuentosDao;

	@GetMapping("/tvdescuentos")
	public List<Tvdescuentos> index() {
		return tvdescuentosDao.FindAll();
	}
	
	@GetMapping("/tvdescuentos/{vdes_ures}/{vdes_matricula}")
	//@GetMapping(path = "/tvdescuentos/{vdes_ures}/{vdes_matricula}")
	public List<Tvdescuentos> show(@PathVariable String vdes_ures,@PathVariable String vdes_matricula) {
		return tvdescuentosDao.findDistinctByNameNotIn(vdes_ures, vdes_matricula);
	}
	
}
