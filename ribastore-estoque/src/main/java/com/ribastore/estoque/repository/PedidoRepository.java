package com.ribastore.estoque.repository;

import org.springframework.data.repository.CrudRepository;

import com.ribastore.estoque.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
