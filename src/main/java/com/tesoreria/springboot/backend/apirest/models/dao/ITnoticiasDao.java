package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tnoticias;

public interface ITnoticiasDao extends CrudRepository<Tnoticias, String>{
	
	 @Query(value="select * from tnoticias where tnot_estatus = 'A' order by tnot_fecha desc", nativeQuery = true)
	  List<Tnoticias> FindNoticias();
	 
	 @Query(value="select * from tnoticias where tnot_id =?1", nativeQuery = true)
	  List<Tnoticias> FindNoticia(Long tnot_id);
	 
	 @Query(value="select * from tnoticias where tnot_id =?1", nativeQuery = true)
	  Tnoticias FindNoticiaUpdate(Long tnot_id);

}
