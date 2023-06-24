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

import com.tesoreria.springboot.backend.apirest.models.dao.IFcatingDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Fcating;
import com.tesoreria.springboot.backend.apirest.models.entity.Tdpagosonline;
import com.tesoreria.springboot.backend.apirest.models.services.ITdpagosonlineService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TdpagosonlineRestController {
	private List<String> det;
	@Autowired
	private ITdpagosonlineService tdspagosonlineService;
	
	@Autowired
	private IFcatingDao IFcatingDao;
	
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
		String vdes_regid=null;
		//String desc="";
		int cant=0;
		double p_unit=0.00;
		double descto=0.00;
		double dtopagar=0.00;
		String[] parts;
		
		ArrayList<Tdpagosonline> lista = new ArrayList<Tdpagosonline>();
		System.out.println("folio: "+folio);
		for(String str : det)
		{
			parts=str.split("_");
			id_ingreso = parts[0];
			int valorCount = IFcatingDao.BuscaRegistros(id_ingreso);
			
			if(valorCount>0) {
				List<Fcating> detalle = IFcatingDao.detallePaquete(id_ingreso);
				for (Fcating deta : detalle) {
					Tdpagosonline dpago_det=new Tdpagosonline();
					cant=Integer.parseInt(parts[1]);
					dpago_det.setDpago_folpago(folio_det);
					dpago_det.setDpago_idingreso(deta.getCati_ingid());
					dpago_det.setDpago_cantidad(cant);
					dpago_det.setDpago_punit(deta.getCati_punit());
				    dpago_det.setDpago_regid_descto(null);
				    
				    this.tdspagosonlineService.save(dpago_det);
				}
			}else {
				//desc= parts[1];
				Tdpagosonline dpago_det=new Tdpagosonline();
			    cant=Integer.parseInt(parts[1]);
			    p_unit=Double.parseDouble(parts[2]);
			    
			    dpago_det.setDpago_folpago(folio_det);
			    dpago_det.setDpago_idingreso(id_ingreso);
			    dpago_det.setDpago_cantidad(cant);
			    dpago_det.setDpago_punit(p_unit);
			    dpago_det.setDpago_regid_descto(null);
			    
			    if (!parts[3].equals("null")) {
			    	vdes_regid=parts[3];
			    	descto=Double.parseDouble(parts[4]);
			    	dtopagar=Double.parseDouble(parts[5]);
			    	
			    	dpago_det.setDpago_regid_descto(vdes_regid);
			    	dpago_det.setDpago_descto(descto);
			    	dpago_det.setDpago_dto_pagar(dtopagar);
			    }
			    
			    this.tdspagosonlineService.save(dpago_det);      
			    
			}
		    	    
			
		}
		 
		//this.tdspagosonlineService.save(dpago_det);
		//this.tdspagosonlineService.save(tdpagosonline);
		//return tdpagosonline;
		//return null;
	}
	
	
}
