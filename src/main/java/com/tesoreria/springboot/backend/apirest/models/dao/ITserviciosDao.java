package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tservicios;

public interface ITserviciosDao extends CrudRepository<Tservicios, String>{
	
	@Query(value="select * from tservicios where teq_estatus = 'A' order by to_number(tser_id) desc", nativeQuery = true)
	  List<Tservicios> FindServicios();
	 
	 @Query(value="select * from tservicios where tser_id =?1", nativeQuery = true)
	  List<Tservicios> FindServicio(Long tser_id);
	 
	 @Query(value="select * from tservicios where tser_id =?1", nativeQuery = true)
	 Tservicios FindServicioUpdate(Long tser_id);

}
