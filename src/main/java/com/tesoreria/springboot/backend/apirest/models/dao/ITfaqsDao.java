package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tfaqs;

public interface ITfaqsDao extends CrudRepository<Tfaqs, String>{

	 @Query(value="select *from tfaqs where faqs_estatus = 'A' order by to_number(faqs_id)", nativeQuery = true)
	  List<Tfaqs> FindFaqs();
	 
	 @Query(value="select *from tfaqs where faqs_id = ?1", nativeQuery = true)
	  List<Tfaqs> FindFaq(Long faqs_id);
	 
	 @Query(value="select *from tfaqs where faqs_id = ?1", nativeQuery = true)
	 Tfaqs FindFaqUpdate(Long faqs_id);
	 
}
