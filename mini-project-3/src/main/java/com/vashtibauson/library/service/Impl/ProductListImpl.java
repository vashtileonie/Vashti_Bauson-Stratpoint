package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.Product;
import com.vashtibauson.library.service.ProductList;

import java.util.ArrayList;
import java.util.List;

public class ProductListImpl implements ProductList {
    // Attribute: list to store products
    private List<Product> products;

    // Constructor
    public ProductListImpl() {
        products = new ArrayList<>();
        // Hardcoded list of products
        products.add(new Product("Laptop", 60000));
        products.add(new Product("Phone", 40000));
        products.add(new Product("Tablet", 30000));
        products.add(new Product("Headphones", 15000));
        products.add(new Product("Smartwatch", 20000));
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
            System.out.println((i + 1) + ". " + item.getName() + ": PHP" + item.getPrice());
        }
    }

}
