package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.SideBar;

public interface ISideBarDao extends CrudRepository<SideBar, String>{
	
	@Query(value="select * from trolesusuario", nativeQuery = true)
	  List<SideBar> findAll();
	
	 @Query(value="select * from trolesusuario where rolu_tipo_user =?1 order by to_number(rolu_modulo_id)", nativeQuery = true)
	  List<SideBar> FindRol(String rolu_tipo_user);

}
