package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITtipouserDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Ttipouser;

@Service
public class TtipouserServiceImpl implements ITtipouserService {
	
	@Autowired
	private ITtipouserDao ttipouserDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Ttipouser> findAll() {
		return (List<Ttipouser>) ttipouserDao.FindTtipousers();
	}

}
