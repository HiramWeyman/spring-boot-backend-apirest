package com.tesoreria.springboot.backend.apirest.controllers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

//@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.1.190:8080" })
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ImagesUploadRestController {
	
	@PostMapping("/uploadFile/{id}/{table}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> uploadFile(@PathVariable String id, @PathVariable String table, @RequestBody MultipartFile file) throws JSchException, IOException, SQLException {
		Connection conn = null;
		String sequence = null;
		ResultSet rs = null;
		Integer bandera = 0;
		try {
            Class.forName("oracle.jdbc.OracleDriver");
        
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.184:1527:sai2", "TESOPORTAL", "TP2020");
        if (conn != null)
            System.out.println("Database Connected");
        else
        	System.out.println(" connection Failed ");

        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT LPAD(tesoportal.tsqimagenes.nextval, 8,'0') from dual");
        while (rs.next()) {
        	sequence = rs.getString(1);
        }
        stmt.close();
        
		}catch (Exception e) {
	        System.err.println("Got an exception! ");
	        System.err.println(e.getMessage());
	    }
		
		String par1 = sequence.substring(0,2);
		String par2 = sequence.substring(2,4);
		String par3 = sequence.substring(4,6);
		//String par4 = sequence.substring(6,8);
		//String NomArvhico=par4;
		String rutaImagenes=par1+"/"+par2+"/"+par3;
		String rutaFTP="/serv-imagenes/PIMAGENES/"+rutaImagenes;
		
		String FTP_ADDRESS = "192.168.10.17";
		
		JSch jsch = new JSch();
		ChannelSftp sftp = null;
		Session sessionSFT = null;
		try {
		   sessionSFT = jsch.getSession("noticias",FTP_ADDRESS,22);
		   sessionSFT.setConfig("PreferredAuthentications", "password");
		   sessionSFT.setConfig("StrictHostKeyChecking", "no");
		   sessionSFT.setPassword("Noti2020");
		   sessionSFT.connect();
		   Channel channel = sessionSFT.openChannel("sftp");
		   sftp = (ChannelSftp) channel;
		   sftp.connect();
	    
		
			try {
				SftpATTRS attrs = null;
				String path="";
				try {
					attrs = sftp.stat(rutaFTP);
				} catch (SftpException e) {
					System.out.println(e.getMessage());
				}
				if (attrs == null) {
					// La carpeta no existe
					String[] folders = rutaFTP.split( "/" );
					for ( String folder : folders ) {
						path = path+"/"+folder;
					    if ( folder.length() > 0 ) {
					        try {
					            sftp.cd( path );
					        }
					        catch ( SftpException e ) {
					            sftp.mkdir( path );
					            sftp.cd( path );
					        }
					    }
					}
				}	
	
					InputStream inputStream =  new BufferedInputStream(file.getInputStream());
				   //InputStream inputStream = new FileInputStream(file);
				   sftp.cd(rutaFTP);
				   sftp.put(inputStream,file.getOriginalFilename());
				   inputStream.close();
				   
				   conn.setAutoCommit(false);
				   String update ="";
				   if(table.equals("tnoticias")) {
					   update = "update tesoportal.tnoticias set tnot_ruta_img = '"+rutaImagenes+"/"+file.getOriginalFilename()+"' where tnot_id = '"+id+"'";
				   }
				   if(table.equals("tbanners")) {
					   update = "update tesoportal.tbanners set tban_ruta_img = '"+rutaImagenes+"/"+file.getOriginalFilename()+"' where tban_id = '"+id+"'";
				   }
				   if(table.equals("tequipo")) {
					   update = "update tesoportal.tequipo set teq_ruta_img = '"+rutaImagenes+"/"+file.getOriginalFilename()+"' where teq_id = '"+id+"'";
				   }
				   
				   Statement stmt2 = conn.createStatement();
				   stmt2.executeUpdate(update);
				   conn.commit();
				   bandera = 1;
			} catch (SftpException e) {
			   System.out.println("No se pudo subir el fichero");
			} 
		} catch (JSchException e) {
			   System.out.println("No se pudo realizar la conexión");
		}finally {
			conn.close();
			
			sftp.exit();
			sftp.disconnect();
			sessionSFT.disconnect();
		}
		
		if(bandera.equals(1)) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
		
    }
	
	/*
	@PostMapping("/uploadBanner/{id}/{ban}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> uploadFile(@PathVariable String id, @PathVariable String ban, @RequestBody MultipartFile file) throws JSchException, IOException, SQLException {
		Connection conn = null;
		String sequence = null;
		ResultSet rs = null;
		Integer bandera = 0;
		try {
            Class.forName("oracle.jdbc.OracleDriver");
        
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.184:1527:sai2", "TESOPORTAL", "TP2020");
        if (conn != null)
            System.out.println("Database Connected");
        else
        	System.out.println(" connection Failed ");

        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT LPAD(tesoportal.tsqimagenes.nextval, 8,'0') from dual");
        while (rs.next()) {
        	sequence = rs.getString(1);
        }
        stmt.close();
        
		}catch (Exception e) {
	        System.err.println("Got an exception! ");
	        System.err.println(e.getMessage());
	    }
		
		String par1 = sequence.substring(0,2);
		String par2 = sequence.substring(2,4);
		String par3 = sequence.substring(4,6);
		//String par4 = sequence.substring(6,8);
		//String NomArvhico=par4;
		String rutaImagenes=par1+"/"+par2+"/"+par3;
		String rutaFTP="/serv-imagenes/PIMAGENES/"+rutaImagenes;
		
		String FTP_ADDRESS = "192.168.10.17";
		
		JSch jsch = new JSch();
		ChannelSftp sftp = null;
		Session sessionSFT = null;
		try {
		   sessionSFT = jsch.getSession("noticias",FTP_ADDRESS,22);
		   sessionSFT.setConfig("PreferredAuthentications", "password");
		   sessionSFT.setConfig("StrictHostKeyChecking", "no");
		   sessionSFT.setPassword("Noti2020");
		   sessionSFT.connect();
		   Channel channel = sessionSFT.openChannel("sftp");
		   sftp = (ChannelSftp) channel;
		   sftp.connect();
	    
		
			try {
				SftpATTRS attrs = null;
				String path="";
				try {
					attrs = sftp.stat(rutaFTP);
				} catch (SftpException e) {
					System.out.println(e.getMessage());
				}
				if (attrs == null) {
					// La carpeta no existe
					String[] folders = rutaFTP.split( "/" );
					for ( String folder : folders ) {
						path = path+"/"+folder;
					    if ( folder.length() > 0 ) {
					        try {
					            sftp.cd( path );
					        }
					        catch ( SftpException e ) {
					            sftp.mkdir( path );
					            sftp.cd( path );
					        }
					    }
					}
				}	
	
					InputStream inputStream =  new BufferedInputStream(file.getInputStream());
				   //InputStream inputStream = new FileInputStream(file);
				   sftp.cd(rutaFTP);
				   sftp.put(inputStream,file.getOriginalFilename());
				   inputStream.close();
				   
				   conn.setAutoCommit(false);
				   String update = "update tesoportal.tbanners set tban_ruta_img = '"+rutaImagenes+"/"+file.getOriginalFilename()+"' where tban_id = '"+id+"'";
				   Statement stmt2 = conn.createStatement();
				   stmt2.executeUpdate(update);
				   conn.commit();
				   bandera = 1;
			} catch (SftpException e) {
			   System.out.println("No se pudo subir el fichero");
			} 
		} catch (JSchException e) {
			   System.out.println("No se pudo realizar la conexión");
		}finally {
			conn.close();
			
			sftp.exit();
			sftp.disconnect();
			sessionSFT.disconnect();
		}
		
		if(bandera.equals(1)) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
		
    }
	 */
}
