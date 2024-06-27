package com.vashtibauson.library.service;

import com.vashtibauson.library.model.EBook;

public interface DigitalLibraryService {
    public void addEBook(EBook eBook);
    public void deleteEBook(int isbn);
    public void searchEBook(String title);
}

