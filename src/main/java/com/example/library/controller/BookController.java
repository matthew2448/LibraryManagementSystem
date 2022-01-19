package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;


    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(){
        return "hello";
    }

    @GetMapping("/books")
    public String listBooks(Model model){
        List<Book> listBooks = bookService.getAllBooks();
        model.addAttribute("books", listBooks);
        return "books";
    }

    @GetMapping("/books/new")
    public String createBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "create_book";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{ISBN}")
    public String editBook(@PathVariable String ISBN, Model model){
        model.addAttribute("book",bookService.getBookByISBN(ISBN));
        return "edit_book";
    }

    @PostMapping("/books/{ISBN}")
    public String updateBook(@PathVariable String ISBN,
                                @ModelAttribute("book") Book book,
                                Model model){
        Book existingBook = bookService.getBookByISBN(ISBN);
        existingBook.setISBN(ISBN);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setYearPublished(book.getYearPublished());

        bookService.updateBook(existingBook);
        return "redirect:/books";
    }

    @GetMapping("/books/{ISBN}")
    public String deleteBook(@PathVariable String ISBN){
        bookService.deleteBook(ISBN);
        return "redirect:/books";
    }
}
