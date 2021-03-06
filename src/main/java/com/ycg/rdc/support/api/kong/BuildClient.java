package com.ycg.rdc.support.api.kong;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class BuildClient {
	private static KongAdminDefaultClient client;
	private static CloseableHttpClient httpClient;
	static final int DEFAULT_MAX_TOTAL_CONNS = 1000;
	static final int DEFAULT_MAX_PER_ROUTE = 200;

	public static KongAdminDefaultClient Build(String server, String charset, int tomeout) {
		if (client == null) {
			synchronized (KongAdminDefaultClient.class) {
				if (client == null) {
					client = new KongAdminDefaultClient(server, charset, tomeout);
					PoolingHttpClientConnectionManager hcm = new PoolingHttpClientConnectionManager();
					hcm.setMaxTotal(DEFAULT_MAX_TOTAL_CONNS);
					hcm.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
					httpClient = HttpClients.custom().setConnectionManager(hcm)
							.build();
					client.setHttpClient(httpClient);
				}
			}
		}
		return client;
	}
}
