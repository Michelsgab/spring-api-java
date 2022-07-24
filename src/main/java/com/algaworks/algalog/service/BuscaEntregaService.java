package com.algaworks.algalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.exception.NotFoundException;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;

	public Entrega find(Long id) {
		return entregaRepository.findById(id).orElseThrow(() -> new NotFoundException("Entrega não encontrada"));
	}

}
