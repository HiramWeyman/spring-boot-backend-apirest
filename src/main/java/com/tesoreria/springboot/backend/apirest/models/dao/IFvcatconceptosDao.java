package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Fvcatconceptos;

public interface IFvcatconceptosDao extends CrudRepository<Fvcatconceptos, String>{
	
	@Query(value="select * from fvcatconceptos where alumnos = 'S' order by descripcion", nativeQuery = true)
	  List<Fvcatconceptos> CatalogoPagos10();
	
	@Query(value="select * from fvcatconceptos where personal = 'S' order by descripcion", nativeQuery = true)
	  List<Fvcatconceptos> CatalogoPagos20();
	
	@Query(value="select * from fvcatconceptos where ures = 'S' order by descripcion", nativeQuery = true)
	  List<Fvcatconceptos> CatalogoPagos30();
	
	@Query(value="select * from fvcatconceptos where incorporadas = 'S' order by descripcion", nativeQuery = true)
	  List<Fvcatconceptos> CatalogoPagos40();
	
	@Query(value="select * from fvcatconceptos where publico = 'S' order by descripcion", nativeQuery = true)
	  List<Fvcatconceptos> CatalogoPagos50();
	
	@Query(value="select * from fvcatconceptos " + 
				" where (alumnos = 'S' or personal = 'S' or incorporadas = 'S' or ures = 'S' or publico = 'S') " + 
				" order by descripcion", nativeQuery = true)
	  List<Fvcatconceptos> CatalogoPagos80();

}
