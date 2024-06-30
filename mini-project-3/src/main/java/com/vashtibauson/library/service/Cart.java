package com.vashtibauson.library.service;

import com.vashtibauson.library.model.Product;

import java.util.List;

public interface Cart {

        void addProduct(Product product);
        void viewCart();
        void calculateTotal();
        List<Product> getItems(); // Add this method to retrieve items in the cart
}
