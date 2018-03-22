package com.ycg.rdc.support.api.kong.response;

import com.alibaba.fastjson.JSON;
import com.ycg.rdc.support.api.kong.KongResponse;
import com.ycg.rdc.support.api.kong.model.APIDetailModel;

public class RetrieveAPIResponse extends KongResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6688111293487784657L;
	
	public RetrieveAPIResponse(){
		super();
	}
	
	public APIDetailModel getAPIDetailModel() {
		return JSON.parseObject(super.getBody(), APIDetailModel.class);
	}
}
