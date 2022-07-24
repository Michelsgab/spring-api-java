package com.algaworks.algalog.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.StatusEntrega;
import com.algaworks.algalog.repository.EntregaRepository;

@Service
public class EntregaService {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega request(Entrega entrega) {
		Cliente cliente = clienteService.findById(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}

}
