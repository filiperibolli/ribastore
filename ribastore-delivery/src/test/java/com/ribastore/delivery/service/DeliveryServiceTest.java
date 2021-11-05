package com.ribastore.delivery.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.ribastore.delivery.dto.DeliveryDTO;
import com.ribastore.delivery.model.Entrega;
import com.ribastore.delivery.repository.DeliveryRepository;
import com.ribastore.delivery.service.impl.DeliveryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DeliveryServiceTest {

	@InjectMocks
	DeliveryServiceImpl service;
	
	@Mock
	DeliveryRepository repository;

	@Test
	public void deveRegistrarPedidoRecebendoObjetoDelivery(){
		
		DeliveryDTO deliveryDTO = new DeliveryDTO(1L, null, "Riba Teste", "Riba World");
		Entrega entrega = new Entrega(1L, 1L, null, "", "");
		when(repository.save(any(Entrega.class))).thenReturn(entrega);
		
		Long entregaId = service.registraPedido(deliveryDTO);
		
		assertNotNull(entregaId);
		
	}
}
