package org.stratpoint.project2.vbauson.service.Impl;

import junit.framework.TestCase;
import org.stratpoint.project2.vbauson.model.EBook;

public class DigitalLibraryServiceImplTest extends TestCase {

    private DigitalLibraryServiceImpl digitalLibraryService;
    public void setUp() throws Exception {
        digitalLibraryService = new DigitalLibraryServiceImpl();
    }

    public void testAddEBook() {
        EBook eBook = new EBook("E-Book", "E-Book1", "George Orwell", 789012, 5.5, "PDF");
        digitalLibraryService.addEBook(eBook);
        assertEquals(1, digitalLibraryService.eBookList.size());
        assertEquals("E-Book1", digitalLibraryService.eBookList.get(0).getTitle());
    }

    public void testDeleteEBook() {
        EBook eBook = new EBook("E-Book", "E-Book1", "George Orwell", 789012, 5.5, "PDF");
        digitalLibraryService.addEBook(eBook);
        digitalLibraryService.deleteEBook(789012);
        assertEquals(0, digitalLibraryService.eBookList.size());
    }

    public void testSearchEBook() {
        EBook eBook = new EBook("E-Book", "E-Book1", "George Orwell", 789012, 5.5, "PDF");
        digitalLibraryService.addEBook(eBook);
        digitalLibraryService.searchEBook("1984");
        digitalLibraryService.searchEBook("E-Book1");
        assertEquals("E-Book1", digitalLibraryService.eBookList.get(0).getTitle());
    }
}