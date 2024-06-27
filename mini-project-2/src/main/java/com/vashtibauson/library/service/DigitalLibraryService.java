package com.vashtibauson.library.service;

import com.vashtibauson.library.model.EBook;

/**
 * Interface for Digital Library Service.
 */
public interface DigitalLibraryService {

    /**
     * Adds an E-Book to the digital library.
     *
     * @param eBook The E-Book to be added
     */
    void addEBook(EBook eBook);

    /**
     * Deletes an E-Book from the digital library based on ISBN.
     *
     * @param isbn The ISBN of the E-Book to delete
     */
    void deleteEBook(int isbn);

    /**
     * Searches for an E-Book in the digital library by title.
     *
     * @param title The title of the E-Book to search for
     */
    void searchEBook(String title);
}
