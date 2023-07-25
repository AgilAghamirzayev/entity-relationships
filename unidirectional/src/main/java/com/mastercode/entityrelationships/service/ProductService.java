package com.mastercode.entityrelationships.service;

import com.mastercode.entityrelationships.entity.Product;
import com.mastercode.entityrelationships.mapper.ProductMapper;
import com.mastercode.entityrelationships.model.request.ProductRequest;
import com.mastercode.entityrelationships.model.request.UpdateProductRequest;
import com.mastercode.entityrelationships.model.response.ProductResponse;
import com.mastercode.entityrelationships.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductMapper productMapper = ProductMapper.INSTANCE;

  private final ProductRepository productRepository;

  public ProductResponse getProductById(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Could not find product"));
    return productMapper.mapToProductResponse(product);
  }

  public List<ProductResponse> searchProducts(String query) {
    List<Product> products = productRepository.searchProducts(query);
    return productMapper.mapToProductResponseList(products);
  }

  public void createProduct(ProductRequest request) {
    Product product = productMapper.mapToProduct(request);
    if (product == null) {
      log.info("createProduct().FAIK. Product not created");
      return;
    }

    productRepository.save(product);
    log.info("createProduct().SUCCESS. Product created");
  }

  public void updateProduct(Long id, UpdateProductRequest request) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Could not find product"));

    if (request.getName() != null) {
      product.setName(request.getName());
    }

    if (request.getPrice() != null) {
      product.setPrice(request.getPrice());
    }

    if (request.getActive() != null) {
      product.setActive(request.getActive());
    }

    productRepository.save(product);
  }

  public void deleteProduct(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Could not find product"));

    product.setIsDeleted(Boolean.TRUE);
    productRepository.save(product);
  }


}
