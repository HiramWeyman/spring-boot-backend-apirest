package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.ITusuariosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tusuarios;

@Service
public class TusuariosServiceImpl implements ITusuariosService{
	
	@Autowired
	private ITusuariosDao tusuariosDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tusuarios> findAll() {
		return (List<Tusuarios>) tusuariosDao.FindUsuarios();
	}

	@Override
	@Transactional
	public void save(Tusuarios usuarios) {
		tusuariosDao.save(usuarios);
	}

	@Override
	public List<Tusuarios> findUsuario(String usua_usuario, String usua_paswd) {
		return (List<Tusuarios>) tusuariosDao.FindUsuario(usua_usuario, usua_paswd);
	}

	@Override
	public List<Tusuarios> findUsuarioName(String usua_usuario) {
		return (List<Tusuarios>) tusuariosDao.FindUsuarioName(usua_usuario);
	}

}
