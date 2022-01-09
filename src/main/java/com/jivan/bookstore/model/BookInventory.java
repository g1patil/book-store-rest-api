package com.jivan.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author g1patil
 */
@Entity
@Data
@Table(name = "book_inventory", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "book_id" })
})
public class BookInventory {
    private static final long serialVersionUID = 1L;

    @Id
    @JsonIgnore
    @Column(name = "book_id")
    private Long book_id;

    @NotBlank
    @Column(name = "stock_count")
    @Size(max = 40)
    private int availableCount;
}
