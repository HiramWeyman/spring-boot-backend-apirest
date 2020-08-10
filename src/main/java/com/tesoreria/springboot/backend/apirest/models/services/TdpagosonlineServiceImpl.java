package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITdpagosonlineDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tdpagosonline;

@Service
public class TdpagosonlineServiceImpl implements ITdpagosonlineService{
	
	@Autowired
	private ITdpagosonlineDao tdpagosonlineDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tdpagosonline> findAll() {
		return (List<Tdpagosonline>) tdpagosonlineDao.FindAll();
	}

	@Override
	@Transactional
	public void save(Tdpagosonline tdpagosonline) {
		tdpagosonlineDao.save(tdpagosonline);
		
	}

}
