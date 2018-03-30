package com.ycg.rdc.support.api.kong.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.ycg.rdc.support.api.kong.KongAdminClient;
import com.ycg.rdc.support.api.kong.KongAdminDefaultClient;
import com.ycg.rdc.support.api.kong.KongException;
import com.ycg.rdc.support.api.kong.request.RetrieveAPIRequest;
import com.ycg.rdc.support.api.kong.response.RetrieveAPIResponse;

public class ApiTest {
	public static final String HOST="http://172.16.37.77:8001";
	public static final String CHAR_SET="utf-8";
	public static final Integer TIMEOUT=3000;
	KongAdminClient client;
	
	@Test
	public void RetrieveAPI() {
		client = KongAdminDefaultClient.Build(HOST, CHAR_SET, TIMEOUT);
		RetrieveAPIRequest request = new RetrieveAPIRequest();
		RetrieveAPIRequest error_request = new RetrieveAPIRequest();
		try {
			RetrieveAPIResponse response = client.execute(request,"test");
			RetrieveAPIResponse error_response = client.execute(error_request,"cb63f229-60c2-4bb6-8d34");
			try {
				System.out.println(response.getBody());
				Assert.assertEquals(200L, response.getResponseStatusCode().longValue());
				Assert.assertEquals(60000L, response.getAPIDetailModel().getUpstream_read_timeout().longValue());
				response.close();
				
				System.out.println(error_response.getBody());
				Assert.assertNotEquals(200L, error_response.getResponseStatusCode().longValue());
				error_response.close();
				
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (KongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void DeleteAPI() {
		client = KongAdminDefaultClient.Build(HOST, CHAR_SET, TIMEOUT);
		
		
	}
}
