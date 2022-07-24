package com.algaworks.algalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.assembler.EntregaAssembler;
import com.algaworks.algalog.dto.EntregaDTO;
import com.algaworks.algalog.dto.request.EntregaRequest;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.ValidationGroups;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.EntregaService;
import com.algaworks.algalog.service.FinalizaEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private FinalizaEntregaService finalizaEntregaService;

	@Autowired
	private EntregaAssembler entregaAssembler;

	@GetMapping
	public List<EntregaDTO> findAll() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntregaDTO> findById(@PathVariable Long id) {
		return entregaRepository.findById(id).map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO request(@Validated(ValidationGroups.ClienteId.class) @RequestBody EntregaRequest entregaRequest) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaRequest);
		Entrega entregaSolicitada = entregaService.request(novaEntrega);

		return entregaAssembler.toModel(entregaService.request(entregaSolicitada));
	}
	
	@PutMapping("/{id}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long id) {
		finalizaEntregaService.finalizar(id);
	}

}
