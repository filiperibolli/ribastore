package com.ribastore.loja.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ribastore.loja.client.DeliveryClient;
import com.ribastore.loja.client.EstoqueClient;
import com.ribastore.loja.dto.CompraDTO;
import com.ribastore.loja.dto.DeliveryDTO;
import com.ribastore.loja.dto.InfoPedidoDTO;
import com.ribastore.loja.enumerate.CompraState;
import com.ribastore.loja.model.Compra;
import com.ribastore.loja.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private EstoqueClient estoqueClient;
	
	@Autowired
	private DeliveryClient deliveryClient;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@HystrixCommand(threadPoolKey = "getByIdThreadPool")
	public Compra getById(Long id) {
		return compraRepository.findById(id).orElse(new Compra());
	}
	
	public Compra reprocessaCompra(Long id) {
		return null;
	}
	
	public Compra cancelaCompra(Long id) {
		return null;
	}
	
	@HystrixCommand(fallbackMethod = "realizaCompraFallback",
			threadPoolKey = "realizaCompraThreadPool")
	public Compra realizaCompra(CompraDTO compra) {
		Compra compraSalva = new Compra();
		compraSalva.setState(CompraState.RECEBIDO);
		compraSalva.setNomeDoPersonagem(compra.getNomeDoPersonagem());
		compraSalva.setMundoPersonagem(compra.getMundoPersonagem());
		compraRepository.save(compraSalva);
		compra.setCompraId(compraSalva.getId());
		
		InfoPedidoDTO pedido = estoqueClient.realizaPedido(compra.getItens());
		compraSalva.setState(CompraState.PEDIDO_REALIZADO);
		compraSalva.setPedidoId(pedido.getId());
		compraRepository.save(compraSalva);
		
		DeliveryDTO entregaDto = new DeliveryDTO();
		entregaDto.setPedidoId(pedido.getId());
		entregaDto.setDataDaEntrega(LocalDate.now());
		entregaDto.setNomeDoPersonagem(compra.getNomeDoPersonagem());
		entregaDto.setMundoPersonagem(compra.getMundoPersonagem());
		
		Long voucher = deliveryClient.registraPedido(entregaDto);
		compraSalva.setState(CompraState.RESERVA_ENTREGA_REALIZADA);
		compraSalva.setVoucher(voucher);
		compraSalva.setDataParaEntrega(LocalDate.now());
		compraRepository.save(compraSalva);
		
		return compraSalva;
	}

	public Compra realizaCompraFallback(CompraDTO compra) {
		if(compra.getCompraId() != null) {
			return compraRepository.findById(compra.getCompraId()).get();
		}
		
		Compra compraFallback = new Compra();
		compraFallback.setNomeDoPersonagem(compra.getNomeDoPersonagem());
		compraFallback.setMundoPersonagem(compra.getMundoPersonagem());
		return compraFallback;
	}

}

