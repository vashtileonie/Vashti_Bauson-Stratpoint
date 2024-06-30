package com.vashtibauson.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vashtibauson.cart.model.Product;
import com.vashtibauson.cart.service.Cart;
import com.vashtibauson.cart.service.ProductList;
import com.vashtibauson.cart.service.impl.CartImpl;
import com.vashtibauson.cart.service.impl.ProductListImpl;

import java.util.List;
import java.util.Scanner;

/**
 * Main class to demonstrate a shopping cart application.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Main method to start the shopping cart application.
     *
     * @param args command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a product catalog
        ProductList productList = new ProductListImpl();

        // Display the product catalog
        productList.displayProducts();

        // Create a cart
        Cart cart = new CartImpl();

        // Get the list of products from the catalog
        List<Product> products = productList.getProducts();

        // Prompt user to add products to the cart based on input
        while (true) {
            System.out.print("Enter the number of the product to add to the cart (0 to exit the cart): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 0) {
                    logger.info("Closing Cart");
                    break;
                } else if (choice > 0 && choice <= products.size()) {
                    logger.info("Item Added");
                    cart.addProduct(products.get(choice - 1)); // Add selected product to the cart
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                logger.info("Invalid Input");
            }
        }

        // View the contents of the cart
        cart.viewCart();

        // Calculate and display the total price of items in the cart
        cart.calculateTotal();

        // Close the scanner
        scanner.close();
    }
}
