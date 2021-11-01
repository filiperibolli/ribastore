package com.ribastore.estoque.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribastore.estoque.model.Produto;
import com.ribastore.estoque.repository.EstoqueRepository;
import com.ribastore.estoque.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService{

	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Override
	public Produto getEstoquePorJogo(String jogo) {
		return estoqueRepository.findByJogo(jogo);
	}

	@Override
	public ArrayList<Produto> getEstoque() {
		return (ArrayList<Produto>) estoqueRepository.findAll();
	}

}
