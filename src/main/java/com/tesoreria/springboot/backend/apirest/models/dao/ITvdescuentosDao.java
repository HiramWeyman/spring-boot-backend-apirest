package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvdescuentos;

public interface ITvdescuentosDao extends CrudRepository<Tvdescuentos, Long>{

	@Query(value="  select *from tvdescuentos order by vdes_descdescrip", nativeQuery = true)
	  List<Tvdescuentos> FindAll();
	
	@Query(value="SELECT *from tvdescuentos where vdes_ures=?1 and vdes_matricula = ?2 order by vdes_descdescrip ", nativeQuery = true)
	  List<Tvdescuentos> findDistinctByNameNotIn(String vdes_ures, String vdes_matricula);

}
