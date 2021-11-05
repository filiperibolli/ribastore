package com.ribastore.delivery.controller;

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
import com.ribastore.delivery.service.DeliveryService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DeliveryControllerTest {

    @InjectMocks
    private DeliveryController deliveryController;
    
    @Mock
    private DeliveryService deliveryService;
    
    @Test
    public void devolveIDPedidoRealizado() throws Exception {
    	
    	DeliveryDTO deliveryDTO = new DeliveryDTO(1L, null, "Riba Teste", "Riba World");
    	
    	when(deliveryService.registraPedido(any(DeliveryDTO.class)))
    					.thenReturn(1L);
    	
    	Long idPedido = deliveryService.registraPedido(deliveryDTO);
    	
    	assertNotNull(idPedido);
    }
}
