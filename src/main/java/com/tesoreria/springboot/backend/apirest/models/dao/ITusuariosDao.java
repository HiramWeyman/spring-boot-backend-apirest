package com.tesoreria.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesoreria.springboot.backend.apirest.models.entity.Tusuarios;

public interface ITusuariosDao extends CrudRepository<Tusuarios, String>{
	
	 @Query(value="select * from tusuarios", nativeQuery = true)
	  List<Tusuarios> FindUsuarios();
	 
	 @Query(value="select * from tusuarios where usua_usuario =?1 and usua_paswd =?2", nativeQuery = true)
	  List<Tusuarios> FindUsuario(String usua_usuario, String usua_paswd);
	 
	 @Query(value="select * from tusuarios where usua_usuario =?1", nativeQuery = true)
	  List<Tusuarios> FindUsuarioName(String usua_usuario);

}
