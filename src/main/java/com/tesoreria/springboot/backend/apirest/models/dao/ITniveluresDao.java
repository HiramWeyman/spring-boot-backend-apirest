package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tnivelures;

public interface ITniveluresDao extends CrudRepository<Tnivelures, Long>{

	@Query(value="select * from tnivelures order by nive_descrip", nativeQuery = true)
	  List<Tnivelures> FindTnivelures();
	
}
