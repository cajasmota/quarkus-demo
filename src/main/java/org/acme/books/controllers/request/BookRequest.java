package org.acme.books.controllers.request;

import lombok.Data;

@Data
public class BookRequest {

    private String name;
    private String author;
    private Long pages;

}
