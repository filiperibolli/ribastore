package com.ribastore.estoque.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ribastore.estoque.model.Produto;

public interface EstoqueRepository extends CrudRepository<Produto, Long>{
	
	Produto findByJogo(String jogo);
	
	List<Produto> findByIdIn(List<Long> ids);

}
