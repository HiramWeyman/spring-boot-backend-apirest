package com.tesoreria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.dao.IFcatingDao;
import com.tesoreria.springboot.backend.apirest.models.entity.Fcating;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FcatingRestController {
	
	//@Autowired
	//private IFcatingService fcatingService;
	
	@Autowired
	private IFcatingDao IFcatingDao;	
	
	
	@GetMapping("/catalogoPago/{tipo_user}")
	public List<Fcating> index(@PathVariable String tipo_user) {
		
		if (tipo_user.equals("10")){return IFcatingDao.CatalogoPagos10();}
		if (tipo_user.equals("20")){return IFcatingDao.CatalogoPagos20();}
		if (tipo_user.equals("30")){return IFcatingDao.CatalogoPagos30();}
		if (tipo_user.equals("40")){return IFcatingDao.CatalogoPagos40();}
		if (tipo_user.equals("50")){return IFcatingDao.CatalogoPagos50();}
		if (tipo_user.equals("80")){return IFcatingDao.CatalogoPagos80();}

		return null;
	}
	
	/*
	@GetMapping("/catalogoPago/{tipo_user}")
	public  List<Object[]> index(@PathVariable String tipo_user) throws IOException {
		
		String Campo = "";
		
		if (tipo_user.equals("10")){Campo="cati_alumnos";}
		if (tipo_user.equals("20")){Campo="cati_personal";}
		if (tipo_user.equals("30")){Campo="cati_ures";}
		if (tipo_user.equals("40")){Campo="cati_incorporadas";}
		if (tipo_user.equals("50")){Campo="cati_publico";}
		
		EntityManagerFactory emf =	Persistence.createEntityManagerFactory("properties");
		EntityManager entityManager = emf.createEntityManager();
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("tesoportal.pkg_tpago.prc_Catalogo_Pago");
		
		// Registrar los parámetros de entrada y salida
		storedProcedureQuery.registerStoredProcedureParameter("v_campo", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("par_cursor", Class.class, ParameterMode.REF_CURSOR);
       
        // Configuramos el valor de entrada
        storedProcedureQuery.setParameter("v_campo", Campo);
        
        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();
        
        // Obtenemos el resultado del cursos en una lista
        List<Object[]> personComments = storedProcedureQuery.getResultList();
		
		return personComments;
	}
	*/
}
