package com.ribastore.estoque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDoPedidoDTO {
	
	private long id;
	
	private int quantidade;

}
