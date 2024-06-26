package org.stratpoint.project2.vbauson.service.Impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.stratpoint.project2.vbauson.model.Book;

public class LibraryServiceImplTest extends TestCase {
    private LibraryServiceImpl libraryService;

    @Before
    public void setUp () {
        libraryService = new LibraryServiceImpl();
    }

    public void testAddBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");
        libraryService.addBook(book);
        assertEquals(1, libraryService.bookList.size());
        assertEquals("The Great Gatsby", libraryService.bookList.get(0).getTitle());
    }

    public void testDeleteBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");
        libraryService.addBook(book);
        libraryService.deleteBook(123456);
        assertEquals(0, libraryService.bookList.size());
    }

    public void testSearchBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, "Book");
        libraryService.addBook(book);
        libraryService.searchBook("The Great Gatsby");
        assertEquals("The Great Gatsby", libraryService.bookList.get(0).getTitle());
    }
}