package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.exception.DuplicateISBNException;
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
        try {
            libraryService.addBook(book);
        } catch (DuplicateISBNException e) {
            fail("Exception should not be thrown");
        }
        assertEquals(1, libraryService.bookList.size());
        assertEquals("The Great Gatsby", libraryService.bookList.get(0).getTitle());
    }

    @Test
    void addBookWithDuplicateISBN() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");
        Book book2 = new Book("1984", "George Orwell", 123456, "Book");
        try {
            libraryService.addBook(book1);
        } catch (DuplicateISBNException e) {
            fail("Exception should not be thrown");
        }
        Exception exception = assertThrows(DuplicateISBNException.class, () -> {
            libraryService.addBook(book2);
        });
        String expectedMessage = "ISBN 123456 already exists.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void deleteBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");
        try {
            libraryService.addBook(book);
        } catch (DuplicateISBNException e) {
            fail("Exception should not be thrown");
        }
        libraryService.deleteBook(123456);
        assertEquals(0, libraryService.bookList.size());
    }

    @Test
    void searchBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");
        try {
            libraryService.addBook(book);
        } catch (DuplicateISBNException e) {
            fail("Exception should not be thrown");
        }
        libraryService.searchBook("The Great Gatsby");
        assertEquals("The Great Gatsby", libraryService.bookList.get(0).getTitle());
    }
}
