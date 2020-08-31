package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITrespbancoDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Trespbanco;

@Service
public class TrespbancoServiceImpl implements ITrespbancoService{
	
	@Autowired
	private ITrespbancoDao trespbancoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Trespbanco> findAll() {
		return (List<Trespbanco>) trespbancoDao.FindRespbanco();
	}

	@Override
	public void save(Trespbanco respbanco) {
		trespbancoDao.save(respbanco);
	}

	

}
