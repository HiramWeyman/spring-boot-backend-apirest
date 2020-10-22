package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tvpagossiia;

public interface ITvpagossiiaDao extends CrudRepository<Tvpagossiia, String>{
	
	@Query(value="select *from tesoportal.tvpagossiia order by to_number(vdet_foliopago)", nativeQuery = true)
	  List<Tvpagossiia> Pagos();
	
	@Query(value="select *from tesoportal.tvpagossiia where vdet_foliopago =?1 order by to_number(vdet_foliopago)", nativeQuery = true)
	  List<Tvpagossiia> Pago(String vdet_foliopago);

}
