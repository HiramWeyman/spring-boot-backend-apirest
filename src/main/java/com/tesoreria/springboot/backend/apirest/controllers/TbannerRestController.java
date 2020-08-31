package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITbannerDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tbanner;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TbannerRestController {

	@Autowired
	private ITbannerDao tbannerDao;
	
	@GetMapping("/tbanner")
	public List<Tbanner> index() {
		return tbannerDao.FindBanners();
	}
	
	@GetMapping("/tbanner/{tban_id}")
	public List<Tbanner> show(@PathVariable Long tban_id) {
		return tbannerDao.FindBanner(tban_id);
	}
}
