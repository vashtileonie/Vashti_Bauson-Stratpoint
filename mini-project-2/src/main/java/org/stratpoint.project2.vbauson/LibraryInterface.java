package org.stratpoint.project2.vbauson;

public interface LibraryInterface {
    void addBook(Book book);
    void deleteBook(int isbn);
    void searchBook(String title);
}
