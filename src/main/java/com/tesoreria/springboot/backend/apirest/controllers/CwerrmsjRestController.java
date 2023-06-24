package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.entity.Cwerrmsj;
import com.tesoreria.springboot.backend.apirest.models.services.ICwerrmsjService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CwerrmsjRestController {
	
	@Autowired
	private ICwerrmsjService cwerrmsjService;	
	
	@GetMapping("/cwerrmsj")
	public List<Cwerrmsj> index() {
		return cwerrmsjService.findErrorMensajes();
	}
	
	//@PostMapping("/tusuarios/{usua_usuario}/{usua_paswd}")
	@GetMapping("/cwerrmsj/{cerr_refer}")
	public List<Cwerrmsj> show(@PathVariable String cerr_refer)  {
		return cwerrmsjService.findErrorMensaje(cerr_refer);
	}

}
