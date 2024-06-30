package com.vashtibauson.cart.service.impl;

import com.vashtibauson.cart.Main;
import com.vashtibauson.cart.model.Product;
import com.vashtibauson.cart.service.ProductList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a product catalog that provides a list of predefined products.
 */
public class ProductListImpl implements ProductList {
    private static final Logger logger = LoggerFactory.getLogger(ProductListImpl.class);

    // Attribute: list to store products
    private List<Product> products;

    /**
     * Constructs a ProductListImpl with a predefined list of products.
     * Initializes and adds products to the catalog.
     */
    public ProductListImpl() {
        products = new ArrayList<>();
        // Hardcoded list of products
        products.add(new Product("Laptop", 60000));
        products.add(new Product("Phone", 40000));
        products.add(new Product("Tablet", 30000));
        products.add(new Product("Headphones", 15000));
        products.add(new Product("Smartwatch", 20000));
    }

    /**
     * Retrieves the list of products available in the catalog.
     *
     * @return the list of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Displays the list of products in the catalog.
     * Prints each product with its index and formatted price.
     */
    public void displayProducts() {
        System.out.println("Product Catalog:");
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            System.out.printf("%d. %s: PHP%.2f%n", (i + 1), item.getName(), item.getPrice());
            // Log that the product list is displayed
            logger.info("Product list displayed.");
        }
    }
}
