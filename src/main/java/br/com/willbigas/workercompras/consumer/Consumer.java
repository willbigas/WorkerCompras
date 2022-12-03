package br.com.willbigas.workercompras.consumer;

import br.com.willbigas.workercompras.model.Pedido;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Consumer {

	private final ObjectMapper mapper;

	@RabbitListener(queues = {"${queue_name}"})
	public void consumer(@Payload Message message) throws IOException {
		Pedido pedido = mapper.readValue(message.getBody(), Pedido.class);
		System.out.println("Mensagem recebida - Worker Compras -> "  + pedido);
	}
}
