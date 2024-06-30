package com.vashtibauson.cart.service.impl;

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
    private static final Logger logger = LoggerFactory.getLogger(CartImpl.class);

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
        logger.info("Item Added");
    }

    /**
     * Displays the contents of the cart or notifies if empty.
     */
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("The cart is empty.");
            logger.info("Cart is empty.");
            return;
        }

        System.out.println("Cart items:");
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        // Iterate through items using lambda expression to print each item with formatted price
        items.forEach(item -> System.out.printf("- %s: PHP%s%n", item.getName(), formatter.format(item.getPrice())));
    }

    /**
     * Calculates and prints the total price of all items in the cart.
     */
    public void calculateTotal() {
        // Use stream and lambda expression to calculate total price
        double total = items.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        System.out.println("Total price: PHP" + formatter.format(total));
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
