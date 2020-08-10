package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Tdpagosonline;

public interface ITdpagosonlineService {

	public List<Tdpagosonline> findAll();
	
	public void save(Tdpagosonline tdpagosonline);
	
}
