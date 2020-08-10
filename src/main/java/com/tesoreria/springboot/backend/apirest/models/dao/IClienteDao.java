package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

	 @Query(value="select * from clientes", nativeQuery = true)
	  List<Cliente> FindClientes();
	
	//public static final String FIND_CLIENTES = "SELECT id, nombre,apellido FROM clientes";

//	@Query(value = FIND_CLIENTES, nativeQuery = true)
//	public List<Object[]> FindClientes();
	


	 
	 
	 @Query(value="select * from clientes where nombre = ?1 ", nativeQuery = true)
	  List<Cliente> FindCliente(Long id);
	 
//	 @Query("SELECT a FROM Author a WHERE firstName = ?1 AND lastName = ?2")
//	    List<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
