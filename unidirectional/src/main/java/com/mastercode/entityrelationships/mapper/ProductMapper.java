package com.mastercode.entityrelationships.mapper;

import com.mastercode.entityrelationships.entity.Product;
import com.mastercode.entityrelationships.model.request.ProductRequest;
import com.mastercode.entityrelationships.model.response.ProductResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  Product mapToProduct(ProductRequest request);

  ProductResponse mapToProductResponse(Product product);

  List<ProductResponse> mapToProductResponseList(List<Product> products);
}
