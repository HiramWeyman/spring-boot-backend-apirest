package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Epagorecibo;

public interface IEpagoreciboDao extends CrudRepository<Epagorecibo, String>{
	
	@Query(value="select *from escolarteso.epagorecibo", nativeQuery = true)
	  List<Epagorecibo> Recibos();

	@Query(value="select *from escolarteso.epagorecibo where pago_folregid =?1 and pago_folpago =?2", nativeQuery = true)
		Epagorecibo ReciboDet(Long pago_folregid, int i);

	
	
}
