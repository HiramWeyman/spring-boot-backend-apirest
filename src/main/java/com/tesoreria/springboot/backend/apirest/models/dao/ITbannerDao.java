package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tbanner;

public interface ITbannerDao extends CrudRepository<Tbanner, String>{
	
	@Query(value="select * from tbanners", nativeQuery = true)
	  List<Tbanner> FindBanners();
	
	@Query(value="select * from tbanners where tban_id =?1", nativeQuery = true)
	  List<Tbanner> FindBanner(Long tban_id);
	 
	 @Query(value="select * from tbanners where tban_id =?1", nativeQuery = true)
	 Tbanner FindBannerUpdate(Long tban_id);

}