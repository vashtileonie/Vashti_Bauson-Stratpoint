package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.Book;
import com.vashtibauson.library.service.LibraryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of the LibraryService interface for managing Books.
 */
public class LibraryServiceImpl implements LibraryService {
    // List to store Book objects
    List<Book> bookList = new ArrayList<>();

    /**
     * Adds a new Book to the library.
     *
     * @param book The Book object to be added
     */
    @Override
    public void addBook(Book book) {
        // Add the book to the list
        bookList.add(book);
        // Print book details
        System.out.println("\n===============NEW BOOK===============");
        System.out.println("Category type: " + book.getType());
        System.out.println("Book added: " + book.getTitle());
        System.out.println("Written by " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("========================================");
    }

    /**
     * Deletes a Book from the library by ISBN.
     *
     * @param isbn The ISBN of the Book to be deleted
     */
    @Override
    public void deleteBook(int isbn) {
        // Create an iterator for the book list
        Iterator<Book> itr = bookList.iterator();
        boolean found = false;

        // Iterate through the list
        while (itr.hasNext()) {
            // Get the current book
            Book item = itr.next();
            // Check if the ISBN matches
            if (item.getIsbn() == isbn) {
                // Remove the book from the list
                itr.remove();
                // Print book removal details
                System.out.println("\n===========REMOVE BOOK===============");
                System.out.println("Book removed: " + item.getTitle());
                System.out.println("ISBN: " + item.getIsbn());
                System.out.println("=======================================");
                found = true;
                break;
            }
        }
    }

    /**
     * Searches for a Book in the library by title.
     *
     * @param title The title of the Book to search for
     */
    @Override
    public void searchBook(String title) {
        // Iterate through the book list
        for (Book book : bookList) {
            // Check if the title contains the search term (case-insensitive)
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                // Print book search details
                System.out.println("\n===========SEARCH BY TITLE===============");
                System.out.println("Book titled " + book.getTitle() + " found!");
                System.out.println("=======================================");
                return;
            }
        }
        // Print error message if the book is not found
        System.out.println("\n=================SEARCH: ERROR=================");
        System.out.println("Book with title '" + title + "' not found.");
        System.out.println("===========================================");
    }
}
