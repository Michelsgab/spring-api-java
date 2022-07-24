package com.algaworks.algalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.repository.EntregaRepository;

@Service
public class FinalizaEntregaService {

	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public void finalizar(Long id) {
		Entrega entrega = buscaEntregaService.find(id);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
	
}
