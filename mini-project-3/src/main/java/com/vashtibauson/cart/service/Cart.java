package com.vashtibauson.cart.service;

import com.vashtibauson.cart.model.Product;

import java.util.List;

/**
 * Interface representing a shopping cart.
 * Defines methods to add products, view the cart contents, calculate the total price,
 * and retrieve the list of items in the cart.
 */
public interface Cart {

    /**
     * Adds a product to the cart.
     *
     * @param product the product to add
     */
    void addProduct(Product product);

    /**
     * Displays the contents of the cart.
     * Prints each product in the cart.
     */
    void viewCart();

    /**
     * Calculates and prints the total price of all items in the cart.
     */
    void calculateTotal();

    /**
     * Retrieves the list of items currently in the cart.
     *
     * @return the list of items in the cart
     */
    List<Product> getItems();
}
