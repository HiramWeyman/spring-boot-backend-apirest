package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvures;

public interface ITvuresService {
	
	public List<Tvures> findAll();

}
