package com.ribastore.delivery.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ribastore.delivery.dto.DeliveryDTO;
import com.ribastore.delivery.service.DeliveryService;

@RunWith(SpringRunner.class)
@WebMvcTest(DeliveryController.class)
public class DeliveryControllerWebTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DeliveryService service;
    
    @Test
    public void criaPedidoAposReceberDadosObjetoDelivery()
      throws Exception {
        
    	DeliveryDTO deliveryDTO = new DeliveryDTO(1L, null, "Riba Teste", "Riba World");
    	
    	when(service.registraPedido(any(DeliveryDTO.class)))
    					.thenReturn(1L);

        mvc.perform(post("/delivery")
          .content(asJsonString(deliveryDTO))
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isCreated());
    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
