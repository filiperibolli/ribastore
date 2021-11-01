package com.ribastore.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ribastore.estoque.dto.ItemDoPedidoDTO;
import com.ribastore.estoque.model.Pedido;

@Service
public interface PedidoService {

	Pedido realizaPedido(List<ItemDoPedidoDTO> produtos);

	Pedido getPedidoPorId(Long id);

}
