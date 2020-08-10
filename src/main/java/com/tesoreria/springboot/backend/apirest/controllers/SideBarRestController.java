package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.entity.SideBar;
import com.tesoreria.springboot.backend.apirest.models.services.ISidebarService;

@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@RestController
@RequestMapping("/api")
public class SideBarRestController {
	
	@Autowired
	private ISidebarService sidebarService;	
	
	@GetMapping("/rolsusuario")
	public List<SideBar> index() {
		return sidebarService.findAll();
	}
	
	@GetMapping("/rolsusuario/{rolu_tipo_user}")
	public List<SideBar> show(@PathVariable String rolu_tipo_user)  {
		return sidebarService.findRol(rolu_tipo_user);
	}

}
