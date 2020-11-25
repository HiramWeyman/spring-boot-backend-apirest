package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Ttipouser;

public interface ITtipouserDao extends CrudRepository<Ttipouser, Long>{
	
	 @Query(value="select * from ttipouser where tipo_userid not in ('60','70','80','90') order by tipo_descrip", nativeQuery = true)
	  List<Ttipouser> FindTtipousers();
	 
	 @Query(value="select * from ttipouser where tipo_userid not in ('60','70','90') and tipo_userid = ?1 order by tipo_descrip", nativeQuery = true)
	 List<Ttipouser> findTipo(String pago_userid);

}
