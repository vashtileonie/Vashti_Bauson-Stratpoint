package com.vashtibauson.library;
import com.vashtibauson.library.exception.InvalidInputTypeException;
import com.vashtibauson.library.model.Book;
import com.vashtibauson.library.model.EBook;
import com.vashtibauson.library.service.Impl.DigitalLibraryServiceImpl;
import com.vashtibauson.library.service.Impl.LibraryServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        DigitalLibraryServiceImpl digitalLibraryServiceImpl = new DigitalLibraryServiceImpl();

        Print typePrint = new Print(scanner);
        try {
        int itemType = typePrint.itemTypePrint();
        scanner.nextLine();  // Consume newline

        while (true) {
            if (itemType == 1) {
                char option = typePrint.actionMenuPrint("Book");


                if (option == 'A') {
                    Book book = typePrint.getBookDetails();
                    libraryServiceImpl.addBook(book);

                } else if (option == 'B') {
                    System.out.println("Remove a Book: ");
                    System.out.print("Enter ISBN: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    libraryServiceImpl.deleteBook(isbn);

                } else if (option == 'C') {
                    System.out.println("Search for a Book: ");
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    libraryServiceImpl.searchBook(title);

                } else if (option == 'D') {
                    System.out.println("Goodbye!");
                    break;

                } else {
                    System.out.println("Invalid choice");
                }
            } else if (itemType == 2) {
                char eOption = typePrint.actionMenuPrint("E-Book");

                if (eOption == 'A') {
                    EBook eBook = typePrint.getEBookDetails();
                    digitalLibraryServiceImpl.addEBook(eBook);

                } else if (eOption == 'B') {
                    System.out.println("Remove an E-Book: ");
                    System.out.print("Enter ISBN: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    digitalLibraryServiceImpl.deleteEBook(isbn);

                } else if (eOption == 'C') {
                    System.out.println("Search for an E-Book: ");
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    digitalLibraryServiceImpl.searchEBook(title);

                } else if (eOption == 'D') {
                    System.out.println("Goodbye!");
                    break;

                } else {
                    System.out.println("Invalid choice");
                }
            }


        }

        scanner.close();
        } catch (InvalidInputTypeException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
