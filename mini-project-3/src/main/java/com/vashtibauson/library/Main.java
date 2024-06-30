package com.vashtibauson.library;

import com.vashtibauson.library.model.Product;
import com.vashtibauson.library.service.Cart;
import com.vashtibauson.library.service.ProductList;
import com.vashtibauson.library.service.Impl.CartImpl;
import com.vashtibauson.library.service.Impl.ProductListImpl;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a product catalog
        ProductList productList = new ProductListImpl();

        // Display the product catalog
        productList.displayProducts();

        // Create a cart
        Cart cart = new CartImpl();

        // Add products to the cart based on user input
        List<Product> products = productList.getProducts();

        while (true) {
            System.out.println("Enter the number of the product to add to the cart (0 to exit the cart:");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next(); // Clear invalid input
            }
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= products.size()) {
                cart.addProduct(products.get(choice - 1));
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // View the cart
        cart.viewCart();

        // Calculate the total price
        cart.calculateTotal();

        scanner.close();
    }
}
