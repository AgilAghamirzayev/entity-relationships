package com.mastercode.entityrelationships.model.request;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
  private String sku;
  private String name;
  private String description;
  private BigDecimal price;
  private Boolean active;
  private String imageUrl;
}
