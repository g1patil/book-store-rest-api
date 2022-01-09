package com.jivan.bookstore.payload;

import lombok.Data;

@Data
public class BookRequest {
    private String name;
    private String authorName;
}
