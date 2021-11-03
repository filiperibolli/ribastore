package com.ribastore.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ribastore.loja.dto.InfoPedidoDTO;
import com.ribastore.loja.dto.ItemDaCompraDTO;


@FeignClient("estoque")
public interface EstoqueClient {

	@RequestMapping(method = RequestMethod.POST, value="/pedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);

}
