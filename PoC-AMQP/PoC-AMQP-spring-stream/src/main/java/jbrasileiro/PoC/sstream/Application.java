package jbrasileiro.PoC.sstream;

import javax.annotation.processing.Processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class Application {

	public static void main(
		String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public LogMessage enrichLogMessage(
		LogMessage log) {
		return new LogMessage(String.format("[1]: %s", log.getMessage()));
	}
}
