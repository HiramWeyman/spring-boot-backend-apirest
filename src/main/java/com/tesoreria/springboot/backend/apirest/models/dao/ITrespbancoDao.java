package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Trespbanco;

public interface ITrespbancoDao extends CrudRepository<Trespbanco, String>{
	
	 @Query(value="select * from trespbanco", nativeQuery = true)
	  List<Trespbanco> FindRespbanco();


}
