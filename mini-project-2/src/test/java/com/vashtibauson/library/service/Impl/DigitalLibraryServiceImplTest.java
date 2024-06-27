package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.EBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitalLibraryServiceImplTest {

    private DigitalLibraryServiceImpl digitalLibraryService;

    @BeforeEach
    void setUp() {
        digitalLibraryService = new DigitalLibraryServiceImpl();
        System.out.println("TEST FOR: E-BOOK");
    }

    @Test
    void addEBook() {
        EBook eBook = new EBook("E-Book", "E-Book1", "George Orwell", 789012, 5.5, "PDF");
        digitalLibraryService.addEBook(eBook);
        assertEquals(1, digitalLibraryService.eBookList.size());
        assertEquals("E-Book1", digitalLibraryService.eBookList.get(0).getTitle());
    }

    @Test
    void deleteEBook() {
        EBook eBook = new EBook("E-Book", "Harry Potter: Goblet of Fire", "JK Rowling", 456789, 8, "TXT File");
        digitalLibraryService.addEBook(eBook);
        digitalLibraryService.deleteEBook(456789);
        assertEquals(0, digitalLibraryService.eBookList.size());
    }

    @Test
    void searchEBook() {
        EBook eBook = new EBook("E-Book", "E-Book2", "Juan Dela Cruz", 345786, 5.5, "PDF");
        digitalLibraryService.addEBook(eBook);
        digitalLibraryService.searchEBook("E-Book2");
        assertEquals("E-Book2", digitalLibraryService.eBookList.get(0).getTitle());
    }
}