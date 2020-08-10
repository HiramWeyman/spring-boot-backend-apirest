package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tesoreria.springboot.backend.apirest.models.entity.Cwerrmsj;

public interface ICwerrmsjDao extends CrudRepository<Cwerrmsj, String>{

	@Query(value="select * from cwerrmsj", nativeQuery = true)
	  List<Cwerrmsj> FindErrorMensajes();
	
	@Query(value="select * from cwerrmsj where cerr_refer like %:keyword", nativeQuery = true)
	  List<Cwerrmsj> FindErrorMensaje(@Param("keyword") String cerr_refer);
	
}
