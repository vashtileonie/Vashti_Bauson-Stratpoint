package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {
    private LibraryServiceImpl libraryService;


    @BeforeEach
    public void setUp() {
        libraryService = new LibraryServiceImpl();

    }

    @Test
    void addBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");

        libraryService.addBook(book);
        assertEquals(1, libraryService.bookList.size());
        assertEquals("The Great Gatsby", libraryService.bookList.get(0).getTitle());
    }


    @Test
    void deleteBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");

        libraryService.addBook(book);

        libraryService.deleteBook(123456);
        assertEquals(0, libraryService.bookList.size());
    }

    @Test
    void searchBook() {
        Book book = new Book("Harry Potter: Goblet of Fire", "JK Rowling", 456789, "Book");
        libraryService.addBook(book);
        libraryService.searchBook("Harry Potter");
            assertEquals("Harry Potter: Goblet of Fire", libraryService.bookList.get(0).getTitle());
    }
}