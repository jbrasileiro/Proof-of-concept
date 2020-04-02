package jbrasileiro.PoC.sstream.beans;

public class QueueProperties {

	private String queue;
	private String exchange;
	private String key;
	private String deadLetterExchange;

	public void setQueue(
		String queue) {
		this.queue = queue;
	}

	public void setExchange(
		String exchange) {
		this.exchange = exchange;
	}

	public void setKey(
		String key) {
		this.key = key;
	}

	public void setDeadLetterExchange(
		String deadLetterExchange) {
		this.deadLetterExchange = deadLetterExchange;
	}

	public String getQueue() {
		return queue;
	}

	public String getExchange() {
		return exchange;
	}

	public String getKey() {
		return key;
	}

	public String getDeadLetterExchange() {
		return deadLetterExchange;
	}
}
