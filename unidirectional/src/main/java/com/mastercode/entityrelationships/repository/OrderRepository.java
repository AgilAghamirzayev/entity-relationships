package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Order;
import com.mastercode.entityrelationships.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

  // N+1 problem solutions
//  @Query("""
//      select o from Order o
//      join fetch o.orderItems
//      join fetch o.billingAddress
//      where o.orderTrackingNumber = :number
//      """)
  @EntityGraph(attributePaths = {"orderItems"})
  List<Order> findByOrderTrackingNumberContaining(String number);
}
