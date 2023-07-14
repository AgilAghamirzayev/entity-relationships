package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Order;
import com.mastercode.entityrelationships.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
