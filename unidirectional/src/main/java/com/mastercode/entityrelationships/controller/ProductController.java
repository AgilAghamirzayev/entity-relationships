package com.mastercode.entityrelationships.controller;

import com.mastercode.entityrelationships.entity.Product;
import com.mastercode.entityrelationships.model.request.ProductRequest;
import com.mastercode.entityrelationships.model.request.UpdateProductRequest;
import com.mastercode.entityrelationships.model.response.ProductResponse;
import com.mastercode.entityrelationships.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProductResponse getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<ProductResponse> searchProducts(String query) {
    return productService.searchProducts(query);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody ProductRequest product) {
    productService.createProduct(product);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest request) {
    productService.updateProduct(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }

}
