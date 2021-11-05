package com.ribastore.delivery.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {

	private Long pedidoId;
	
	private LocalDate dataDaEntrega;
	
	private String nomeDoPersonagem;
	
	private String mundoPersonagem;
	
}
