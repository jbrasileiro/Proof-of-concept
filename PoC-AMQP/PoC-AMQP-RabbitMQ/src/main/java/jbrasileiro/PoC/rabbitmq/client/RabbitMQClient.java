package jbrasileiro.PoC.rabbitmq.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import jbrasileiro.PoC.rabbitmq.beans.QueueProperties;

public class RabbitMQClient {

	private QueueProperties queueProperties;
	private ConnectionFactory connectionFactory;

	public RabbitMQClient(
		ConnectionFactory connectionFactory,
		QueueProperties queueProperties) {
		this.connectionFactory = connectionFactory;
		this.queueProperties = queueProperties;
	}

	public boolean sendMessage(
		String message) {
		try (Channel channel = createChannel(queueProperties, createConnection())) {
			byte[] bytes = message.getBytes("UTF-8");
			String exchange = queueProperties.getExchange();
			String key = queueProperties.getKey();
			channel.basicPublish(exchange, key, null, bytes);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Channel createChannel(
		QueueProperties queueProperties,
		Connection connection) {
		Channel channel = null;
		try {
			channel = connection.createChannel();
			channel.exchangeDeclare(queueProperties.getExchange(), "topic", true);
			channel.queueDeclare(queueProperties.getQueue(), true, false, false, null);
			channel.queueBind(queueProperties.getQueue(), queueProperties.getExchange(),
				queueProperties.getKey());
			return channel;
		} catch (IOException exception) {
			if (channel != null) {
				try {
					channel.close();
				} catch (IOException
					| TimeoutException e) {
					throw new RuntimeException("Unable to close Channel connection.", e);
				}
			}
			throw new RuntimeException("Unable to create Channel.", exception);
		}
	}

	private Connection createConnection() {
		try {
			return connectionFactory.newConnection();
		} catch (Exception e) {
			throw new RuntimeException("Unable to create Connection.", e);
		}
	}
}
