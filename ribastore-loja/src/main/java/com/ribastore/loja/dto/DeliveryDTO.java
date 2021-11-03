package com.ribastore.loja.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DeliveryDTO {

	private Long pedidoId;
	
	private LocalDate dataDaEntrega;
	
	private String nomeDoPersonagem;
	
	private String mundoPersonagem;
	
}
