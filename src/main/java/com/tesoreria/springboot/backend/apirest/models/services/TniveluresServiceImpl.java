package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITniveluresDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tnivelures;

@Service
public class TniveluresServiceImpl implements ITniveluresService{
	
	@Autowired
	private ITniveluresDao tniveluresDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tnivelures> findAll() {
		return (List<Tnivelures>) tniveluresDao.FindTnivelures();
	}

}
