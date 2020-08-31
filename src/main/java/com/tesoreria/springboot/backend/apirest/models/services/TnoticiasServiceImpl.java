package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITnoticiasDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tnoticias;

@Service
public class TnoticiasServiceImpl implements ITnoticiasService{

	@Autowired
	private ITnoticiasDao tnoticiasDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tnoticias> findAll() {
		return (List<Tnoticias>) tnoticiasDao.FindNoticias();
	}
	
	@Override
	public Tnoticias findById(Long tnot_id) {
		return (Tnoticias) tnoticiasDao.FindNoticia(tnot_id);

	}
	
	@Override
	@Transactional
	public void save(Tnoticias tnoticias) {
		tnoticiasDao.save(tnoticias);
	}

	@Override
	public void delete(Tnoticias tnoticias) {
		tnoticiasDao.delete(tnoticias);
	}

	

}
