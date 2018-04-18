package com.ycg.rdc.support.api.kong;

import java.util.HashMap;

public abstract class KongRequest<T extends KongResponse> {
	
	private String method;
	public HashMap<String, Object> params;
	private String requestPath;
	private int timeout;
	private String contentType;
	private String charset;
	T resp;
	
	public abstract void setRelativeUriPath(String path);
	
	public T getKongResponse(){
		return resp;
	}
	
	public void setKongResponse(T t){
		resp = t;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getRequestPath() {
		return requestPath;
	}
	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	public abstract String getParamsString();
	
	public abstract String getJSONParamsString();
}
