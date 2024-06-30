package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.Product;
import com.vashtibauson.library.service.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements Cart {
    // Attribute: list to store products
    private List<Product> items;

    // Constructor
    public CartImpl() {
        items = new ArrayList<>();
    }

    // Method to add a product to the cart
    public void addProduct(Product product) {
        items.add(product);
        // Print a confirmation message
        System.out.println("Added " + product.getName() + " to the cart.");
    }

    // Method to view the cart
    public void viewCart() {
        if (items.isEmpty()) {
            // Print if the cart is empty
            System.out.println("The cart is empty.");
            return;
        }
        // Print the cart items
        System.out.println("Cart items:");
        for (Product item : items) {
            System.out.println("- " + item.getName() + ": PHP" + item.getPrice());
        }
    }
    // Method to calculate the total price
    public void calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        // Print the total price
        System.out.println("Total price: PHP" + total);
    }

    @Override
    public List<Product> getItems() {
        return items; // Implement the method to return the list of items
    }


}
