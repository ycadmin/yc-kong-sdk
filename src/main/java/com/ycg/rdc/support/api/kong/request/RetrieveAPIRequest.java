package com.ycg.rdc.support.api.kong.request;

import com.alibaba.fastjson.JSON;
import com.ycg.rdc.support.api.kong.KongRequest;
import com.ycg.rdc.support.api.kong.UriTool;
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
	public RetrieveAPIResponse getKongResponse() {
		if(super.getKongResponse() == null) {
			super.setKongResponse(new RetrieveAPIResponse());
		}
		return super.getKongResponse();
	}

	@Override
	public String getParamsString() {
		if(super.params!=null){
			return UriTool.MapToURIParam(super.params);
		} else {
			 return null;
		}
	}

	@Override
	public String getJSONParamsString() {
		if(super.params!=null){
			return JSON.toJSONString(super.params);
		}
		return null;
	}

}
