package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvusuariosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvusuarios;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TtvdescuentosRestController {

	@Autowired
	private ITvusuariosDao tvusuariosDao;

	@GetMapping("/tvusuarios")
	public List<Tvusuarios> index() {
		return tvusuariosDao.FindTvusuarios();
	}
	
}
