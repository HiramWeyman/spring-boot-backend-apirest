package com.tesoreria.springboot.backend.apirest.controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRSaver;


@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@RestController
@RequestMapping("/api")
public class PrintPDFRestController {

	@Value("${API_CONTEXT_ROOT}")
	private String contextRoot;
	
	@GetMapping(value = "/print/{id}/{ref_banco}")
	public void report(HttpServletResponse response, @PathVariable("id") String id,@PathVariable("ref_banco") String ref_banco) throws Exception {
		
		//String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/TEST2017ECOMM1/order/"+ref_banco+"";
		String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/TEST1125660/order/"+ref_banco+"";
		//String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/1125660/order/"+ref_banco+"";
		URL url = new URL(Url);
		URLConnection uc = url.openConnection();
		//String userpass = "merchant.TEST2017ECOMM1" + ":" + "ac50e16a0c295b971ed55b0086ad0262";
		String userpass = "merchant.TEST1125660" + ":" + "65cb98f2f8df3930064103df1784935c";
		//String userpass = "merchant.1125660" + ":" + "7e0e81526f5b1c95195e4be42e54cbb9";
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
		    
	    } catch (JSONException e) {
	    	e.printStackTrace();
	        System.out.println(e.getMessage());
	    } 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//final String invoice_template = "../pdfEjemplo.jrxml";
	    //Invoice invoice = invoiceRepo.getOne(id);
		System.out.println("ruta"+contextRoot);
		Connection conn = null;
		try {
            Class.forName("oracle.jdbc.OracleDriver");
        
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.184:1527:sai2", "TESOPORTAL", "TP2020");
        if (conn != null)
            System.out.println("Database Connected");
        else
        	System.out.println(" connection Failed ");
		
		InputStream employeeReportStream = getClass().getResourceAsStream("/pdfEjemplo.jrxml");
		//InputStream employeeReportStream2 = getClass().getResourceAsStream("/pdfEjemplo_subreport2.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);
		JRSaver.saveObject(jasperReport, "pdfEjemplo.jasper");
		
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("p_ruta_img", "");
		parameters.put("id", id);
		parameters.put("receipt", receipt);
		parameters.put("authorizationCode", authorizationCode);
		parameters.put("SUBREPORT_DIR2","");
		ServletOutputStream out;
		
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource.getConnection());
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
		//byte[] fichero = JasperRunManager.runReportToPdf (jasperReport, parameters, itpagosonlineDao.findIDPago(id));
		byte[] fichero = JasperRunManager.runReportToPdf (jasperReport, parameters, conn);

		//JRPdfExporter exporter = new JRPdfExporter();
		
		response.setContentType ("application/pdf");
		response.setHeader ("Content-disposition", "inline; filename=reciboBanco.pdf");
		response.setHeader ("Cache-Control", "max-age=30");
		response.setHeader ("Pragma", "No-cache");
		response.setDateHeader ("Expires", 0);
		response.setContentLength (fichero.length);
		out = response.getOutputStream ();	
		out.write (fichero, 0, fichero.length);
		out.flush ();
		out.close (); 
		
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
	}
	
	//////REPORTE DE DESCUENTOS
	@GetMapping(value = "/printDesc/{id}/{ref_banco}")
	public void reportDesc(HttpServletResponse response, @PathVariable("id") String id,@PathVariable("ref_banco") String ref_banco) throws Exception {
		
		//String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/TEST2017ECOMM1/order/"+ref_banco+"";
		String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/TEST1125660/order/"+ref_banco+"";
		//String Url = "https://evopaymentsmexico.gateway.mastercard.com/api/rest/version/52/merchant/1125660/order/"+ref_banco+"";
		URL url = new URL(Url);
		URLConnection uc = url.openConnection();
		//String userpass = "merchant.TEST2017ECOMM1" + ":" + "ac50e16a0c295b971ed55b0086ad0262";
		String userpass = "merchant.TEST1125660" + ":" + "65cb98f2f8df3930064103df1784935c";
		//String userpass = "merchant.1125660" + ":" + "7e0e81526f5b1c95195e4be42e54cbb9";
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
		    
	    } catch (JSONException e) {
	    	e.printStackTrace();
	        System.out.println(e.getMessage());
	    } 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//final String invoice_template = "../pdfEjemplo.jrxml";
	    //Invoice invoice = invoiceRepo.getOne(id);
		System.out.println("ruta"+contextRoot);
		Connection conn = null;
		try {
            Class.forName("oracle.jdbc.OracleDriver");
        
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.184:1527:sai2", "TESOPORTAL", "TP2020");
        if (conn != null)
            System.out.println("Database Connected");
        else
        	System.out.println(" connection Failed ");
		
		InputStream employeeReportStream = getClass().getResourceAsStream("/reciboDescuento.jrxml");
		//InputStream employeeReportStream2 = getClass().getResourceAsStream("/pdfEjemplo_subreport2.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);
		JRSaver.saveObject(jasperReport, "reciboDescuento.jasper");
		
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("p_ruta_img", "");
		parameters.put("id", id);
		parameters.put("receipt", receipt);
		parameters.put("authorizationCode", authorizationCode);
		parameters.put("SUBREPORT_DIR2","");
		ServletOutputStream out;
		
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource.getConnection());
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
		//byte[] fichero = JasperRunManager.runReportToPdf (jasperReport, parameters, itpagosonlineDao.findIDPago(id));
		byte[] fichero = JasperRunManager.runReportToPdf (jasperReport, parameters, conn);

		//JRPdfExporter exporter = new JRPdfExporter();
		
		response.setContentType ("application/pdf");
		response.setHeader ("Content-disposition", "inline; filename=reciboBanco.pdf");
		response.setHeader ("Cache-Control", "max-age=30");
		response.setHeader ("Pragma", "No-cache");
		response.setDateHeader ("Expires", 0);
		response.setContentLength (fichero.length);
		out = response.getOutputStream ();	
		out.write (fichero, 0, fichero.length);
		out.flush ();
		out.close (); 
		
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
	}
	
}
