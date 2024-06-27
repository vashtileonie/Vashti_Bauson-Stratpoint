package com.vashtibauson.library;

import com.vashtibauson.library.exception.InvalidInputTypeException;
import com.vashtibauson.library.model.Book;
import com.vashtibauson.library.model.EBook;

import java.util.Scanner;

public class Print {
    // Scanner object for user input
    private Scanner scanner;

    // Constructor to initialize the scanner
    public Print(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method to print item type selection menu and get the user's choice
    public int itemTypePrint() throws InvalidInputTypeException {
        System.out.println("---------------------------------------------");
        System.out.println("What is your desired item?: ");
        System.out.println("1- Book");
        System.out.println("2- Ebook");
        System.out.println("---------------------------------------------");
        System.out.print("Type of item: ");

        // Check if the input is an integer
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.nextLine();  // Consume the invalid input
            throw new InvalidInputTypeException("Invalid input type. Please enter a number.");
        }
    }

    // Method to print action menu and get the user's choice
    public char actionMenuPrint(String itemType) throws InvalidInputTypeException {
        System.out.println("\n=================WELCOME==================");
        System.out.println("Hello! Choose your desired action: ");
        System.out.println("A- Add a new " + itemType.toLowerCase());
        System.out.println("B- Remove an existing " + itemType.toLowerCase());
        System.out.println("C- Search for a " + itemType.toLowerCase());
        System.out.println("D- Quit");
        System.out.println("=============================================");
        System.out.print("Option: ");

        // Check if the input is a character
        if (scanner.hasNext()) {
            char option = scanner.next().charAt(0);
            scanner.nextLine();  // Consume newline
            return Character.toUpperCase(option);
        } else {
            scanner.nextLine();  // Consume the invalid input
            throw new InvalidInputTypeException("Invalid input type. Please enter a character.");
        }
    }


    // Method to get details for a new book from the user
    public Book getBookDetails() throws InvalidInputTypeException {
        String type = "Book";
        System.out.println("Add a Book: ");
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");

        // Check if the input for ISBN is an integer
        if (scanner.hasNextInt()) {
            int isbn = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            return new Book(title, author, isbn, type);
        } else {
            scanner.nextLine();  // Consume the invalid input
            throw new InvalidInputTypeException("Invalid input type. ISBN must be an integer.");
        }
    }

    // Method to get details for a new eBook from the user
    public EBook getEBookDetails() throws InvalidInputTypeException {
        String type = "E-Book";
        System.out.println("Add an E-Book: ");
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");

        int isbn;
        // Check if the input for ISBN is an integer
        if (scanner.hasNextInt()) {
            isbn = scanner.nextInt();
            scanner.nextLine();  // Consume newline
        } else {
            scanner.nextLine();  // Consume the invalid input
            throw new InvalidInputTypeException("Invalid input type. ISBN must be an integer.");
        }

        System.out.print("Enter file size (mb): ");

        double fileSize;
        // Check if the input for file size is a double
        if (scanner.hasNextDouble()) {
            fileSize = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
        } else {
            scanner.nextLine();  // Consume the invalid input
            throw new InvalidInputTypeException("Invalid input type. File size must be a number.");
        }

        System.out.print("Enter file format: ");
        String format = scanner.nextLine();

        // Create and return a new EBook object with the provided details
        return new EBook(type, title, author, isbn, fileSize, format);
    }
}
