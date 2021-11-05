package com.ribastore.loja.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.ribastore.loja.model.Compra;
import com.ribastore.loja.service.CompraService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CompraControllerTest {

    @InjectMocks
    private CompraController compraController;
    
    @Mock
    private CompraService service;
    
    @Test
    public void retornaUmaCompraPassandoUmIdExistente() throws Exception {
    	
    	Compra compraService = new Compra();
    	
    	when(service.getById(any(Long.class)))
    					.thenReturn(compraService);
    	
    	Compra compra = compraController.getById(1L);
    	
    	assertNotNull(compra);
    }
}
