package com.ribastore.delivery.service;

import org.springframework.stereotype.Service;
import com.ribastore.delivery.dto.DeliveryDTO;

@Service
public interface DeliveryService {

	Long registraPedido(DeliveryDTO deliveryDTO);

}
