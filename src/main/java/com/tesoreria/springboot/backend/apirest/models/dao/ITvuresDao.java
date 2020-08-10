package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvures;

public interface ITvuresDao extends CrudRepository<Tvures, Long>{
	
	@Query(value="select * from tvures order by ures_uresdesc", nativeQuery = true)
	  List<Tvures> FindTvures();

}
