package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvdesctodetalle;

public interface ITvdesctodetalleDao extends CrudRepository<Tvdesctodetalle, Long>{
	
	@Query(value="select *from tvdesctodetalle where vdes_ures=?1 and vdes_matricula = ?2 order by vdes_concepto ", nativeQuery = true)
	  List<Tvdesctodetalle> FindDescuentodet(String vdes_ures, String vdes_matricula);

}
