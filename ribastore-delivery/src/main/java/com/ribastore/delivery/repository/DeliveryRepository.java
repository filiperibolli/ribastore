package com.ribastore.delivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ribastore.delivery.model.Entrega;


@Repository
public interface DeliveryRepository extends CrudRepository<Entrega, Long>{

}
