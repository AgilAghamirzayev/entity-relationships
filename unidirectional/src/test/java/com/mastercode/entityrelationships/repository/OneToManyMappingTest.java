package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Address;
import com.mastercode.entityrelationships.entity.Order;
import com.mastercode.entityrelationships.entity.OrderItem;
import com.mastercode.entityrelationships.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Set;

@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveOrder() {
        Order order = Order.builder()
                .orderTrackingNumber("123BC")
                .status("IN PROGRESS")
                .build();

        Product product1 = productRepository.findById(1L).orElseThrow(() -> new RuntimeException("Not found"));
        Product product2 = productRepository.findById(2L).orElseThrow(() -> new RuntimeException("Not found"));

        Address address = Address.builder()
                .country("Azerbaijan")
                .city("Baku")
                .state("Narimanov")
                .street("Tabriz")
                .zipcode("1000AZ")
                .build();

        OrderItem orderItem1 = OrderItem.builder()
                .product(product1)
                .quantity(2)
                .price(product1.getPrice().multiply(new BigDecimal(2)))
                .imageUrl("image1.png")
                .build();

        OrderItem orderItem2 = OrderItem.builder()
                .product(product2)
                .quantity(5)
                .price(product2.getPrice().multiply(new BigDecimal(5)))
                .imageUrl("image2.png")
                .build();

        order.setOrderItems(Set.of(orderItem1, orderItem2));
        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);
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
