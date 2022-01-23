package br.com.fernando.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.bluefood.domain.cliente.Cliente;
import br.com.fernando.bluefood.domain.cliente.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void saveCLiente(Cliente cliente) throws ValidationException{
		
		if(!validateEmail(cliente.getEmail(), cliente.getId())) {
			throw new ValidationException("O email está duplicado");
		}
		
		if(cliente.getId() != null) {
			Cliente clienteDb = clienteRepository.findById(cliente.getId()).orElseThrow();
			cliente.setSenha(clienteDb.getSenha());
		} else {
			cliente.encryptPassword();
		}
		
		clienteRepository.save(cliente);
	}
	
	private boolean validateEmail(String email, Integer id) {
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if(cliente != null) {
			
			if(id == null) {
				return false;
			}
			
			if(!cliente.getId().equals(id)) {
				return false;
			}			
		}
		
		return true;		
	}
	
}
