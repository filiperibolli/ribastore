package com.ribastore.estoque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

	private String moeda;
	
	private String jogo;
	
	private long quantidade;
}
