package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Product;
import com.mastercode.entityrelationships.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory() {
        ProductCategory productCategory = ProductCategory.builder()
                .categoryName("books")
                .categoryDescription("books description")
                .build();

        Product product1 = Product.builder()
                .name("Java")
                .description("product 1 description")
                .sku("100ABX")
                .price(new BigDecimal("43.13"))
                .active(Boolean.TRUE)
                .imageUrl("java.jpg")
                .category(productCategory)
                .build();


        Product product2 = Product.builder()
                .name("Scala")
                .description("product 2 description")
                .sku("100ABC")
                .price(new BigDecimal("12.99"))
                .active(Boolean.TRUE)
                .imageUrl("product2.jpg")
                .category(productCategory)
                .build();

        productCategory.setProducts(List.of(product1, product2));

        productCategoryRepository.save(productCategory);
    }

    @Test
    @Transactional
    void updateProductsCategory() {
        ProductCategory productCategory = productCategoryRepository.findById(1L).get();
        productCategory.setCategoryDescription("new books category description");

        Product product = productCategory.getProducts().get(0);
        product.setName("Java new version");

        productCategoryRepository.save(productCategory);
    }


    @Test
    @Transactional
    void getProductsCategory() {
        ProductCategory productCategory = productCategoryRepository.findById(1L).get();
        System.out.println(productCategory.getProducts());
    }

}