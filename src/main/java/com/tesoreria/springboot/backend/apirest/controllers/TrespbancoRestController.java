package com.tesoreria.springboot.backend.apirest.controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.springboot.backend.apirest.models.entity.Trespbanco;
import com.tesoreria.springboot.backend.apirest.models.services.ITrespbancoService;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TrespbancoRestController {

	@Autowired
	private ITrespbancoService trespbancoService;

	@GetMapping("/trespbanco")
	public List<Trespbanco> index() {
		return trespbancoService.findAll();
	}
	
	@PostMapping("/trespbanco/{tres_folio}")
	@ResponseStatus(HttpStatus.CREATED)
	public void insert(@PathVariable String tres_folio) throws Exception {
		
		//String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/TEST2017ECOMM1/order/"+ref_banco+"";
		String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/TEST1143891/order/"+tres_folio+"";
		//String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/1143891/order/"+tres_folio+"";
		URL url = new URL(Url);
		URLConnection uc = url.openConnection();
		//String userpass = "merchant.TEST2017ECOMM1" + ":" + "ac50e16a0c295b971ed55b0086ad0262";
		String userpass = "merchant.TEST1143891" + ":" + "2d6535bb8bff89759b283e56823a8ad5";
		//String userpass = "merchant.1143891" + ":" + "8d56e8d4b2753f1ac9286a70ec23f779";
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
		uc.setRequestProperty ("Authorization", basicAuth);
		
		InputStream content = (InputStream)uc.getInputStream();
        BufferedReader in   = new BufferedReader (new InputStreamReader (content));
        String line ="";
        StringBuffer response2 = new StringBuffer();
        while ((line = in.readLine()) != null) {
        	response2.append(line);
        }
        in.close();
        JSONObject json = new JSONObject(response2.toString());
		JSONArray jsonArray = json.getJSONArray("transaction");
		String receipt = "";
	    String authorizationCode = "";
	    
	    List<JSONObject> list = new ArrayList<JSONObject>();
	    try {
	        int i;
	        for (i = 0; i < jsonArray.length(); i++) {
	        	list.add(jsonArray.getJSONObject(i));
	        }
	        JSONObject rec = jsonArray.getJSONObject(i-1);
	        JSONObject rec2 = rec.optJSONObject("transaction");
		    authorizationCode = rec2.getString("authorizationCode");
		    receipt = rec2.getString("receipt");
		    double amount = rec2.getDouble("amount");
		    String result = rec.getString("result");
		    
		    Connection conn = null;
			try {
	            Class.forName("oracle.jdbc.OracleDriver");
	        
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.184:1527:sai2", "TESOPORTAL", "TP2020");
		        if (conn != null)
		            System.out.println("Database Connected");
		        else
		        	System.out.println(" connection Failed ");
	        
		        String insert="insert into tesoportal.trespbanco (tres_folio,tres_result,tres_receipt,tres_authorizationcode,tres_amount) "+
		        			  " values(?,?,?,?,?)";
				PreparedStatement stQuery = null;
				stQuery = conn.prepareStatement(insert);
				stQuery.setString(1, tres_folio);
				stQuery.setString(2, result);
				stQuery.setString(3, receipt);
				stQuery.setString(4, authorizationCode);
				stQuery.setString(5, String.valueOf(amount));
				stQuery.setFetchSize(1000);
				stQuery.executeUpdate();
				stQuery.close();

			} catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                    conn = null;
	                }
	            } catch (SQLException expSQL) {
	            	expSQL.printStackTrace();
	            }
	        }
		    
	    } catch (JSONException e) {
	    	e.printStackTrace();
	        System.out.println(e.getMessage());
	    } 
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
}
