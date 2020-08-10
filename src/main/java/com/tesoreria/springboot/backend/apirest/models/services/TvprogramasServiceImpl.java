package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoreria.springboot.backend.apirest.models.dao.ITvprogramasDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tvprogramas;

@Service
public class TvprogramasServiceImpl implements ITvprogramasService{

	@Autowired
	private ITvprogramasDao tvprogramasDao;
	
	@Override
	public List<Tvprogramas> findAll() {
		return (List<Tvprogramas>) tvprogramasDao.FindTvprogramas();
	}


	@Override
	public List<Tvprogramas> findPrograma(Long id) {
		return tvprogramasDao.FindTvprograma(id);
	}


}
