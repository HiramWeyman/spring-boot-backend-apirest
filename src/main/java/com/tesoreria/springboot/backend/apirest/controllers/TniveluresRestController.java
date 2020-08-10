package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.entity.Tnivelures;
import com.tesoreria.springboot.backend.apirest.models.services.ITniveluresService;

@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@RestController
@RequestMapping("/api")
public class TniveluresRestController {
	
	@Autowired
	private ITniveluresService tniveluresService;

	@GetMapping("/tnivelures")
	public List<Tnivelures> index() {
		return tniveluresService.findAll();
	}

}
