package com.vashtibauson.library.service;

import com.vashtibauson.library.exception.DuplicateISBNException;
import com.vashtibauson.library.model.EBook;

public interface DigitalLibraryService {
    public void addEBook(EBook eBook) throws DuplicateISBNException;
    public void deleteEBook(int isbn);
    public void searchEBook(String title);
}

