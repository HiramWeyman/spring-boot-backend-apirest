package com.tesoreria.springboot.backend.apirest.models.services;

import com.tesoreria.springboot.backend.apirest.models.entity.Tservicios;

public interface ITserviciosService {

	public void save(Tservicios tservicios);
	
	public void delete(Tservicios tservicios);
	
}
