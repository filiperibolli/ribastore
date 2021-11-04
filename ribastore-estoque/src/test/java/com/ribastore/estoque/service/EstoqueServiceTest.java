package com.ribastore.estoque.service;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.ribastore.estoque.model.Produto;
import com.ribastore.estoque.repository.EstoqueRepository;
import com.ribastore.estoque.service.impl.EstoqueServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EstoqueServiceTest {

	
	@InjectMocks
	EstoqueServiceImpl service;
	
	@Mock
	EstoqueRepository repository;
	
	@Test
	public void retornaListaComTodosOsProdutosCadastrados() {
		
    	ArrayList<Produto> produtosController = new ArrayList<Produto>();
    	Produto tibiaCoin = new Produto(1L, "tibia coin", "tibia", 100L);
    	produtosController.add(tibiaCoin);
		
		when(repository.findAll()).thenReturn(produtosController);
		
		List<Produto> produtos = service.getEstoque();
		
		assertFalse(produtos.isEmpty());

	}
	
	@Test
	public void retornaProdutoRelacionadoAoParametroJogo() {
		
    	Produto tibiaCoin = new Produto(1L, "tibia coin", "tibia", 100L);

		when(repository.findByJogo(any(String.class)))
										.thenReturn(tibiaCoin);
		
		Produto produto = service.getEstoquePorJogo("tibia");
		
		assertNotNull(produto);

	}
}
