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

import com.tesoreria.springboot.backend.apirest.models.dao.ITnoticiasDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tnoticias;
import com.tesoreria.springboot.backend.apirest.models.services.ITnoticiasService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TnoticiasRestController {

	@Autowired
	private ITnoticiasService tnoticiasService;
	
	@Autowired
	private ITnoticiasDao tnoticiasDao;
	
	@GetMapping("/tnoticias")
	public List<Tnoticias> index() {
		return tnoticiasDao.FindNoticias();
	}
	
	@GetMapping("/tnoticias/{tnot_id}")
	public List<Tnoticias> show(@PathVariable Long tnot_id) {
		return tnoticiasDao.FindNoticia(tnot_id);
	}
	
	@PostMapping("/tnoticias")
	public Tnoticias create(@RequestBody Tnoticias tnoticias) {
		this.tnoticiasService.save(tnoticias);
		return tnoticias;
	}
	
	@PutMapping("/tnoticias/{tnot_id}")
	public Tnoticias update(@RequestBody Tnoticias tnoticias, @PathVariable Long tnot_id) {
		Tnoticias currentTnoticias = this.tnoticiasDao.FindNoticiaUpdate(tnot_id);
		currentTnoticias.setTnot_titulo(tnoticias.getTnot_titulo());
		currentTnoticias.setTnot_nota(tnoticias.getTnot_nota());
		currentTnoticias.setTnot_ruta_img(tnoticias.getTnot_ruta_img());
		currentTnoticias.setTnot_fecha(tnoticias.getTnot_fecha());
		currentTnoticias.setTnot_autor(tnoticias.getTnot_autor());
		this.tnoticiasService.save(currentTnoticias);
		return currentTnoticias;
	}
	
	@DeleteMapping("/tnoticias/{tnot_id}")
	public Tnoticias delete(@PathVariable Long tnot_id) {
		Tnoticias currentTnoticias = this.tnoticiasDao.FindNoticiaUpdate(tnot_id);
		currentTnoticias.setTnot_estatus("C");
		this.tnoticiasService.save(currentTnoticias);
		return currentTnoticias;
	}
	
	/*
	@DeleteMapping("/tnoticias/{tnot_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long tnot_id) {
		Tnoticias currentTnoticias = this.tnoticiasService.findById(tnot_id);
		this.tnoticiasService.delete(currentTnoticias);
	}
	*/
}
