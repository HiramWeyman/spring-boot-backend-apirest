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

import com.tesoreria.springboot.backend.apirest.models.dao.ITfaqsDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tfaqs;
import com.tesoreria.springboot.backend.apirest.models.entity.Tnoticias;
import com.tesoreria.springboot.backend.apirest.models.services.ITfaqsService;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TfaqsRestController {

	@Autowired
	private ITfaqsService tfaqsService;
	
	@Autowired
	private ITfaqsDao tfaqsDao;
	
	@GetMapping("/tfaqs")
	public List<Tfaqs> index() {
		return tfaqsDao.FindFaqs();
	}
	
	@GetMapping("/tfaqs/{faqs_id}")
	public List<Tfaqs> show(@PathVariable Long faqs_id) {
		return tfaqsDao.FindFaq(faqs_id);
	}
	
	@PostMapping("/tfaqs")
	public Tfaqs create(@RequestBody Tfaqs tfaqs) {
		this.tfaqsService.save(tfaqs);
		return tfaqs;
	}
	
	@PutMapping("/tfaqs/{faqs_id}")
	public Tfaqs update(@RequestBody Tfaqs ffaqs, @PathVariable Long faqs_id) {
		Tfaqs currentTfaqs = this.tfaqsDao.FindFaqUpdate(faqs_id);
		currentTfaqs.setFaqs_pregunta(ffaqs.getFaqs_pregunta());
		currentTfaqs.setFaqs_respuesta(ffaqs.getFaqs_respuesta());
		currentTfaqs.setFaqs_estatus(ffaqs.getFaqs_estatus());
		this.tfaqsService.save(currentTfaqs);
		return currentTfaqs;
	}
	
	@DeleteMapping("/tfaqs/{faqs_id}")
	public Tfaqs delete(@PathVariable Long faqs_id) {
		Tfaqs currentTfaqs = this.tfaqsDao.FindFaqUpdate(faqs_id);
		currentTfaqs.setFaqs_estatus("C");
		this.tfaqsService.save(currentTfaqs);
		return currentTfaqs;
	}
	
}
