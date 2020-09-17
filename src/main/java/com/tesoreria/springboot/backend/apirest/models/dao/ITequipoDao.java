package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tequipo;

public interface ITequipoDao extends CrudRepository<Tequipo, String>{
	
	 @Query(value="select * from tequipo where teq_estatus = 'A' order by to_number(teq_id) desc", nativeQuery = true)
	  List<Tequipo> FindEquipos();
	 
	 @Query(value="select * from tequipo where teq_id =?1", nativeQuery = true)
	  List<Tequipo> FindEquipo(Long teq_id);
	 
	 @Query(value="select * from tequipo where teq_id =?1", nativeQuery = true)
	 Tequipo FindEquipoUpdate(Long teq_id);

}
