package com.algaworks.algalog.dto.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EntregaRequest {

	@Valid
	@NotNull
	private ClienteIdRequest cliente;
	
	@Valid
	@NotNull
	private DestinatarioRequest destinatario;
	
	@NotNull
	private BigDecimal taxa;

	public ClienteIdRequest getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdRequest cliente) {
		this.cliente = cliente;
	}

	public DestinatarioRequest getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(DestinatarioRequest destinatario) {
		this.destinatario = destinatario;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	
}
