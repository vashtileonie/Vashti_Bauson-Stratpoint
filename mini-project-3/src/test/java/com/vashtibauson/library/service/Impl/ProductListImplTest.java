package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.Product;
import com.vashtibauson.library.service.ProductList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductListImplTest {
    private ProductList productList;

    @BeforeEach
    void setUp() {
        productList = new ProductListImpl();
    }

    @Test
    void displayProducts() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        productList.displayProducts();

        String expectedOutput = "Product Catalog:\n1. Laptop: $1000.0\n2. Phone: $500.0\n3. Tablet: $300.0\n4. Headphones: $150.0\n5. Smartwatch: $200.0";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    void getProducts() {
        List<Product> products = productList.getProducts();

        assertNotNull(products);
        assertEquals(5, products.size());

        Product laptop = products.get(0);
        assertEquals("Laptop", laptop.getName());
        assertEquals(1000.0, laptop.getPrice());

        Product phone = products.get(1);
        assertEquals("Phone", phone.getName());
        assertEquals(500.0, phone.getPrice());
    }
}