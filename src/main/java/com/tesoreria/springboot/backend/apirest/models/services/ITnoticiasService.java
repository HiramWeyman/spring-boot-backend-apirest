package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Tnoticias;

public interface ITnoticiasService {

	public List<Tnoticias> findAll();
	
	public Tnoticias findById(Long id);
	
	public void save(Tnoticias tnoticias);
	
	public void delete(Tnoticias tnoticias);
	
}
