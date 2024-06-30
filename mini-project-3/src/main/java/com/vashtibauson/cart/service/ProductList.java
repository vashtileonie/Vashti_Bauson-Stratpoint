package com.vashtibauson.cart.service;

import com.vashtibauson.cart.model.Product;

import java.util.List;

public interface ProductList {
    List<Product> getProducts();
    void displayProducts();
}
