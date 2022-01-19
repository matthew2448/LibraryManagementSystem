package com.example.library.service;

import com.example.library.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookByISBN(String ISBN);
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(String ISBN);
}
