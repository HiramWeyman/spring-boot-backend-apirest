package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvreciboalumno;

public interface ITvreciboalumnoDao extends CrudRepository<Tvreciboalumno, String>{
	
	@Query(value="select *from tesoportal.tvreciboalumno order by TO_NUMBER(folio) desc", nativeQuery = true)
	  List<Tvreciboalumno> Recibos();
	
	@Query(value="select *from tesoportal.tvreciboalumno where folio =?1 order by comentarios desc", nativeQuery = true)
	  List<Tvreciboalumno> Recibo(int folio);
}
