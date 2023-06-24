package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvusuariosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvusuarios;


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
	
	@GetMapping("/tvusuarios/{userid}")
	public List<Tvusuarios> show(@PathVariable Long userid) {
		return tvusuariosDao.FindTvusuario(userid);
	}
	
}
