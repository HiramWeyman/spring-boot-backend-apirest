package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Ttipouser;

public interface ITtipouserService {
	
	public List<Ttipouser> findAll();

}
