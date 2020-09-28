package com.tesoreria.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITserviciosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tservicios;

@Service
public class TserviciosServiceImpl implements ITserviciosService{

	@Autowired
	private ITserviciosDao tserviciosDao;
	
	@Override
	@Transactional
	public void save(Tservicios tservicios) {
		tserviciosDao.save(tservicios);
	}

	@Override
	public void delete(Tservicios tservicios) {
		tserviciosDao.delete(tservicios);
	}

}
