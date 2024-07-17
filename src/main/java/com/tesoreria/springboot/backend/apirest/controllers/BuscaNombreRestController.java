package com.tesoreria.springboot.backend.apirest.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BuscaNombreRestController {
	
	
	@GetMapping("/buscaNombre/{tipo_user}/{matricula}")
	public HashMap<String, String> index(@PathVariable String tipo_user,@PathVariable String matricula) {
		Connection conn = null;
		String Name = null;
		ResultSet rs = null;
		try {
            Class.forName("oracle.jdbc.OracleDriver");
        
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhist:1527:sai7", "xxxx", "xxxx");
        if (conn != null)
            System.out.println("Database Connected");
        else
        	System.out.println(" connection Failed ");
        
        Statement stmt = conn.createStatement();
        if (tipo_user.equals("10")){rs = stmt.executeQuery("select nombre||' '||paterno||' '||materno as nombreCompleto from desarrollo.alumno where cve_alumno = '"+matricula+"'");}
        if (tipo_user.equals("20")){rs = stmt.executeQuery("select nombre_npm as nombreCompleto from personal.v_nom_empleado where matricula = '"+matricula+"'");}
        if (tipo_user.equals("30")){rs = stmt.executeQuery("select wper_descrip as nombreCompleto from finweb.fwpersonas where wper_scta = '"+matricula+"'");}
        if (tipo_user.equals("40")){rs = stmt.executeQuery("select wper_descrip as nombreCompleto from finweb.fwpersonas where wper_scta = '"+matricula+"'");}
        if (tipo_user.equals("50")){rs = stmt.executeQuery("select wper_descrip as nombreCompleto from finweb.fwpersonas where wper_scta = '"+matricula+"'");}
        while (rs.next()) {
        	  Name = rs.getString("nombreCompleto");
        }
        conn.close();

		}catch (Exception e) {
	        System.err.println("Got an exception! ");
	        System.err.println(e.getMessage());
	    }
		
		HashMap<String, String> map = new HashMap<>();
	    map.put("Nombre", Name);
		return map;
	
	}
}
