package com.ycg.rdc.support.api.kong.model;
import java.io.Serializable;
import java.util.Date;


public class APIDetailModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7760128571250938601L;
	private Date created_at;
	private String[] hosts;
	private Boolean http_if_terminated;
	private Boolean https_only;
	private String id;
	private String name;
	private Boolean preserve_host;
	private Integer retries;
	private Boolean strip_uri;
	private Integer upstream_connect_timeout;
	private Integer upstream_read_timeout;
	private Integer upstream_send_timeout;
	private String upstream_url;
	
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String[] getHosts() {
		return hosts;
	}
	public void setHosts(String[] hosts) {
		this.hosts = hosts;
	}
	public Boolean getHttp_if_terminated() {
		return http_if_terminated;
	}
	public void setHttp_if_terminated(Boolean http_if_terminated) {
		this.http_if_terminated = http_if_terminated;
	}
	public Boolean getHttps_only() {
		return https_only;
	}
	public void setHttps_only(Boolean https_only) {
		this.https_only = https_only;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getPreserve_host() {
		return preserve_host;
	}
	public void setPreserve_host(Boolean preserve_host) {
		this.preserve_host = preserve_host;
	}
	public Integer getRetries() {
		return retries;
	}
	public void setRetries(Integer retries) {
		this.retries = retries;
	}
	public Boolean getStrip_uri() {
		return strip_uri;
	}
	public void setStrip_uri(Boolean strip_uri) {
		this.strip_uri = strip_uri;
	}
	public Integer getUpstream_connect_timeout() {
		return upstream_connect_timeout;
	}
	public void setUpstream_connect_timeout(Integer upstream_connect_timeout) {
		this.upstream_connect_timeout = upstream_connect_timeout;
	}
	public Integer getUpstream_read_timeout() {
		return upstream_read_timeout;
	}
	public void setUpstream_read_timeout(Integer upstream_read_timeout) {
		this.upstream_read_timeout = upstream_read_timeout;
	}
	public Integer getUpstream_send_timeout() {
		return upstream_send_timeout;
	}
	public void setUpstream_send_timeout(Integer upstream_send_timeout) {
		this.upstream_send_timeout = upstream_send_timeout;
	}
	public String getUpstream_url() {
		return upstream_url;
	}
	public void setUpstream_url(String upstream_url) {
		this.upstream_url = upstream_url;
	}
}
