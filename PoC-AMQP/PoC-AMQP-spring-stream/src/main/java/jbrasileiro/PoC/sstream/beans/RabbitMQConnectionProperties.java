package jbrasileiro.PoC.sstream.beans;

public class RabbitMQConnectionProperties {

	private String host;
	private String user;
	private String password;
	private int port;
	private String virtualHost;

	public void setHost(
		String host) {
		this.host = host;
	}

	public void setUser(
		String user) {
		this.user = user;
	}

	public void setPassword(
		String password) {
		this.password = password;
	}

	public void setPort(
		int port) {
		this.port = port;
	}

	public void setVirtualHost(
		String virtualHost) {
		this.virtualHost = virtualHost;
	}

	public String getHost() {
		return host;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public int getPort() {
		return port;
	}

	public String getVirtualHost() {
		return virtualHost;
	}
}
