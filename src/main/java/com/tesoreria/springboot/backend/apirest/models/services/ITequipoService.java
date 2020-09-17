package com.tesoreria.springboot.backend.apirest.models.services;

import com.tesoreria.springboot.backend.apirest.models.entity.Tequipo;

public interface ITequipoService {
	
	public void save(Tequipo tequipo);
	
	public void delete(Tequipo tequipo);

}
