package com.mastercode.entityrelationships.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderTrackingNumber;
    private Integer totalQuantity;
    private BigDecimal totalPrice;
    private String status;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;


}
