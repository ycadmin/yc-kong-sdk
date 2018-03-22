package com.ycg.rdc.support.api.kong;

import java.util.HashMap;

public interface KongAdminClient {
	<T extends KongResponse> T execute(KongRequest<T> request) throws KongException;
	
	<T extends KongResponse> T execute(KongRequest<T> request, String resourceParam) throws KongException;
	
	<T extends KongResponse> T execute(KongRequest<T> request, HashMap<String, Object> param) throws KongException;
	
	<T extends KongResponse> T execute(KongRequest<T> request, HashMap<String, Object> param,  String resourceParam) throws KongException;
	
	void close() throws KongException;
}
