package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Fcating;

public interface IFcatingDao extends CrudRepository<Fcating, String>{
	
	@Query(value="select * from finanzas.fcating where cati_alumnos='S' and cati_fbaja is null order by cati_descrip", nativeQuery = true)
	  List<Fcating> CatalogoPagos10();
	
	@Query(value="select * from finanzas.fcating where cati_personal='S' and cati_fbaja is null order by cati_descrip", nativeQuery = true)
	  List<Fcating> CatalogoPagos20();
	
	@Query(value="select * from finanzas.fcating where cati_ures='S' and cati_fbaja is null order by cati_descrip", nativeQuery = true)
	  List<Fcating> CatalogoPagos30();
	
	@Query(value="select * from finanzas.fcating where cati_incorporadas='S' and cati_fbaja is null order by cati_descrip", nativeQuery = true)
	  List<Fcating> CatalogoPagos40();
	
	@Query(value="select * from finanzas.fcating where cati_publico='S' and cati_fbaja is null order by cati_descrip", nativeQuery = true)
	  List<Fcating> CatalogoPagos50();
	
	@Query(value="select * " + 
			" from finanzas.fcating " + 
			" where cati_fbaja is null " + 
			" and (cati_alumnos='S' or cati_personal='S' or cati_ures='S' or cati_incorporadas='S' or cati_publico='S') " + 
			" order by cati_descrip", nativeQuery = true)
	  List<Fcating> CatalogoPagos80();
	
	@Query(value="select count(*) from finanzas.fcating where cati_paquete =?1", nativeQuery = true)
	public int BuscaRegistros(String cati_paquete);
	
	@Query(value="select * from finanzas.fcating where cati_paquete =?1", nativeQuery = true)
	  List<Fcating> detallePaquete(String cati_paquete);

}
