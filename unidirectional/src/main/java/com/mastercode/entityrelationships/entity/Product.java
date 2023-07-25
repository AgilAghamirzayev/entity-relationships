package com.mastercode.entityrelationships.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_keeping_unit", unique = true)
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean active;
    private Boolean isDeleted;
    private String imageUrl;

    @Transient // don't persist
    private String test;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifiedBy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) && Objects.equals(sku, product.sku) && Objects.equals(name, product.name)
                && Objects.equals(description, product.description) && Objects.equals(price, product.price)
                && Objects.equals(active, product.active) && Objects.equals(imageUrl, product.imageUrl)
                && Objects.equals(test, product.test) && Objects.equals(createdDate, product.createdDate)
                && Objects.equals(lastModifiedDate, product.lastModifiedDate) &&
                Objects.equals(createdBy, product.createdBy) && Objects.equals(lastModifiedBy, product.lastModifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, name, description, price, active, imageUrl, test, createdDate,
                lastModifiedDate, createdBy, lastModifiedBy);
    }

}
