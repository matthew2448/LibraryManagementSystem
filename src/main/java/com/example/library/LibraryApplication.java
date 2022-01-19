package com.example.library;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
		/*
		Book book1 = new Book("0195153448","Classical Mythology","Mark P. O. Morford",2002,"Oxford University Press");
		bookRepository.save(book1);

		Book book2 = new Book("0002005018","Clara Callan","Richard Bruce Wright",2001,"HarperFlamingo Canada");
		bookRepository.save(book2);
		*/
	}
}
