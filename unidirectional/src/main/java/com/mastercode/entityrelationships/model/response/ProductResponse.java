package com.mastercode.entityrelationships.model.response;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String sku;
  private String name;
  private String description;
  private BigDecimal price;
  private Boolean active;
  private String imageUrl;
  private Instant createdDate;
  private Instant lastModifiedDate;
  private String createdBy;
  private String lastModifiedBy;
}
