package com.ribastore.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribastore.delivery.dto.DeliveryDTO;
import com.ribastore.delivery.model.Entrega;
import com.ribastore.delivery.repository.DeliveryRepository;
import com.ribastore.delivery.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository repository;
	
	@Override
	public Long registraPedido(DeliveryDTO deliveryDTO) {

		Entrega entrega = new Entrega();
		entrega.setPedidoId(deliveryDTO.getPedidoId());
		entrega.setDataDaEntrega(deliveryDTO.getDataDaEntrega());
		entrega.setNomeDoPersonagem(deliveryDTO.getNomeDoPersonagem());
		entrega.setMundoPersonagem(deliveryDTO.getMundoPersonagem());
		
		entrega = repository.save(entrega);
		
		return entrega.getId();
	}

}
