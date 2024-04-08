package com.aulasnelioalves.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulasnelioalves.curso.entities.OrderItem;
import com.aulasnelioalves.curso.entities.pk.OrderItemPK;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	

}
