package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Product;
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
        Product product1 = Product.builder()
                .name("product 1")
                .description("product 1 description")
                .sku("100ABX")
                .price(BigDecimal.TEN)
                .active(Boolean.TRUE)
                .imageUrl("product1.jpg")
                .build();


        Product product2 = Product.builder()
                .name("product 2")
                .description("product 2 description")
                .sku("100ABC")
                .price(new BigDecimal("12.99"))
                .active(Boolean.TRUE)
                .imageUrl("product2.jpg")
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
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
