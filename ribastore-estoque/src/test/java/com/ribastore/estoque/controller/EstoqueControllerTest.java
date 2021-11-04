package com.ribastore.estoque.controller;

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
import com.ribastore.estoque.service.EstoqueService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EstoqueControllerTest {
	
    @InjectMocks
    private EstoqueController estoqueController;
    
    @Mock
    private EstoqueService estoqueService;
    
    @Test
    public void retornaListaDeProdutosContendoTodoOEstoque() throws Exception {
    	
    	ArrayList<Produto> produtosController = new ArrayList<Produto>();
    	Produto tibiaCoin = new Produto(1L, "tibia coin", "tibia", 100L);
    	produtosController.add(tibiaCoin);
    	
    	when(estoqueService.getEstoque())
    					.thenReturn(produtosController);
    	
    	List<Produto> produtos = estoqueController.getEstoque();
    	
    	assertFalse(produtos.isEmpty());
    }
    
    @Test
    public void retornaUmProdutoRecebendoUmJogoComoParametro() throws Exception {
    	
    	ArrayList<Produto> produtosController = new ArrayList<Produto>();
    	Produto tibiaCoin = new Produto(1L, "tibia coin", "tibia", 100L);
    	produtosController.add(tibiaCoin);
    	
    	when(estoqueService.getEstoquePorJogo(any(String.class)))
    					.thenReturn(tibiaCoin);
    	
    	Produto produto = estoqueController.getEstoquePorJogo("tibia");
    	
    	assertNotNull(produto);
    }

}
