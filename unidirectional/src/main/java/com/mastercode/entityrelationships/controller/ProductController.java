package com.mastercode.entityrelationships.controller;

import com.mastercode.entityrelationships.entity.Product;
import com.mastercode.entityrelationships.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<Product> searchProducts(String query) {
    return productService.searchProducts(query);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody Product product) {
    productService.createProduct(product);
  }
}
