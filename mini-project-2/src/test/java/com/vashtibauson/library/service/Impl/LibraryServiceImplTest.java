package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {

    // Instance of the class being tested
    private LibraryServiceImpl libraryService;

    // Setup method to initialize objects before each test
    @BeforeEach
    public void setUp() {
        libraryService = new LibraryServiceImpl();
    }

    // Test method for adding a book
    @Test
    void addBook() {
        // Create a new Book object
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");

        // Add the book to the library
        libraryService.addBook(book);

        // Verify that the book list size is now 1
        assertEquals(1, libraryService.bookList.size());

        // Verify that the title of the first book in the list is "The Great Gatsby"
        assertEquals("The Great Gatsby", libraryService.bookList.get(0).getTitle());
    }

    // Test method for deleting a book
    @Test
    void deleteBook() {
        // Create a new Book object
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");

        // Add the book to the library
        libraryService.addBook(book);

        // Delete the book with the specified ISBN
        libraryService.deleteBook(123456);

        // Verify that the book list size is now 0
        assertEquals(0, libraryService.bookList.size());
    }

    // Test method for searching a book by title
    @Test
    void searchBook() {
        // Create a new Book object
        Book book = new Book("Harry Potter: Goblet of Fire", "JK Rowling", 456789, "Book");

        // Add the book to the library
        libraryService.addBook(book);

        // Search for the book with the specified title keyword
        libraryService.searchBook("Harry Potter");

        // Verify that the title of the first book in the list contains "Harry Potter"
        assertEquals("Harry Potter: Goblet of Fire", libraryService.bookList.get(0).getTitle());
    }
}
