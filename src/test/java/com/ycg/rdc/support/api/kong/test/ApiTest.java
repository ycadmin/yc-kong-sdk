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
	KongAdminClient client = KongAdminDefaultClient.Build("http://172.16.37.77:8001", "utf-8", 3000);
	
	@Test
	public void RetrieveAPI() {
		RetrieveAPIRequest request = new RetrieveAPIRequest();
		try {
			RetrieveAPIResponse response = client.execute(request,"cb63f229-60c2-4bb6-8d34-ef8342e0d6c9");
			try {
				System.out.println(response.getBody());
				Assert.assertEquals(200L, response.getResponseStatusCode().longValue());
				Assert.assertEquals(60000L, response.getAPIDetailModel().getUpstream_read_timeout().longValue());
				response.close();
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
}
