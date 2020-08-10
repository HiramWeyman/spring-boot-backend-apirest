package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITpagosonlineDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tpagosonline;
import com.tesoreria.springboot.backend.apirest.models.services.ITpagosonlineService;


@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@RestController
@RequestMapping("/api")
public class TpagosonlineRestController {
	
	
	@Autowired
	private ITpagosonlineService pagosonlineService;
	
	@Autowired
	private ITpagosonlineDao pagosonlineDao;
	
	@GetMapping("/tpagosonline")
	public List<Tpagosonline> index() {
		return pagosonlineService.findAll();
	}
	
	@GetMapping("/tpagosonline/{pago_usuaid}")
	public List<Tpagosonline> show(@PathVariable String pago_usuaid) {
		return pagosonlineDao.findPago(pago_usuaid);
	}
	
	@PostMapping("/tpagosonline")
	//@ResponseStatus(HttpStatus.CREATED)
	public Tpagosonline create(@RequestBody Tpagosonline tpagosonline) {
		this.pagosonlineService.save(tpagosonline);
		return tpagosonline;
	}
	
	@PutMapping("/tpagosonline/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	//public Tpagosonline update(@RequestBody Tpagosonline tpagosonline, @PathVariable Long id) {
	public Tpagosonline update(@PathVariable Long id) {
		System.out.println(id);
		Tpagosonline currentTpagosonline = this.pagosonlineService.findById(id);
		currentTpagosonline.setPago_estatus("A");
		this.pagosonlineService.save(currentTpagosonline);
		return currentTpagosonline;
	}
	
}
