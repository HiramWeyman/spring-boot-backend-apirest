package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvuresDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvures;

@Service
public class TvuresServiceImpl implements ITvuresService{

	@Autowired
	private ITvuresDao tvuresDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tvures> findAll() {
		return (List<Tvures>) tvuresDao.FindTvures();
	}

}
