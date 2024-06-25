package org.stratpoint.project2.vbauson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DigitalLibrary{
    List<EBook> eBookList = new ArrayList<EBook>();


    public void addEBook(String type, String title, String author, int isbn, double fileSize, String format) {
        eBookList.add(new EBook(type, title, author, isbn, fileSize, format));
        System.out.println("\nCategory type: " + type);
        System.out.println("E-Book added: " + title);
        System.out.println("Written by " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("File Size: " + fileSize);
        System.out.println("Format: " + format);


    }


    public void deleteEBook(int isbn) {
        Iterator<EBook> itr = eBookList.iterator();
        boolean found = false;

        while (itr.hasNext()) {
            EBook item = itr.next();
            if (item.getIsbn() == isbn) {
                itr.remove();
                System.out.println("\nE-Book removed: " + item.getTitle());
                found = true;
                break;
            }
        }
    }


    public void searchEBook(String title) {
        for (EBook eBook : eBookList) {
            if (eBook.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nE-Book titled " + title + " found!");
                return;
            }
        }
        System.out.println("\nE-Book with title " + title + " not found.");
    }
    }

