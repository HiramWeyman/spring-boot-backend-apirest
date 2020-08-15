package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.entity.Tdpagosonline;
import com.tesoreria.springboot.backend.apirest.models.services.ITdpagosonlineService;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TdpagosonlineRestController {
	private List<String> det;
	@Autowired
	private ITdpagosonlineService tdspagosonlineService;
	
	@GetMapping("/tdpagosonline")
	public List<Tdpagosonline> index() {
		return tdspagosonlineService.findAll();
	}
	
	//@PostMapping("/tdpagosonline")
	//@PostMapping(value = "/tdpagosonline", consumes = MediaType.APPLICATION_JSON_VALUE)
	//@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	//@ResponseStatus(HttpStatus.CREATED)
	
	//@RequestMapping(value = { "/tdpagosonline" }, method = {RequestMethod.POST }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	@PostMapping("/tdpagosonline")
	public void create(String folio,@RequestParam(value="det") String[] det){
		int folio_det=Integer.parseInt(folio);
		String id_ingreso="";
		String desc="";
		int cant=0;
		double p_unit=0.00;
		double descto=0.00;
		String[] parts;
		
		ArrayList<Tdpagosonline> lista = new ArrayList<Tdpagosonline>();
		System.out.println("folio: "+folio);
		
		for(String str : det)
		{
			//imprimimos el objeto pivote
		    //System.out.println("value: "+str);
		    Tdpagosonline dpago_det=new Tdpagosonline();
		    parts=str.split("-");
		    id_ingreso = parts[0]; 
		    desc= parts[1];
		    cant=Integer.parseInt(parts[2]);
		    p_unit=Double.parseDouble(parts[3]);
		    
		    
		    dpago_det.setDpago_folpago(folio_det);
		    dpago_det.setDpago_idingreso(id_ingreso);
		    dpago_det.setDpago_cantidad(cant);
		    dpago_det.setDpago_punit(p_unit);

		    if (!parts[4].equals("null")) {
		    	descto=Double.parseDouble(parts[4]);
		    	dpago_det.setDpago_descto(descto);
		    }

		    
		    this.tdspagosonlineService.save(dpago_det);
		    
		}
		 
		//this.tdspagosonlineService.save(tdpagosonline);
		//return tdpagosonline;
		//return null;
	}
	
}
