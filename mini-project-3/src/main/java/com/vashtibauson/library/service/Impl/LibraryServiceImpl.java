package com.vashtibauson.library.service.Impl;
import com.vashtibauson.library.exception.DuplicateISBNException;
import com.vashtibauson.library.model.Book;
import com.vashtibauson.library.service.LibraryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    List<Book> bookList = new ArrayList<Book>();

    @Override
    public void addBook(Book book) throws DuplicateISBNException {
        for (Book existingBook : bookList) {
            if (existingBook.getIsbn() == book.getIsbn()) {
                throw new DuplicateISBNException("ISBN " + book.getIsbn() + " already exists.");
            }
        }
        bookList.add(book);
        System.out.println("\nCategory type: " + book.getType());
        System.out.println("\nBook added: " + book.getTitle());
        System.out.println("Written by " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
    }

    @Override
    public void deleteBook(int isbn){
        Iterator<Book> itr = bookList.iterator();
        boolean found = false;

        while (itr.hasNext()) {
            Book item = itr.next();
            if (item.getIsbn() == isbn) {
                itr.remove();
                System.out.println("\nBook removed: " + item.getTitle());
                found = true;
                break;
            }
        }

    }
    @Override
    public void searchBook(String title){
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("\nBook titled " + book.getTitle() + "found!");
                return;
            }
        }
        System.out.println("\nBook with title '" + title + "' not found.");
    }
}
