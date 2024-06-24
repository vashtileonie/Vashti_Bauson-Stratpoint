package org.example;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("Hello! Choose your desired action: ");
            System.out.println("A- Add a new book");
            System.out.println("B- Remove an existing book");
            System.out.println("C- Search for a book");
            System.out.println("D- Quit");
            System.out.println("=============================================");
            char option = scanner.next().charAt(0);
            scanner.nextLine();  // Consume newline

            if(option == 'A'){
                System.out.println("Add a Book: ");
                System.out.println("Enter the title: ");
                String title = scanner.nextLine();
                System.out.println("Enter Author: ");
                String author = scanner.nextLine();
                System.out.println("Enter ISBN: ");
                int isbn = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                library.addBook(title, author, isbn);

            } else if(option == 'B'){
                System.out.println("Remove a Book: ");
                System.out.println("Enter ISBN: ");
                int isbn = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                library.deleteBook(isbn);

            } else if(option == 'C'){
                System.out.println("Search for a Book: ");
                System.out.println("Enter the title: ");
                String title = scanner.nextLine();
                String author = scanner.nextLine();
                int isbn = scanner.nextInt();

                library.searchBook(title, author, isbn);

            } else if (option == 'D') {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}
