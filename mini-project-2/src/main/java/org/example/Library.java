package org.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    List<Book> bookList = new ArrayList<Book>();

    public void addBook(String title, String author, int isbn){
        bookList.add(new Book(title, author, isbn));
        System.out.println("Book added: " + title);
        System.out.println("Written by " + author);
        System.out.println("ISBN: " + isbn);

    }

    public void deleteBook(int isbn){
        Iterator<Book> itr = bookList.iterator();


    }
    public void searchBook(String title, String author, int isbn){
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + title + "Written by " + author);
                System.out.println("ISBN: " + isbn);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }
}
