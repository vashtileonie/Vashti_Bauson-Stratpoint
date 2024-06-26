package org.stratpoint.project2.vbauson.service;

import org.stratpoint.project2.vbauson.model.EBook;

public interface DigitalLibraryService {
    public void addEBook(EBook eBook);
    public void deleteEBook(int isbn);
    public void searchEBook(String title);
}

