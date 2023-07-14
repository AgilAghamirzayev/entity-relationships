package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Address;
import com.mastercode.entityrelationships.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrder() {
        Order order = Order.builder()
                .orderTrackingNumber("123BC")
                .totalQuantity(5)
                .status("IN PROGRESS")
                .totalPrice(BigDecimal.ONE)
                .build();

        Address address = Address.builder()
                .country("Azerbaijan")
                .city("Baku")
                .state("Narimanov")
                .street("Tabriz")
                .zipcode("1000AZ")
                .build();

        order.setBillingAddress(address);

        orderRepository.save(order);
    }


    @Test
    void updateOrder() {
        Order order = orderRepository.findById(1L).orElseThrow(() -> new RuntimeException("Not found"));
        order.setStatus("DELIVERED ");
        order.getBillingAddress().setZipcode("1002AZ");

        orderRepository.save(order);
    }

    @Test
    void deleteOrder() {
        orderRepository.deleteById(1L);
    }
}
