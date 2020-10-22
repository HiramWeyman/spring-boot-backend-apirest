package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvmaestropagosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvmaestropagos;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TvmaestropagosRestController {
	
	@Autowired
	private ITvmaestropagosDao tvmaestropagosDao;
	
	@GetMapping("/tvmaestropagos")
	public List<Tvmaestropagos> index() {
		return tvmaestropagosDao.Pagos();
	}
	
	@GetMapping("/tvmaestropagos/{vmae_foliopago}")
	public List<Tvmaestropagos> show(@PathVariable String vmae_foliopago) {
		return tvmaestropagosDao.Pago(vmae_foliopago);
	}

}
