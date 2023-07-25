package com.mastercode.entityrelationships.model.request;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductRequest {
  private String name;
  private BigDecimal price;
  private Boolean active;
}
