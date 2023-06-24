package com.tesoreria.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITsqpagosonlineDao;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TsqpagosonlineRestController {
	
	@Autowired
	private ITsqpagosonlineDao tsqpagosonlineDao;	

	@GetMapping("/tsqpagosonline")
	public Long index() {
		return tsqpagosonlineDao.getTsqpagosonline();
	}

	
}
