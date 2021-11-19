package com.ribastore.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ribastore.estoque.dto.ProdutoDTO;
import com.ribastore.estoque.model.Produto;

@Service
public interface EstoqueService {

	Produto getEstoquePorJogo(String jogo);

	List<Produto> getEstoque();
	
	Produto insereProduto(ProdutoDTO produto);

}
