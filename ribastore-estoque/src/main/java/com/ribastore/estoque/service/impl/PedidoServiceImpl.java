package com.ribastore.estoque.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribastore.estoque.dto.ItemDoPedidoDTO;
import com.ribastore.estoque.model.Pedido;
import com.ribastore.estoque.model.PedidoItem;
import com.ribastore.estoque.model.Produto;
import com.ribastore.estoque.repository.EstoqueRepository;
import com.ribastore.estoque.repository.PedidoRepository;
import com.ribastore.estoque.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;

	public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
		
		if(itens == null) {
			return null;
		}
		
		List<PedidoItem> pedidoItens = toPedidoItem(itens);
		Pedido pedido = new Pedido(pedidoItens);
		return pedidoRepository.save(pedido);
	}
	
	public Pedido getPedidoPorId(Long id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {
		
		List<Long> idsProdutos = itens
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Produto> produtosDoPedido = estoqueRepository.findByIdIn(idsProdutos);
		
		List<PedidoItem> pedidoItens = itens
			.stream()
			.map(item -> {
				Produto produto = produtosDoPedido
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				PedidoItem pedidoItem = new PedidoItem();
				pedidoItem.setProduto(produto);
				pedidoItem.setQuantidade(item.getQuantidade());
				return pedidoItem;
			})
			.collect(Collectors.toList());
		return pedidoItens;
	}

	
	

}
