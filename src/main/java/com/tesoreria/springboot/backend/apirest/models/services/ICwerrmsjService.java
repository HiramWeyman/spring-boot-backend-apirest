package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Cwerrmsj;

public interface ICwerrmsjService {
	
	public List<Cwerrmsj> findErrorMensajes();
	
	public List<Cwerrmsj> findErrorMensaje(String cerr_refer);

}
