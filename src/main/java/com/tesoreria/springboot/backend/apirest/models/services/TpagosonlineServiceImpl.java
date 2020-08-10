package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITpagosonlineDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tpagosonline;

@Service
public class TpagosonlineServiceImpl implements ITpagosonlineService{

	@Autowired
	private ITpagosonlineDao tpagosonlineDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tpagosonline> findAll() {
		return (List<Tpagosonline>) tpagosonlineDao.FindAll();
	}

	@Override
	@Transactional
	public void save(Tpagosonline tpagosonline) {
		tpagosonlineDao.save(tpagosonline);
	}

	@Override
	public List<Tpagosonline> findPago(String pago_userid) {
		return (List<Tpagosonline>) tpagosonlineDao.findPago(pago_userid);
	}

	@Override	
	@Transactional(readOnly = true)
	public Tpagosonline findById(Long id) {
		//return tpagosonlineDao.findById(id).orElse(null);
		return tpagosonlineDao.findById(id).orElse(null);
	}

}
