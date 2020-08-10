package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvprogramas;

public interface ITvprogramasService {
	
	public List<Tvprogramas> findAll();
	
	public List<Tvprogramas> findPrograma(Long id);

}
