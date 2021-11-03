package com.ribastore.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ribastore.loja.dto.DeliveryDTO;


@FeignClient("delivery")
public interface DeliveryClient {
	
	@RequestMapping(method = RequestMethod.POST, value="/delivery")
	public Long registraPedido(DeliveryDTO deliveryDTO);
}
