package com.jivan.bookstore.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jdk.jfr.DataAmount;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Table(name = "book", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }),
        @UniqueConstraint(columnNames = { "name" }) })
public class Book  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Column(name = "NAME")
    @Size(max = 40)
    private String name;

    @NotBlank
    @Column(name = "AUTHOR_NAME")
    @Size(max = 40)
    private String authorName;

    @OneToOne(fetch = FetchType.EAGER , targetEntity = BookInventory.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id" , referencedColumnName = "book_id")
    private BookInventory bookInventory;
}
