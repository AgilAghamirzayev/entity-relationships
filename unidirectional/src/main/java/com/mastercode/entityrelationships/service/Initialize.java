package com.mastercode.entityrelationships.service;

import com.mastercode.entityrelationships.entity.Address;
import com.mastercode.entityrelationships.entity.Order;
import com.mastercode.entityrelationships.entity.OrderItem;
import com.mastercode.entityrelationships.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class Initialize {

  private final OrderRepository orderRepository;

  @PostConstruct
  @Transactional
  public void init() {
//    Order order = orderRepository.findById(1L).get();

//    Address address = Address.builder()
//        .country("Azerbaijan")
//        .city("Baku")
//        .state("Narimanov")
//        .street("Tabriz")
//        .zipcode("1000AZ")
//        .build();

//    OrderItem orderItem1 = OrderItem.builder()
//        .quantity(2)
//        .imageUrl("image1.png")
//        .build();
//
//    OrderItem orderItem2 = OrderItem.builder()
//        .quantity(5)
//        .imageUrl("image2.png")
//        .build();
//
//    order.setOrderItems(Set.of(orderItem1, orderItem2));
//    order.setTotalQuantity(4);
//
//    orderRepository.save(order);

    var savedOrder = orderRepository.findByOrderTrackingNumberContaining("123BCD");
    savedOrder.get(0).getOrderItems().forEach(item -> System.out.println(item.getId()));
  }
}
