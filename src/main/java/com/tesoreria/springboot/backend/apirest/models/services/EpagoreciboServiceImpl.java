package com.tesoreria.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.IEpagoreciboDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Epagorecibo;

@Service
public class EpagoreciboServiceImpl implements IEpagoreciboService{

	@Autowired
	private IEpagoreciboDao epagoreciboDao;
	
	@Override
	@Transactional
	public void save(Epagorecibo epagorecibo) {
		epagoreciboDao.save(epagorecibo);
	}

}
