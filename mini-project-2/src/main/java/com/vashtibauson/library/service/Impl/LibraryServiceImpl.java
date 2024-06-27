package com.vashtibauson.library.service.Impl;
import com.vashtibauson.library.model.Book;
import com.vashtibauson.library.service.LibraryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    List<Book> bookList = new ArrayList<Book>();

    @Override
    public void addBook(Book book) {

        bookList.add(book);
        System.out.println("\n===============NEW BOOK===============");
        System.out.println("Category type: " + book.getType());
        System.out.println("Book added: " + book.getTitle());
        System.out.println("Written by " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("========================================");
    }

    @Override
    public void deleteBook(int isbn){
        Iterator<Book> itr = bookList.iterator();
        boolean found = false;

        while (itr.hasNext()) {
            Book item = itr.next();
            if (item.getIsbn() == isbn) {
                itr.remove();
                System.out.println("\n===========REMOVE BOOK===============");
                System.out.println("Book removed: " + item.getTitle());
                System.out.println("=======================================");
                found = true;
                break;
            }
        }

    }
    @Override
    public void searchBook(String title){
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("\n===========SEARCH BY TITLE===============");
                System.out.println("Book titled " + book.getTitle() + " found!");
                System.out.println("=======================================");
                return;
            }
        }
        System.out.println("\n=================SEARCH: ERROR=================");
        System.out.println("Book with title '" + title + "' not found.");
        System.out.print("===========================================");
    }
}
