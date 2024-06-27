package com.vashtibauson.library.service;

import com.vashtibauson.library.model.Book;

public interface LibraryService {
    void addBook(Book book);
    void deleteBook(int isbn);
    void searchBook(String title);
}
