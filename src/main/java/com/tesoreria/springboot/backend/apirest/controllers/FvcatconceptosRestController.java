package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.IFvcatconceptosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Fvcatconceptos;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FvcatconceptosRestController {
	
	@Autowired
	private IFvcatconceptosDao fvcatconceptosDao;	
	
	@GetMapping("/catalogoPagoTipoUser/{tipo_user}")
	public List<Fvcatconceptos> index(@PathVariable String tipo_user) {
		
		if (tipo_user.equals("10")){return fvcatconceptosDao.CatalogoPagos10();}
		if (tipo_user.equals("20")){return fvcatconceptosDao.CatalogoPagos20();}
		if (tipo_user.equals("30")){return fvcatconceptosDao.CatalogoPagos30();}
		if (tipo_user.equals("40")){return fvcatconceptosDao.CatalogoPagos40();}
		if (tipo_user.equals("50")){return fvcatconceptosDao.CatalogoPagos50();}
		if (tipo_user.equals("80")){return fvcatconceptosDao.CatalogoPagos80();}

		return null;
	}

}
