package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Tnivelures;

public interface ITniveluresService {
	
	public List<Tnivelures> findAll();

}
