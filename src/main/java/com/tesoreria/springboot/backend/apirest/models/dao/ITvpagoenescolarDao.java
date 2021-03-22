package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvpagoenescolar;

public interface ITvpagoenescolarDao extends CrudRepository<Tvpagoenescolar, String>{

	@Query(value="select * from tvpagoenescolar order by reci_folio desc", nativeQuery = true)
	  List<Tvpagoenescolar> FindTvpagoenescolar();
	
}
