package com.vashtibauson.library.service.Impl;

import com.vashtibauson.library.model.Product;
import com.vashtibauson.library.service.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartImplTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new CartImpl();
    }

    @Test
    void addProduct() {
        Product laptop = new Product("Laptop", 1000);
        Product phone = new Product("Phone", 500);

        cart.addProduct(laptop);
        cart.addProduct(phone);

        List<Product> items = cart.getItems();
        assertEquals(2, items.size());
        assertTrue(items.contains(laptop));
        assertTrue(items.contains(phone));
    }

    @Test
    void viewCart() {
        Product laptop = new Product("Laptop", 1000);
        Product phone = new Product("Phone", 500);

        cart.addProduct(laptop);
        cart.addProduct(phone);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        cart.viewCart();

        String expectedOutput = "Cart items:\n- Laptop: PHP1000.0\n- Phone: PHP500.0";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    void calculateTotal() {
        Product laptop = new Product("Laptop", 1000);
        Product phone = new Product("Phone", 500);

        cart.addProduct(laptop);
        cart.addProduct(phone);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        cart.calculateTotal();

        String expectedOutput = "Total price: PHP1500.0";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }
}
