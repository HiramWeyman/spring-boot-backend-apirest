package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvprogramas;
import com.tesoreria.springboot.backend.apirest.models.services.ITvprogramasService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TvprogramasRestController {
	
	@Autowired
	private ITvprogramasService tvprogramasService;
	
	@GetMapping("/tvprogramas")
	public List<Tvprogramas> index() {
		return tvprogramasService.findAll();
	}
	
	@GetMapping("/tvprogramas/{id}")
	public List<Tvprogramas> show(@PathVariable Long id) {
		return this.tvprogramasService.findPrograma(id);
	}

}
