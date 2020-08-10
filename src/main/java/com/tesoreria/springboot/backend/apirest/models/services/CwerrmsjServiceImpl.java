package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ICwerrmsjDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Cwerrmsj;

@Service
public class CwerrmsjServiceImpl implements ICwerrmsjService{
	
	@Autowired
	private ICwerrmsjDao cwerrmsjDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cwerrmsj> findErrorMensajes() {
		return (List<Cwerrmsj>) cwerrmsjDao.FindErrorMensajes();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cwerrmsj> findErrorMensaje(String cerr_refer) {
		return (List<Cwerrmsj>) cwerrmsjDao.FindErrorMensaje(cerr_refer);
	}

}
