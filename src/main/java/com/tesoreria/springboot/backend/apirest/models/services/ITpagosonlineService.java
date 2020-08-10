package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Tpagosonline;

public interface ITpagosonlineService {

	public List<Tpagosonline> findAll();
	
	public List<Tpagosonline> findPago(String pago_userid);
	
	public Tpagosonline findById(Long id);
	
	public void save(Tpagosonline tpagosonline);

}
