package jbrasileiro.PoC.samqp;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMQClient {

	public boolean sendMessage(
		String message) {
		try {
			CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
			AmqpAdmin admin = new RabbitAdmin(connectionFactory);
			admin.declareQueue(new Queue("myqueue"));
			AmqpTemplate template = new RabbitTemplate(connectionFactory);
			template.convertAndSend("myqueue", "foo");
			template.receiveAndConvert("myqueue");
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
