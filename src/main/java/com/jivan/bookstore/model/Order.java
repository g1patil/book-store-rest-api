package com.jivan.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

/**
 * @author g1patil
 */
@Entity
@Data
@Table(name = "orders", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id" }),
        @UniqueConstraint(columnNames = { "invoice_id" })
})
public class Order {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "amount")
    private BigDecimal orderTotal;

    @Column(name = "item_count")
    private int itemCount;
}
