package com.vashtibauson.cart.service;

import com.vashtibauson.cart.model.Product;

import java.util.List;

/**
 * Interface representing a product catalog.
 * Defines methods to retrieve a list of products and display them.
 */
public interface ProductList {

    /**
     * Retrieves the list of products in the catalog.
     *
     * @return the list of products
     */
    List<Product> getProducts();

    /**
     * Displays the list of products in the catalog.
     * Prints each product in a formatted manner.
     */
    void displayProducts();
}
