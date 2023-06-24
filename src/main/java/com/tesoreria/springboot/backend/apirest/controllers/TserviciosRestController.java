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

import com.tesoreria.springboot.backend.apirest.models.dao.ITserviciosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tservicios;
import com.tesoreria.springboot.backend.apirest.models.services.ITserviciosService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TserviciosRestController {

	@Autowired
	private ITserviciosService tserviciosService;
	
	@Autowired
	private ITserviciosDao tserviciosDao;
	
	@GetMapping("/tservicios")
	public List<Tservicios> index() {
		return tserviciosDao.FindServicios();
	}
	
	@GetMapping("/tservicios/{tser_id}")
	public List<Tservicios> show(@PathVariable Long tser_id) {
		return tserviciosDao.FindServicio(tser_id);
	}
	
	@PostMapping("/tservicios")
	public Tservicios create(@RequestBody Tservicios tservicios) {
		this.tserviciosService.save(tservicios);
		return tservicios;
	}
	
	@PutMapping("/tservicios/{tser_id}")
	public Tservicios update(@RequestBody Tservicios tservicios, @PathVariable Long tser_id) {
		Tservicios currentTservicios = this.tserviciosDao.FindServicioUpdate(tser_id);
		currentTservicios.setTser_servicio(tservicios.getTser_servicio());
		currentTservicios.setTser_descripcion(tservicios.getTser_descripcion());
		currentTservicios.setTeq_ruta_img(tservicios.getTeq_ruta_img());
		currentTservicios.setTeq_estatus(tservicios.getTeq_estatus());
		this.tserviciosService.save(currentTservicios);
		return currentTservicios;
	}
	
	@DeleteMapping("/tservicios/{tser_id}")
	public Tservicios delete(@PathVariable Long tser_id) {
		Tservicios currentTservicios = this.tserviciosDao.FindServicioUpdate(tser_id);
		currentTservicios.setTeq_estatus("C");
		this.tserviciosService.save(currentTservicios);
		return currentTservicios;
	}
}
