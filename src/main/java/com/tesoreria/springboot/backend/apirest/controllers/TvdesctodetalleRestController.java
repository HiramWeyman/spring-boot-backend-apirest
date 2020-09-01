package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvdesctodetalleDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvdesctodetalle;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TvdesctodetalleRestController {

	@Autowired
	private ITvdesctodetalleDao tvdesctodetalleDao;
	
	/*
	@GetMapping("/tvdescuentosdet/{vdes_ures}/{vdes_matricula}")
	//@GetMapping(path = "/tvdescuentos/{vdes_ures}/{vdes_matricula}")
	public List<Tvdesctodetalle> showdet(@PathVariable String vdes_ures,@PathVariable String vdes_matricula) {
		return tvdesctodetalleDao.FindDescuentodet(vdes_ures, vdes_matricula);
	}
	*/
	
	@GetMapping("/tvdescuentosdet/{vdes_foldescto}")
	//@GetMapping(path = "/tvdescuentos/{vdes_ures}/{vdes_matricula}")
	public List<Tvdesctodetalle> showdet(@PathVariable String vdes_foldescto) {
		return tvdesctodetalleDao.FindDescuentodet(vdes_foldescto);
	}
}
