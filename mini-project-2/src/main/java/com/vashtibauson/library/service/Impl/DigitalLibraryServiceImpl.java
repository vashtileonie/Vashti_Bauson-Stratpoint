package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.EBook;
import com.vashtibauson.library.service.DigitalLibraryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of the DigitalLibraryService interface for managing E-Books.
 */
public class DigitalLibraryServiceImpl implements DigitalLibraryService {
    // List to store EBook objects
    List<EBook> eBookList = new ArrayList<>();

    /**
     * Adds a new E-Book to the library.
     *
     * @param eBook The EBook object to be added
     */
    public void addEBook(EBook eBook) {
        // Add the eBook to the list
        eBookList.add(eBook);
        // Print eBook details
        System.out.println("\n===============NEW E-BOOK===============");
        System.out.println("Category type: " + eBook.getType());
        System.out.println("E-Book added: " + eBook.getTitle());
        System.out.println("Written by " + eBook.getAuthor());
        System.out.println("ISBN: " + eBook.getIsbn());
        System.out.println("File Size: " + eBook.getFileSize());
        System.out.println("Format: " + eBook.getFormat());
        System.out.println("========================================");
    }

    /**
     * Deletes an E-Book from the library by ISBN.
     *
     * @param isbn The ISBN of the EBook to be deleted
     */
    public void deleteEBook(int isbn) {
        // Create an iterator for the eBook list
        Iterator<EBook> itr = eBookList.iterator();
        boolean found = false;

        // Iterate through the list
        while (itr.hasNext()) {
            // Get the current eBook
            EBook item = itr.next();
            // Check if the ISBN matches
            if (item.getIsbn() == isbn) {
                // Remove the eBook from the list
                itr.remove();
                // Print eBook removal details
                System.out.println("\n===========REMOVE E-BOOK===============");
                System.out.println("E-Book removed: " + item.getTitle());
                System.out.println("ISBN: " + item.getIsbn());
                System.out.println("=======================================");
                found = true;
                break;
            }
        }
    }

    /**
     * Searches for an E-Book in the library by title.
     *
     * @param title The title of the EBook to search for
     */
    public void searchEBook(String title) {
        // Iterate through the eBook list
        for (EBook eBook : eBookList) {
            // Check if the title contains the search term (case-insensitive)
            if (eBook.getTitle().toLowerCase().contains(title.toLowerCase())) {
                // Print eBook search details
                System.out.println("\n===========SEARCH BY TITLE===============");
                System.out.println("E-Book titled " + eBook.getTitle() + " found!");
                System.out.println("=======================================");
                return;
            }
        }
        // Print error message if eBook is not found
        System.out.println("\n=================SEARCH: ERROR=================");
        System.out.println("E-Book with title " + title + " not found.");
        System.out.println("===========================================");
    }
}
