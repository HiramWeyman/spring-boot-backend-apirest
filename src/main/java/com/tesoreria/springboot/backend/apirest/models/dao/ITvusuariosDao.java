package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvusuarios;

public interface ITvusuariosDao extends CrudRepository<Tvusuarios, Long>{

	@Query(value="select *from tvusuarios where userid not in (71,77) order by to_number(userid) desc", nativeQuery = true)
	  List<Tvusuarios> FindTvusuarios();
	
	@Query(value="select *from tvusuarios where userid not in (71,77) and userid =?1 order by to_number(userid) desc", nativeQuery = true)
	  List<Tvusuarios> FindTvusuario(Long userid);
	
}
