package com.vashtibauson.library.service;

import com.vashtibauson.library.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    // Attribute: list to store products
    private List<Product> products;

    // Constructor
    public ProductList() {
        products = new ArrayList<>();
        // Hardcoded list of products
        products.add(new Product("Laptop", 1000));
        products.add(new Product("Phone", 500));
        products.add(new Product("Tablet", 300));
        products.add(new Product("Headphones", 150));
        products.add(new Product("Smartwatch", 200));
    }

    // Method to get the list of products
   public List<Product> getProducts() {
        return products;
    }

    // Method to display the products in the catalog
    public void displayProducts() {
        System.out.println("Product Catalog:");
        for (int i = 0; i < products.size(); i++ ) {
            Product item = products.get(i);
            System.out.println((i + 1) + ". " + item.getName() + ": $" + item.getPrice());
        }
    }

}
