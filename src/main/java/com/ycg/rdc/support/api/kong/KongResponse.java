package com.ycg.rdc.support.api.kong;

import java.io.IOException;
import java.io.Serializable;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

public abstract class KongResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4689696723017993429L;
	private CloseableHttpResponse response;
	private String body;
	
	public void setResponse(CloseableHttpResponse response) {
		this.response = response;
	}

	public Integer getResponseStatusCode() {
		if (response != null) {
			return response.getStatusLine().getStatusCode();
		}
		return null;
	}
	
	public void close() throws IOException{
		response.close();
	}

	public String getBody() {
		if(body==null || body.isEmpty()) {
			if (response != null) {
				try {
					body = EntityUtils.toString(response.getEntity());
				} catch (ParseException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return body;
	}
}
