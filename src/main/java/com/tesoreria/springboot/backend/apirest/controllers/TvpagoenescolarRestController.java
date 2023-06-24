package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvpagoenescolarDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvpagoenescolar;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TvpagoenescolarRestController {
	

	@Autowired
	private ITvpagoenescolarDao tvpagoenescolarDao;
	
	@GetMapping("/tvpagoenescolar")
	public List<Tvpagoenescolar> index() {
		return tvpagoenescolarDao.FindTvpagoenescolar();
	}

}
