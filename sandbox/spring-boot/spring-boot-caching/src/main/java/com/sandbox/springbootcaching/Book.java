package com.sandbox.springbootcaching;

import lombok.Data;

@Data
public class Book {
    private final String isbn;
    private final String title;

    @Override
    public String toString() {
        return "Book{" + "isbn='" + isbn + '\'' + ", title='" + title + '\'' + '}';
    }
}
