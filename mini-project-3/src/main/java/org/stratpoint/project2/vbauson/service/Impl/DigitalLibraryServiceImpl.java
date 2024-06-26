package org.stratpoint.project2.vbauson.service.Impl;
import org.stratpoint.project2.vbauson.model.EBook;
import org.stratpoint.project2.vbauson.service.DigitalLibraryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DigitalLibraryServiceImpl implements DigitalLibraryService {
    List<EBook> eBookList = new ArrayList<EBook>();


    public void addEBook(EBook eBook) {
        eBookList.add(eBook);
        System.out.println("\n===============NEW E-BOOK===============");
        System.out.println("Category type: " + eBook.getType());
        System.out.println("E-Book added: " + eBook.getTitle());
        System.out.println("Written by " + eBook.getAuthor());
        System.out.println("ISBN: " + eBook.getIsbn());
        System.out.println("File Size: " + eBook.getFileSize());
        System.out.println("Format: " + eBook.getFormat());
        System.out.println("========================================");


    }


    public void deleteEBook(int isbn) {
        Iterator<EBook> itr = eBookList.iterator();
        boolean found = false;

        while (itr.hasNext()) {
            EBook item = itr.next();
            if (item.getIsbn() == isbn) {
                itr.remove();
                System.out.println("\n===========REMOVE E-BOOK===============");
                System.out.println("E-Book removed: " + item.getTitle());
                System.out.println("=======================================");
                found = true;
                break;
            }
        }
    }


    public void searchEBook(String title) {
        for (EBook eBook : eBookList) {
            if (eBook.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("\n===========SEARCH BY TITLE===============");
                System.out.println("E-Book titled " + eBook.getTitle() + " found!");
                System.out.println("=======================================");
                return;
            }
        }
        System.out.println("\n=================SEARCH: ERROR=================");
        System.out.println("E-Book with title " + title + " not found.");
        System.out.print("===========================================");

    }
    }

