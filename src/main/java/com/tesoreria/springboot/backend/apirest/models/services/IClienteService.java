package com.tesoreria.springboot.backend.apirest.models.services;

import java.util.List;

import com.tesoreria.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	
	//public List<Object> findAll();
	
	public void save(Cliente cliente);
	
	public List<Cliente> findCliente(Long id);
	
    public Cliente findById(Long id);
	
	public void delete(Cliente cliente);

}
