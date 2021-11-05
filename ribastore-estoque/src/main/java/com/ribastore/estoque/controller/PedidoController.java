package com.ribastore.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ribastore.estoque.dto.ItemDoPedidoDTO;
import com.ribastore.estoque.model.Pedido;
import com.ribastore.estoque.service.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
		return pedidoService.realizaPedido(produtos);
	}
	
	@RequestMapping("/{id}")
	public Pedido getPedidoPorId(@PathVariable Long id) {
		return pedidoService.getPedidoPorId(id);
	}
}
