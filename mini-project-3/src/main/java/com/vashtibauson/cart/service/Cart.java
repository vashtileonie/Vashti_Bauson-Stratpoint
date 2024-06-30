package com.vashtibauson.cart.service;

import com.vashtibauson.cart.model.Product;

import java.util.List;

public interface Cart {

    void addProduct(Product product);

    void viewCart();

    void calculateTotal();

    List<Product> getItems();
}
