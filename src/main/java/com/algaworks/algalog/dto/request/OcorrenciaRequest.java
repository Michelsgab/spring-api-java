package com.algaworks.algalog.dto.request;

import javax.validation.constraints.NotBlank;

public class OcorrenciaRequest {

	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
