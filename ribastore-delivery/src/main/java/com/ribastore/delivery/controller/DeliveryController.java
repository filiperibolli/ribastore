package com.ribastore.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ribastore.delivery.dto.DeliveryDTO;
import com.ribastore.delivery.service.DeliveryService;

@RestController
@RequestMapping("delivery")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public Long registraPedido(@RequestBody DeliveryDTO deliveryDTO) {
		return deliveryService.registraPedido(deliveryDTO);
	}
	
}
