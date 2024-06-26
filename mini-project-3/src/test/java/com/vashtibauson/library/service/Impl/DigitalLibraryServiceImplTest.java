package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.exception.DuplicateISBNException;
import com.vashtibauson.library.model.EBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitalLibraryServiceImplTest {

    private DigitalLibraryServiceImpl digitalLibraryService;

    @BeforeEach
    void setUp() {
        digitalLibraryService = new DigitalLibraryServiceImpl();
    }

    @Test
    void addEBook() {
        EBook eBook = new EBook("E-Book", "E-Book1", "George Orwell", 789012, 5.5, "PDF");
        try {
            digitalLibraryService.addEBook(eBook);
        } catch (DuplicateISBNException e) {
            fail("Exception should not be thrown");
        }
        assertEquals(1, digitalLibraryService.eBookList.size());
        assertEquals("E-Book1", digitalLibraryService.eBookList.get(0).getTitle());
    }

    @Test
    void addEBookWithDuplicateISBN() {
        EBook eBook1 = new EBook("E-Book", "E-Book1", "George Orwell", 789012, 5.5, "PDF");
        EBook eBook2 = new EBook("E-Book", "E-Book2", "Aldous Huxley", 789012, 4.5, "EPUB");
        try {
            digitalLibraryService.addEBook(eBook1);
        } catch (DuplicateISBNException e) {
            fail("Exception should not be thrown");
        }
        Exception exception = assertThrows(DuplicateISBNException.class, () -> {
            digitalLibraryService.addEBook(eBook2);
        });
        String expectedMessage = "ISBN 789012 already exists.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void deleteEBook() {
        EBook eBook = new EBook("E-Book", "E-Book1", "George Orwell", 789012, 5.5, "PDF");
        try {
            digitalLibraryService.addEBook(eBook);
        } catch (DuplicateISBNException e) {
            fail("Exception should not be thrown");
        }
        digitalLibraryService.deleteEBook(789012);
        assertEquals(0, digitalLibraryService.eBookList.size());
    }

    @Test
    void searchEBook() {
        EBook eBook = new EBook("E-Book", "E-Book1", "George Orwell", 789012, 5.5, "PDF");
        try {
            digitalLibraryService.addEBook(eBook);
        } catch (DuplicateISBNException e) {
            fail("Exception should not be thrown");
        }

        // You may want to capture the search output and compare it.
        // Here we're just checking if the searchEBook method runs without errors.
        digitalLibraryService.searchEBook("E-Book1");

        // Assuming the method outputs to the console, you would typically capture and verify the console output.
        // For now, we'll just verify the eBook is still in the list.
        assertEquals("E-Book1", digitalLibraryService.eBookList.get(0).getTitle());
    }
}
