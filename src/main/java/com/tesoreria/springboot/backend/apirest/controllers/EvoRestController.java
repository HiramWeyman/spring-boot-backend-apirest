package com.tesoreria.springboot.backend.apirest.controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EvoRestController {
	
	
	@GetMapping(value="/evo/{id_user}/{amount}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//@GetMapping(path = "/evo/{id_user}/{amount}", consumes = "application/json", produces = "application/json")
	public HashMap<String, String> index(@PathVariable String id_user,@PathVariable String amount) throws IOException {
		
		String url = "https://evopaymentsmexico.gateway.mastercard.com/api/nvp/version/51";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		
		//add reuqest header
		con.setRequestMethod("POST");
		//String returnUrl ="/SOMEREFO2019/RespuestaBanco";
		//String urlParameters = "apiOperation=CREATE_CHECKOUT_SESSION&apiPassword=ac50e16a0c295b971ed55b0086ad0262&apiUsername=merchant.TEST2017ECOMM1&merchant=TEST2017ECOMM1&order.id="+Usuario+"&order.amount="+Pago+"&order.currency=MXN";
		//String urlParameters = "apiOperation=CREATE_CHECKOUT_SESSION&apiPassword=2d6535bb8bff89759b283e56823a8ad5&apiUsername=merchant.TEST1143891&merchant=TEST1143891&order.id="+id_user+"&order.amount="+amount+"&order.currency=MXN";
		String urlParameters = "apiOperation=CREATE_CHECKOUT_SESSION&apiPassword=8d56e8d4b2753f1ac9286a70ec23f779&apiUsername=merchant.1143891&merchant=1143891&order.id="+id_user+"&order.amount="+amount+"&order.currency=MXN";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		
		//int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'POST' request to URL : " + url);
		//System.out.println("Post parameters : " + urlParameters);
		//System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response2 = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
		    response2.append(inputLine);
		}
		in.close();
				
		String[] valores = response2.toString().split("&");
		String[] sesion = valores[2].split("=");
		String session_id = sesion[1];
		String Indicator = valores[5];
		String[] indicador = Indicator.split("=");
		String successIndicator = indicador[1];
		
		HashMap<String, String> map = new HashMap<>();
	    map.put("session_id", session_id);
	    map.put("successIndicator", successIndicator);
	    return map;
	    
		//return "session_id: "+session_id+" successIndicator: "+successIndicator;
	}
	

}
