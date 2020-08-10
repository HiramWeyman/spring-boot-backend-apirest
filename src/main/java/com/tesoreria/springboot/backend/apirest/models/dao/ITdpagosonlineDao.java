package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tdpagosonline;

public interface ITdpagosonlineDao extends CrudRepository<Tdpagosonline, String>{

	@Query(value="select * from tdpagosonline", nativeQuery = true)
	  List<Tdpagosonline> FindAll();
	
}
