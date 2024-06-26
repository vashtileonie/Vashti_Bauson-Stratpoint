package org.stratpoint.project2.vbauson.service;

import org.stratpoint.project2.vbauson.model.Book;

public interface LibraryService {
    void addBook(Book book);
    void deleteBook(int isbn);
    void searchBook(String title);
}
