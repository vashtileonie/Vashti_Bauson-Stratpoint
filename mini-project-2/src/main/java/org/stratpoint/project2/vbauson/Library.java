package org.stratpoint.project2.vbauson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements LibraryInterface{
    List<Book> bookList = new ArrayList<Book>();

    @Override
    public void addBook(Book book){
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
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nBook titled " + title + "found!");
                return;
            }
        }
        System.out.println("\nBook with title '" + title + "' not found.");
    }
}
