package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ISideBarDao;
import com.tesoreria.springboot.backend.apirest.models.entity.SideBar;

@Service
public class SideBarServiceImpl implements ISidebarService{

	@Autowired
	private ISideBarDao sidebarDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<SideBar> findAll() {
		return (List<SideBar>) sidebarDao.findAll();
	}

	@Override
	public List<SideBar> findRol(String rolu_tipo_user) {
		return (List<SideBar>) sidebarDao.FindRol(rolu_tipo_user);
	}

}
