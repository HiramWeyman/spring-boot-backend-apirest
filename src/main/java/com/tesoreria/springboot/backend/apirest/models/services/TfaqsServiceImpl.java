package com.tesoreria.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITfaqsDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tfaqs;

@Service
public class TfaqsServiceImpl implements ITfaqsService{

	@Autowired
	private ITfaqsDao tfaqsDao;
	
	@Override
	@Transactional
	public void save(Tfaqs Tfaqs) {
		tfaqsDao.save(Tfaqs);
	}

}
