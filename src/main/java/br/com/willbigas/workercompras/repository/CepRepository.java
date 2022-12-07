package br.com.willbigas.workercompras.repository;

import br.com.willbigas.workercompras.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep" ,  url = "${viacep}")
public interface CepRepository {

	@GetMapping("/{cep}/json/")
	Endereco buscarPorCEP(@PathVariable("cep") String cep);
}
