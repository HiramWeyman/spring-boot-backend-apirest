package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvpagossiiaDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvpagossiia;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TvpagossiiaRestController {
	
	@Autowired
	private ITvpagossiiaDao tvpagossiiaDao;
	
	@GetMapping("/tvpagossiia")
	public List<Tvpagossiia> index() {
		return tvpagossiiaDao.Pagos();
	}
	
	@GetMapping("/tvpagossiia/{vdet_foliopago}")
	public List<Tvpagossiia> show(@PathVariable String vdet_foliopago) {
		return tvpagossiiaDao.Pago(vdet_foliopago);
	}

}
