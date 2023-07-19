package com.mastercode.entityrelationships.service;

import com.mastercode.entityrelationships.entity.Product;
import com.mastercode.entityrelationships.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<Product> searchProducts(String query) {
    return productRepository.searchProducts(query);
  }

  public void createProduct(Product product) {
    productRepository.save(product);
  }
}
