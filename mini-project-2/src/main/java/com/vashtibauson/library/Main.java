package com.vashtibauson.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vashtibauson.library.exception.InvalidInputTypeException;
import com.vashtibauson.library.model.Book;
import com.vashtibauson.library.model.EBook;
import com.vashtibauson.library.service.Impl.DigitalLibraryServiceImpl;
import com.vashtibauson.library.service.Impl.LibraryServiceImpl;

import java.util.Scanner;

/**
 * Main class for the library management application.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Main method to start the library management application.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create instances of the library service implementations
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        DigitalLibraryServiceImpl digitalLibraryServiceImpl = new DigitalLibraryServiceImpl();

        // Create an instance of the Print class for user interaction
        Print typePrint = new Print(scanner);

        try {
            // Get the item type (Book or E-Book) from the user
            int itemType = typePrint.itemTypePrint();
            scanner.nextLine();  // Consume the newline character

            // Loop to perform actions until the user decides to exit
            while (true) {
                if (itemType == 1) { // If item type is Book
                    // Display action menu and get user choice
                    char option = typePrint.actionMenuPrint("Book");

                    if (option == 'A') { // Add a new book
                        Book book = typePrint.getBookDetails();
                        libraryServiceImpl.addBook(book);
                        logger.info("Added a new book: {}", book.getTitle());

                    } else if (option == 'B') { // Remove a book
                        System.out.println("Remove a Book: ");
                        System.out.print("Enter ISBN: ");
                        int isbn = scanner.nextInt();
                        scanner.nextLine();  // Consume the newline character

                        libraryServiceImpl.deleteBook(isbn);
                        logger.info("Removed book with ISBN: {}", isbn);

                    } else if (option == 'C') { // Search for a book
                        System.out.println("Search for a Book: ");
                        System.out.print("Enter the title: ");
                        String title = scanner.nextLine();
                        libraryServiceImpl.searchBook(title);

                    } else if (option == 'D') { // Exit
                        System.out.println("Goodbye!");
                        logger.info("Terminated");
                        break;

                    } else { // Invalid choice
                        System.out.println("Invalid choice");
                    }
                } else if (itemType == 2) { // If item type is E-Book
                    // Display action menu and get user choice
                    char eOption = typePrint.actionMenuPrint("E-Book");

                    if (eOption == 'A') { // Add a new eBook
                        EBook eBook = typePrint.getEBookDetails();
                        digitalLibraryServiceImpl.addEBook(eBook);
                        logger.info("Added a new E-Book: {}", eBook.getTitle());

                    } else if (eOption == 'B') { // Remove an eBook
                        System.out.println("Remove an E-Book: ");
                        System.out.print("Enter ISBN: ");
                        int isbn = scanner.nextInt();
                        scanner.nextLine();  // Consume the newline character
                        logger.info("Removed an E-Book with ISBN: {}", isbn);

                        digitalLibraryServiceImpl.deleteEBook(isbn);

                    } else if (eOption == 'C') { // Search for an eBook
                        System.out.println("Search for an E-Book: ");
                        System.out.print("Enter the title: ");
                        String title = scanner.nextLine();
                        digitalLibraryServiceImpl.searchEBook(title);

                    } else if (eOption == 'D') { // Exit
                        System.out.println("Goodbye!");
                        logger.info("Terminated");
                        break;

                    } else { // Invalid choice
                        System.out.println("Invalid choice");
                    }
                } else if (itemType == 3){
                    System.out.println("Goodbye!");
                    logger.info("Terminated");
                    break;
                }
            }

            // Close the scanner
            scanner.close();

        } catch (InvalidInputTypeException e) { // Handle invalid input type exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}
