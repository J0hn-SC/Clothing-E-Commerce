package com.jesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesc.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
