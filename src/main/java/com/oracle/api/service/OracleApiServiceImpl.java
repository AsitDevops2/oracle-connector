package com.oracle.api.service;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oracle.api.model.OracleConnectionRequest;

@Service
public class OracleApiServiceImpl implements OracleApiService {

	Logger logger = LoggerFactory.getLogger(OracleApiService.class);

	@Override
	public String getConnectionFromOracle(OracleConnectionRequest request) {
		String connectionStatus = "success";
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			logger.info("User {} requested for oracle connection", request.getUsername());
			DriverManager.getConnection(request.getUrl(), request.getUsername(), request.getPassword());

		} catch (ClassNotFoundException | SQLException error) {
			connectionStatus = error.getMessage();
			logger.error(connectionStatus);
			
		}
		
		return connectionStatus;
	}

}
