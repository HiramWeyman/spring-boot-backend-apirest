package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.SideBar;

public interface ISidebarService {
	
	public List<SideBar> findAll();
	
	public List<SideBar> findRol(String rolu_tipo_user);

}
