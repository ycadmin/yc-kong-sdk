package com.ycg.rdc.support.api.kong;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UriTool {
	public static String MapToURIParam(Map<String, Object> mapParam) {
		final Wrapper result = new Wrapper();
		if (mapParam != null && !mapParam.isEmpty()) {
			mapParam.forEach((k, v) -> {
				result.inner += "&" + k + "=" + v;
			});
			result.inner = result.inner.substring(1);
		}
		return result.inner;
	}

	public static void main(String[] args) {
		HashMap<String, Object> param = new HashMap<>();
		param.put("name", "张三");
		param.put("id", "456");
		param.put("ctime", new Date());
		param.put("index", 123L);
		System.out.println(MapToURIParam(param));
	}

	public static class Wrapper {
		public String inner = "";
	}
}
