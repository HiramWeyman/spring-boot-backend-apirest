package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Fdesctos;


public interface IFdesctosDao extends CrudRepository<Fdesctos, Long>{

	@Query(value="select * from fdesctos", nativeQuery = true)
	  List<Fdesctos> FindAll();

	@Query(value="select * from fdesctos where desc_ures= ?1 and desc_matricula= ?2 and (desc_fcancel is null and desc_ucancel is null) " + 
				 "and not EXISTS (SELECT '1' FROM tpagosonline WHERE PAGO_FOLDESCTO = DESC_FOLIODESC and pago_estatus = 'A')", nativeQuery = true)
	  List<Fdesctos> FindDescuento(String desc_ures, String desc_matricula);
	
}
