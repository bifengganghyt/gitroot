package com.kedacom.tz.birdie.core.config;

public class RedisConfig {

	private String host;
	private int port;
	private String password;
	private int timeout;
	
	public RedisConfig() {}
	
	public RedisConfig(String host, int port, String password, int timeout) {
		this.host = host ;
		this.port = port ;
		this.password = password ;
		this.timeout = timeout ;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
