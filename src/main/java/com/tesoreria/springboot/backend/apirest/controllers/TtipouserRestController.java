package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITtipouserDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Ttipouser;
import com.tesoreria.springboot.backend.apirest.models.services.ITtipouserService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TtipouserRestController {
	
	@Autowired
	private ITtipouserService ttipouserService;
	
	@Autowired
	private ITtipouserDao ttipouserDao;

	@GetMapping("/ttipouser")
	public List<Ttipouser> index() {
		return ttipouserService.findAll();
	}
	
	@GetMapping("/ttipouser/{pago_userid}")
	public List<Ttipouser> index(@PathVariable String pago_userid) {
		return ttipouserDao.findTipo(pago_userid);
	}

}
