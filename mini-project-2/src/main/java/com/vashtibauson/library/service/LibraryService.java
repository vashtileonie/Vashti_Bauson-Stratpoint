package com.vashtibauson.library.service;

import com.vashtibauson.library.model.Book;

/**
 * Interface for Library Service.
 */
public interface LibraryService {

    /**
     * Adds a Book to the library.
     *
     * @param book The Book to be added
     */
    void addBook(Book book);

    /**
     * Deletes a Book from the library based on ISBN.
     *
     * @param isbn The ISBN of the Book to delete
     */
    void deleteBook(int isbn);

    /**
     * Searches for a Book in the library by title.
     *
     * @param title The title of the Book to search for
     */
    void searchBook(String title);
}
