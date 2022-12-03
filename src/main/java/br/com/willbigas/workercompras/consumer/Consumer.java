package br.com.willbigas.workercompras.consumer;

import br.com.willbigas.workercompras.model.Pedido;
import br.com.willbigas.workercompras.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Consumer {

	private final ObjectMapper mapper;
	private final EmailService emailService;

	@RabbitListener(queues = {"${queue_name}"})
	public void consumer(@Payload Message message) throws IOException {
		Pedido pedido = mapper.readValue(message.getBody(), Pedido.class);
		System.out.println("Mensagem recebida - Worker Compras -> "  + pedido);
		emailService.notificarCliente("williambmauro@hotmail.com");
	}
}
