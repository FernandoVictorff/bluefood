package br.com.fernando.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.bluefood.domain.cliente.Cliente;
import br.com.fernando.bluefood.domain.cliente.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void saveCLiente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	
	
}
