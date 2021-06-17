package com.oracle.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.api.model.OracleConnectionRequest;
import com.oracle.api.model.Response;
import com.oracle.api.service.OracleApiService;
/**
 * @author shradha.baldawa
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/oracle")
public class OracleConnectController {
	
	Logger logger = LoggerFactory.getLogger(OracleConnectController.class);
	
	@Autowired
	private OracleApiService service;
	
	@PostMapping("/getConnection")
	public Response connectionCheck(@RequestBody OracleConnectionRequest request){
		String status = service.getConnectionFromOracle(request);
		if(status.equals("success")) {
			logger.info("Connected Successfully");
			return new Response(HttpStatus.OK.value(),"OK" , "Connected Successfully");
			
		}
			logger.error("Failed to connect.Please check Credentials");
			return new Response(HttpStatus.BAD_REQUEST.value(),status, "Connection Failed");
	
		
	}

}
