package com.mastercode.entityrelationships.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
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
@DynamicUpdate
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id")
    @ToString.Exclude
    private Address billingAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id) && Objects.equals(orderTrackingNumber, order.orderTrackingNumber) &&
                Objects.equals(totalQuantity, order.totalQuantity) && Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(status, order.status) && Objects.equals(createdDate, order.createdDate) &&
                Objects.equals(lastModifiedDate, order.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderTrackingNumber, totalQuantity, totalPrice, status, createdDate, lastModifiedDate);
    }
}
