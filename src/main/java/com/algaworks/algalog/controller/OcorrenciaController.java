package com.algaworks.algalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.assembler.OcorrenciaAssembler;
import com.algaworks.algalog.dto.OcorrenciaDTO;
import com.algaworks.algalog.dto.request.OcorrenciaRequest;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Ocorrencia;
import com.algaworks.algalog.service.BuscaEntregaService;
import com.algaworks.algalog.service.OcorrenciaService;

@RestController
@RequestMapping("/entregas/{id}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private BuscaEntregaService buscaEntregaService;

	@Autowired
	private OcorrenciaService ocorrenciaService;

	@Autowired
	private OcorrenciaAssembler ocorrenciaAssembler;

	@GetMapping
	public List<OcorrenciaDTO> findById(@PathVariable Long id) {
		Entrega entrega = buscaEntregaService.find(id);

		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO record(@PathVariable Long id, @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest) {
		Ocorrencia ocorrenciaRegistrada = ocorrenciaService.record(id, ocorrenciaRequest.getDescricao());

		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}

}
