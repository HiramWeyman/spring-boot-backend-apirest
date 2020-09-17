package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITequipoDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tequipo;
import com.tesoreria.springboot.backend.apirest.models.services.ITequipoService;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TequipoRestController {

	@Autowired
	private ITequipoService tequipoService;
	
	@Autowired
	private ITequipoDao tequipoDao;

	@GetMapping("/tequipo")
	public List<Tequipo> index() {
		return tequipoDao.FindEquipos();
	}
	
	@GetMapping("/tequipo/{teq_id}")
	public List<Tequipo> show(@PathVariable Long teq_id) {
		return tequipoDao.FindEquipo(teq_id);
	}
	
	@PostMapping("/tequipo")
	public Tequipo create(@RequestBody Tequipo tequipo) {
		this.tequipoService.save(tequipo);
		return tequipo;
	}
	
	@PutMapping("/tequipo/{teq_id}")
	public Tequipo update(@RequestBody Tequipo tequipo, @PathVariable Long teq_id) {
		Tequipo currentTequipo = this.tequipoDao.FindEquipoUpdate(teq_id);
		currentTequipo.setTeq_nombre(tequipo.getTeq_nombre());
		currentTequipo.setTeq_puesto(tequipo.getTeq_puesto());
		currentTequipo.setTeq_estatus(tequipo.getTeq_estatus());
		currentTequipo.setTeq_ruta_img(tequipo.getTeq_ruta_img());
		this.tequipoService.save(currentTequipo);
		return currentTequipo;
	}
	
	@DeleteMapping("/tequipo/{teq_id}")
	public Tequipo delete(@PathVariable Long teq_id) {
		Tequipo currentTequipo = this.tequipoDao.FindEquipoUpdate(teq_id);
		currentTequipo.setTeq_estatus("C");
		this.tequipoService.save(currentTequipo);
		return currentTequipo;
	}
}
