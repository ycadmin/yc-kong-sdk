package com.ycg.rdc.support.api.kong;

import java.util.HashMap;

public abstract class KongRequest<T extends KongResponse> {
	
	String method;
	HashMap<String, Object> params;
	String requestPath;
	int timeout;
	String contentType;
	String charset;
	T resp;
	
	public abstract void setRelativeUriPath(String path);
	
	public T getResponse(){
		return resp;
	}
	
	public void setResponse(T t){
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
}
