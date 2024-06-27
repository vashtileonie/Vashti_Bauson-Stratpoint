package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.Book;
import com.vashtibauson.library.service.LibraryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Implementation of the LibraryService interface
public class LibraryServiceImpl implements LibraryService {
    // List to store Book objects
    List<Book> bookList = new ArrayList<Book>();

    // Method to add a new book to the list
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

    // Method to delete a book from the list by ISBN
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
                System.out.println("=======================================");
                found = true;
                break;
            }
        }
    }

    // Method to search for a book by title
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
        System.out.print("===========================================");
    }
}
