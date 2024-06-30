package com.vashtibauson.cart.service.impl;

import com.vashtibauson.cart.Main;
import com.vashtibauson.cart.model.Product;
import com.vashtibauson.cart.service.Cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Implementation of the Cart service that manages a collection of products.
 */
public class CartImpl implements Cart {
   // private static final Logger logger = LoggerFactory.getLogger(CartImpl.class);

    // Attribute: list to store products in the cart
    private final List<Product> items;

    /**
     * Constructs an empty cart.
     */
    public CartImpl() {
        items = new ArrayList<>();
    }

    /**
     * Adds a product to the cart and logs the addition.
     *
     * @param product the product to add to the cart
     */
    public void addProduct(Product product) {
        items.add(product);
        // Print confirmation message to console
        System.out.println("Added " + product.getName() + " to the cart.");
        // Log the addition of an item
      //  logger.info("Item Added");
    }

    /**
     * Displays the contents of the cart or notifies if empty.
     */
    public void viewCart() {
        if (items.isEmpty()) {
            // Print message if cart is empty
            System.out.println("The cart is empty.");
            // Log that the cart is empty
          //  logger.info("Cart is empty.");
            return;
        }
        // Print heading for cart items
        System.out.println("Cart items:");
        // Format numbers to show currency properly
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        // Iterate through items and print each with formatted price
        for (Product item : items) {
            System.out.printf("- %s: PHP%s%n", item.getName(), formatter.format(item.getPrice()));
            // Log that the cart is displayed
         //   logger.info("Cart is displayed.");
        }
    }

    /**
     * Calculates and prints the total price of all items in the cart.
     */
    public void calculateTotal() {
        double total = 0;
        // Calculate total price by summing up each item's price
        for (Product item : items) {
            total += item.getPrice();
        }
        // Format total price for proper currency display
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        // Print total price with currency symbol
        System.out.println("Total price: PHP" + formatter.format(total));
        // Log that total is calculated
       // logger.info("Total is calculated.");
    }

    /**
     * Retrieves the list of items currently in the cart.
     *
     * @return the list of items in the cart
     */
    @Override
    public List<Product> getItems() {
        return items;
    }
}
