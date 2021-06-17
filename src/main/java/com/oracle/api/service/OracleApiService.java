package com.oracle.api.service;

import com.oracle.api.model.OracleConnectionRequest;

public interface OracleApiService {
	
	String getConnectionFromOracle(OracleConnectionRequest request);

}
