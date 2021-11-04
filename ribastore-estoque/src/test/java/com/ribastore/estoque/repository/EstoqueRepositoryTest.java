package com.ribastore.estoque.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ribastore.estoque.model.Produto;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EstoqueRepositoryTest {
	
	@Autowired
	EstoqueRepository repository;
	
    @Autowired
    private TestEntityManager entityManager;

	@Test
	public void deveRetornarUmProdutoNaoNulo() {
		
		Produto tibiaCoin = new Produto(null, "tibia coin", "tibia", 1000L);
	    entityManager.merge(tibiaCoin);
	    entityManager.flush();
	    
		String nomeDoJogo = "tibia";
		Produto produto = repository.findByJogo(nomeDoJogo);
		Assert.assertEquals(nomeDoJogo, produto.getJogo());
	}
	
	@Test
	public void deveRetornarUmProdutoRecebendoUmJogo() {
		
		entityManager.clear();
		Produto tibiaCoin = new Produto(null, "tibia coin", "tibia", 1000L);
	    entityManager.merge(tibiaCoin);
	    entityManager.flush();
	    
		String nomeDoJogo = "tibia";
		Produto produto = repository.findByJogo(nomeDoJogo);
		Assert.assertNotNull(produto);
	}

	@Test
	public void deveRetornarUmaListaDeProdutosNaoVazia() {
		
		Produto tibiaCoin = new Produto(null, "tibia coin", "tibia", 1000L);
		Produto muCoin = new Produto(null, "mu coin", "mu online", 2000L);
	    entityManager.merge(tibiaCoin);
	    entityManager.merge(muCoin);
	    entityManager.flush();
	    
	    ArrayList<Long> ids = new ArrayList<>();
	    ids.add(1L);
	    ids.add(2L);
	    ids.add(3L);
	    ids.add(4L);
	    
		List<Produto> produtos = repository.findByIdIn(ids);
		
		Assert.assertFalse(produtos.isEmpty());
	}

}
