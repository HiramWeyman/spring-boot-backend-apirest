package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvprogramas;

public interface ITvprogramasDao extends CrudRepository<Tvprogramas, String>{
	
	@Query(value="select * from tvprogramas", nativeQuery = true)
	  List<Tvprogramas> FindTvprogramas();
	
	 @Query(value="select * from tvprogramas where prog_ures = ?1 order by prog_progdesc", nativeQuery = true)
	  List<Tvprogramas> FindTvprograma(Long id);

}
