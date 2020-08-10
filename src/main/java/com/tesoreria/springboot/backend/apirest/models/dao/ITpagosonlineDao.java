package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tpagosonline;

public interface ITpagosonlineDao extends CrudRepository<Tpagosonline, Long>{

	@Query(value="select * from tpagosonline", nativeQuery = true)
	  List<Tpagosonline> FindAll();

	//@Query(value="select * from tpagosonline where pago_userid=?1 and pago_estatus = 'A' order by pago_fpago DESC ", nativeQuery = true)
	@Query(value="select * from tpagosonline where pago_usuaid=?1 order by to_number(pago_folpago) desc ", nativeQuery = true)
	List<Tpagosonline> findPago(String pago_userid);

	
}
