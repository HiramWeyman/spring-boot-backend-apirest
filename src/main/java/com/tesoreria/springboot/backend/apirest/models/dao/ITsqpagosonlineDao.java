package com.tesoreria.springboot.backend.apirest.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesoreria.springboot.backend.apirest.models.entity.Tsqpagosonline;

public interface ITsqpagosonlineDao extends JpaRepository<Tsqpagosonline, String>{

	@Query(value = "select tesoportal.TSQPAGOSONLINEREF.NEXTVAL from dual", nativeQuery = true)
	 public Long getTsqpagosonline();
	
}
