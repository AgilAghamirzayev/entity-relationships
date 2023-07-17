package com.mastercode.entityrelationships.controller;

import com.mastercode.entityrelationships.entity.Order;
import com.mastercode.entityrelationships.entity.OrderItem;
import com.mastercode.entityrelationships.repository.OrderRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestController {

    private final OrderRepository orderRepository;

    @GetMapping
    public Order getOrder() {
        Order order = orderRepository.findById(4L).orElseThrow();
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.println(orderItem);
        }
        System.out.println("Order test");
        return order;
    }

    @GetMapping("/s")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
