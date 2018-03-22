package com.ycg.rdc.support.api.kong;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

public class KongAdminDefaultClient implements KongAdminClient {

	private String server = "http://localhost:8080";
	private String charset = "utf-8";
	private int timeout = 30000;
	private CloseableHttpClient httpClient;

	public KongAdminDefaultClient(String server) {
		this.server = server;
	}

	public KongAdminDefaultClient(String server, int timeout) {
		this.server = server;
		this.timeout = timeout;
	}

	public KongAdminDefaultClient(String server, String charset) {
		this.server = server;
		this.charset = charset;
	}

	public KongAdminDefaultClient(String server, String charset, int timeout) {
		this.server = server;
		this.charset = charset;
		this.timeout = timeout;
	}

	public static KongAdminDefaultClient Build(String server, String charset, int timeout) {
		return BuildClient.Build(server, charset, timeout);
	}

	@Override
	public <T extends KongResponse> T execute(KongRequest<T> request)
			throws KongException {
		return execute(request, null, null);
	}

	@Override
	public <T extends KongResponse> T execute(KongRequest<T> request,
			HashMap<String, Object> param) throws KongException {
		return execute(request, param, null);
	}

	@Override
	public <T extends KongResponse> T execute(KongRequest<T> request,
			String resourceParam) throws KongException {
		return execute(request, null, resourceParam);
	}

	@Override
	public <T extends KongResponse> T execute(KongRequest<T> request,
			HashMap<String, Object> param, String resourceParam)
			throws KongException {
		if (request == null) {
			throw new KongException();
		}
		switch (request.getMethod()) {
		case "POST":
			return doPost(request, param, resourceParam);
		case "GET":
			return doGet(request, resourceParam);
		case "DELETE":
			return doDelete(request, param, resourceParam);
		case "PUT":
			return doPut(request, param, resourceParam);
		case "PATCH":
			return doPatch(request, param, resourceParam);
		default:
			return doPost(request, param, resourceParam);
		}
	}

	private <T extends KongResponse> T doPost(KongRequest<T> request,
			HashMap<String, Object> param, String resourceParam)
			throws KongException {
		try{
			
		}
		catch (Exception protocolEx) {
			throw new KongException();
		}
		return null;
	}

	private <T extends KongResponse> T doGet(KongRequest<T> request,
			String resourceParam) throws KongException {
		try {
			String uri = server + "/" + request.getRequestPath();
			if (resourceParam != null && !resourceParam.isEmpty())
				uri = uri + "/" + resourceParam;
			if(request.getParamsString()!=null && !request.getParamsString().isEmpty())
				uri = uri + "?" + request.getParamsString();
			HttpGet httpget = new HttpGet(uri);
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(timeout).setSocketTimeout(timeout)
					.build();
			httpget.setConfig(requestConfig);
			httpget.addHeader("Content-Type", ContentType.APPLICATION_JSON
					.withCharset(charset).toString());
			HttpClientContext context = HttpClientContext.create();
			request.getResponse().setResponse((CloseableHttpResponse) httpClient
					.execute(httpget, context));
			return request.getResponse();
		} catch (ClientProtocolException protocolEx) {
			throw new KongException();
		} catch (IOException respIoEx) {
			throw new KongException();
		} finally {
			/*try {
				httpClient.close();
			} catch (IOException clientIoEx) {
				throw new KongException();
			}*/
		}
	}

	private <T extends KongResponse> T doDelete(KongRequest<T> request,
			HashMap<String, Object> param, String resourceParam)
			throws KongException {
		return null;
	}

	private <T extends KongResponse> T doPut(KongRequest<T> request,
			HashMap<String, Object> param, String resourceParam)
			throws KongException {
		return null;
	}

	private <T extends KongResponse> T doPatch(KongRequest<T> request,
			HashMap<String, Object> param, String resourceParam)
			throws KongException {
		return null;
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}
	
	public void close() throws KongException{
		try {
			this.httpClient.close();
		} catch (IOException e) {
			throw new KongException(e);
		}
	}
}
