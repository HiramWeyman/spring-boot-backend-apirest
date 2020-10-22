package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvmaestropagos;

public interface ITvmaestropagosDao extends CrudRepository<Tvmaestropagos, String>{
	
	@Query(value="select *from tvmaestropagos order by to_number(vmae_foliopago)", nativeQuery = true)
	  List<Tvmaestropagos> Pagos();
	
	@Query(value="select *from tvmaestropagos where vmae_foliopago =?1 order by to_number(vmae_foliopago)", nativeQuery = true)
	  List<Tvmaestropagos> Pago(String vmae_foliopago);

}
