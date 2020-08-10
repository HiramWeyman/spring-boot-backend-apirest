package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.springboot.backend.apirest.models.dao.IClienteDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
//	@Override
//	@Transactional(readOnly = true)
//	public List<Cliente> findAll() {
//		return (List<Cliente>) clienteDao.findAll();
//	}
	
//	@Override
//	@Transactional(readOnly = true)
//	public List<Object[]> findAll() {
//		return (List<Object[]>) clienteDao.FindClientes();
//	}
//	
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.FindClientes();
	}
	

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override	
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	
	@Transactional(readOnly = true)
	public List<Cliente> findCliente(Long id) {
		return clienteDao.FindCliente(id);
	}
	
	@Override
	@Transactional
	public void delete(Cliente cliente) {
		clienteDao.delete(cliente);
		
	}





}
