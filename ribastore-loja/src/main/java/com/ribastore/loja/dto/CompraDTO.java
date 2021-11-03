package com.ribastore.loja.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CompraDTO {

	@JsonIgnore
	private Long compraId;
	
	private List<ItemDaCompraDTO> itens;
	
	private String nomeDoPersonagem;
	
	private String mundoPersonagem;
	
}
