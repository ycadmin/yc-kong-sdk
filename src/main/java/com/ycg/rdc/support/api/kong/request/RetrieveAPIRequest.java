package com.ycg.rdc.support.api.kong.request;

import com.ycg.rdc.support.api.kong.KongRequest;
import com.ycg.rdc.support.api.kong.response.RetrieveAPIResponse;

public class RetrieveAPIRequest extends KongRequest<RetrieveAPIResponse> {

	public RetrieveAPIRequest() {
		super.setRequestPath("apis");
		super.setMethod("GET");
	}
	
	@Override
	public void setRelativeUriPath(String path) {
		super.setRequestPath(path);
	}

	@Override
	public RetrieveAPIResponse getResponse() {
		if(super.getResponse() == null) {
			super.setResponse(new RetrieveAPIResponse());
		}
		return super.getResponse();
	}

	@Override
	public String getParamsString() {
		return null;
	}

}
