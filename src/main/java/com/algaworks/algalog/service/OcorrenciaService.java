package com.algaworks.algalog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Ocorrencia;

@Service
public class OcorrenciaService {

	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia record(Long id, String descricao) {
		Entrega entrega = buscaEntregaService.find(id);
		
		return entrega.addOcorrencia(descricao);
	}
	
}
