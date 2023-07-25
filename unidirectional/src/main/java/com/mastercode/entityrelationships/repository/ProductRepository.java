package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Product;
import java.util.List;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Where(clause = "is_deleted = false")
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("""
      select p from Product p
      where  p.name like concat('%', :query, '%')
      or     p.description like concat('%', :query, '%')
      """)
  List<Product> searchProducts(String query);
}
