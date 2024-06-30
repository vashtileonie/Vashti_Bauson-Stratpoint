package com.vashtibauson.library.service;

import com.vashtibauson.library.model.Product;

import java.util.List;

public interface ProductList {
    List<Product> getProducts();
    void displayProducts();
}
