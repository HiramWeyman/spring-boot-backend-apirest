package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tesoreria.springboot.backend.apirest.models.dao.ITusuariosDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Tusuarios;
import com.tesoreria.springboot.backend.apirest.models.services.ITusuariosService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class TusuariosRestController {
	
	@Autowired
	private ITusuariosService tusuariosService;
	
	@Autowired
	private ITusuariosDao tusuariosDao;

	@GetMapping("/tusuarios")
	public List<Tusuarios> index() {
		return tusuariosService.findAll();
	}
	
	
	//@PostMapping("/tusuarios/{usua_usuario}/{usua_paswd}")
	@PostMapping(path = "/tusuarios/{usua_usuario}/{usua_paswd:.+}", consumes = "application/json", produces = "application/json")
	public List<Tusuarios> show(@PathVariable String usua_usuario,@PathVariable String usua_paswd)  {
		
		String encodedString = Base64.getEncoder().encodeToString(usua_paswd.getBytes());
		return tusuariosService.findUsuario(usua_usuario, encodedString);
	}
	
	
	@PostMapping("/tusuarios/{usua_usuario}")
	public Tusuarios show(@PathVariable String usua_usuario)  {
		return tusuariosService.findUsuarioName(usua_usuario);
	}
	

	@PostMapping("/tusuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Tusuarios create(@RequestBody Tusuarios tusuarios) {
		//tusuarios.setCreateAt(new Date());

		String encodedString = Base64.getEncoder().encodeToString(tusuarios.getUsua_paswd().getBytes());
		tusuarios.setUsua_paswd(encodedString);
	
		this.tusuariosService.save(tusuarios);
		return tusuarios;
	}
	
	@PostMapping("/tusuariosPass/{usua_usuario}")
	public Tusuarios create(@RequestBody Tusuarios tusuarios, @PathVariable String usua_usuario) {
		Tusuarios currentTusuarios = this.tusuariosDao.FindUsuarioName(usua_usuario);

		String encodedString = Base64.getEncoder().encodeToString(tusuarios.getUsua_paswd().getBytes());
		((Tusuarios) currentTusuarios).setUsua_paswd(encodedString);
	
		this.tusuariosService.save(currentTusuarios);
		return tusuarios;
	}

}
