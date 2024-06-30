package com.vashtibauson.library.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vashtibauson.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(DigitalLibraryServiceImpl.class);
    // Instance of the class being tested
    private LibraryServiceImpl libraryService;

    // Setup model to initialize objects before each test
    @BeforeEach
    public void setUp() {
        libraryService = new LibraryServiceImpl();
    }

    // Test model for adding a book
    @Test
    void addBook() {
        // Create a new Book object
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");

        // Add the book to the library
        libraryService.addBook(book);
        logger.info("Added Book: {}", book);

        // Verify that the book list size is now 1
        assertEquals(1, libraryService.bookList.size());
        logger.info("Book List: {}",libraryService.bookList.size());

        // Verify that the title of the first book in the list is "The Great Gatsby"
        assertEquals("The Great Gatsby", libraryService.bookList.get(0).getTitle());
        logger.info("Checking book Title: {}", libraryService.bookList.get(0).getTitle());
    }

    // Test model for deleting a book
    @Test
    void deleteBook() {
        // Create a new Book object
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");

        // Add the book to the library
        libraryService.addBook(book);


        // Delete the book with the specified ISBN
        libraryService.deleteBook(123456);
        logger.info("Deleted Book: {}", book);

        // Verify that the book list size is now 0
        assertEquals(0, libraryService.bookList.size());
    }

    // Test model for searching a book by title
    @Test
    void searchBook() {
        // Create a new Book object
        Book book = new Book("Harry Potter: Goblet of Fire", "JK Rowling", 456789, "Book");

        // Add the book to the library
        libraryService.addBook(book);

        // Search for the book with the specified title keyword
        libraryService.searchBook("Harry Potter");
        logger.info("Searched Book: {}", book);

        // Verify that the title of the first book in the list contains "Harry Potter"
        assertEquals("Harry Potter: Goblet of Fire", libraryService.bookList.get(0).getTitle());
    }
}
