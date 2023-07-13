package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.uni.entity.Product;
import com.mastercode.entityrelationships.uni.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProduct() {
        Product product = Product.builder()
                .name("product 1")
                .description("product 1 description")
                .sku("100ABX")
                .price(BigDecimal.TEN)
                .active(Boolean.TRUE)
                .imageUrl("product1.jpg")
                .build();

        Product savedProduct = productRepository.save(product);

        System.out.println(savedProduct);
    }


    @Test
    void updateProduct() {
        Long id = 2L;
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

//        product.setName("product 222");
//        product.setDescription("updated product description");
//        product.setImageUrl("https://img.com");

        productRepository.save(product);

    }

}
