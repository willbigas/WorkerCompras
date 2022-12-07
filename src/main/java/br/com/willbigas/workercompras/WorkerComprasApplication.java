package br.com.willbigas.workercompras;

import br.com.willbigas.workercompras.service.CEPService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableFeignClients
@EnableRabbit
@SpringBootApplication
public class WorkerComprasApplication {

	@Autowired
	private CEPService cepService;

	public static void main(String[] args) {
		SpringApplication.run(WorkerComprasApplication.class, args);
	}

	@Bean
	void teste() {
		cepService.buscarCEP("88133810");
	}
}
