package org.stratpoint.project2.vbauson;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        DigitalLibrary digitalLibrary= new DigitalLibrary();

        Print typePrint = new Print(scanner);
        try {
        int itemType = typePrint.itemTypePrint();
        scanner.nextLine();  // Consume newline

        while (true) {
            if (itemType == 1) {
                char option = typePrint.actionMenuPrint("Book");


                if (option == 'A') {
                    Book book = typePrint.getBookDetails();
                    library.addBook(book);


                } else if (option == 'B') {
                    System.out.println("Remove a Book: ");
                    System.out.print("Enter ISBN: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    library.deleteBook(isbn);

                } else if (option == 'C') {
                    System.out.println("Search for a Book: ");
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    library.searchBook(title);

                } else if (option == 'D') {
                    System.out.println("Goodbye!");
                    break;

                } else {
                    System.out.println("Invalid choice");
                }
            } else if (itemType == 2) {
                char eOption = typePrint.actionMenuPrint("E-Book");

                if (eOption == 'A') {
                    String type = "E-Book";
                    System.out.println("Add an E-Book: ");
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    int isbn = scanner.nextInt();
                    System.out.print("Enter file size (mb): ");
                    double fileSize = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter file format: ");
                    String format = scanner.nextLine();


                    digitalLibrary.addEBook(type, title, author, isbn, fileSize, format);

                } else if (eOption == 'B') {
                    System.out.println("Remove an E-Book: ");
                    System.out.print("Enter ISBN: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    digitalLibrary.deleteEBook(isbn);

                } else if (eOption == 'C') {
                    System.out.println("Search for an E-Book: ");
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    digitalLibrary.searchEBook(title);

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
