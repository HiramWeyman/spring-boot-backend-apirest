package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Tusuarios;

public interface ITusuariosService {
	
	public List<Tusuarios> findAll();
	
	public List<Tusuarios> findUsuario(String usua_usuario, String usua_paswd);
	
	public List<Tusuarios> findUsuarioName(String usua_usuario);
	
	public void save(Tusuarios usuarios);

}
