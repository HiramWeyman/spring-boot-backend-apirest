package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.IEpagoreciboDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Epagorecibo;
import com.tesoreria.springboot.backend.apirest.models.services.IEpagoreciboService;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EpagoreciboRestController {

	@Autowired
	private IEpagoreciboService epagoreciboService;
	
	@Autowired
	private IEpagoreciboDao epagoreciboDao;
	
	@GetMapping("/epagorecibo")
	public List<Epagorecibo> index() {
		return epagoreciboDao.Recibos();
	}
	
	//@PutMapping("/epagorecibo/{folio}/{folioDet}/{user}/{comentario}")
	//@PutMapping("/epagorecibo/{FolioDet}/{folio}")
	//public Epagorecibo update(@RequestBody Tnoticias tnoticias, @PathVariable Long tnot_id) {
	//public Epagorecibo update(@PathVariable Long folio,@PathVariable Long folioDet, @PathVariable String user, @PathVariable String comentario) {
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/epagorecibo/{pago_folregid}/{pago_folpago}",method = RequestMethod.PUT)
	public Epagorecibo update(@RequestBody Epagorecibo epagorecibo, @PathVariable Long pago_folregid, @PathVariable int pago_folpago) {
		Epagorecibo currentEpagorecibo = this.epagoreciboDao.ReciboDet(pago_folregid, pago_folpago);
		currentEpagorecibo.setPago_comentarios(epagorecibo.getPago_comentarios());
		currentEpagorecibo.setPago_user_recepcion(epagorecibo.getPago_user_recepcion());
		currentEpagorecibo.setPago_frecep(new Date());
		
		this.epagoreciboService.save(currentEpagorecibo);
		return epagorecibo;
	}
	
	
}
