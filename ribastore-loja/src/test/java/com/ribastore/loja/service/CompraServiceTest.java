package com.ribastore.loja.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.ribastore.loja.model.Compra;
import com.ribastore.loja.repository.CompraRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CompraServiceTest {

	@InjectMocks
	CompraService service;
	
	@Mock
	CompraRepository repository;
	
	
	@Test
	public void retornaUmaCompraPassandoUmId() {
		
		Optional<Compra> compra = Optional.of(new Compra());
		
		when(repository.findById(any(Long.class))).thenReturn(compra);
		
		Compra compraService = service.getById(1L);
		
		assertNotNull(compraService);
		
	}
	
}
