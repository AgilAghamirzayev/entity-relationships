package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
