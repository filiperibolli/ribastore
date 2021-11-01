package com.ribastore.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribastore.estoque.model.Produto;
import com.ribastore.estoque.service.EstoqueService;


@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@RequestMapping("/{jogo}")
	public Produto getEstoquePorJogo(@PathVariable String jogo) {
		return estoqueService.getEstoquePorJogo(jogo);
	}
	
	@RequestMapping("")
	public List<Produto> getEstoque() {
		return estoqueService.getEstoque();
	}

}
