package br.com.willbigas.workercompras.service;

import br.com.willbigas.workercompras.model.Endereco;
import br.com.willbigas.workercompras.repository.CepRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CEPService {

	private final CepRepository cepRepository;

	public void buscarCEP(String cep) {
		Endereco endereco = cepRepository.buscarPorCEP(cep);
		log.info(endereco.toString());
	}

}
