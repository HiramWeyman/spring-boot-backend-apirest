package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Trespbanco;

public interface ITrespbancoService {
	
	public List<Trespbanco> findAll();

	public void save(Trespbanco respbanco);
	
}
