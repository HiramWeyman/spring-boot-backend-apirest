package com.tesoreria.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITequipoDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tequipo;

@Service
public class TequipoServiceImpl implements ITequipoService{

	@Autowired
	private ITequipoDao tequipoDao;
	
	@Override
	@Transactional
	public void save(Tequipo tequipo) {
		tequipoDao.save(tequipo);
	}

	@Override
	public void delete(Tequipo tequipo) {
		tequipoDao.delete(tequipo);
	}

}
