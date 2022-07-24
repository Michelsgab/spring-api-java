package com.algaworks.algalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.exception.NegocioException;
import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cliente save(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("E-mail já cadastrado.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}
	
}
