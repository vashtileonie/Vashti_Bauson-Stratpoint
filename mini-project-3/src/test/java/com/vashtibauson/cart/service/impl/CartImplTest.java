package com.vashtibauson.cart.service.impl;

import com.vashtibauson.cart.model.Product;
import com.vashtibauson.cart.service.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Unit tests for the CartImpl class.
 */
class CartImplTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new CartImpl(); // Initialize cart instance
    }

    /**
     * Test case for adding products to the cart.
     */
    @Test
    void addProduct() {
        Product laptop = new Product("Microphone", 10000);
        Product dongle = new Product("Dongle", 1500);

        // Add products to the cart
        cart.addProduct(laptop);
        cart.addProduct(dongle);

        // Retrieve items from the cart
        List<Product> items = cart.getItems();

        // Assertions
        assertEquals(2, items.size()); // Check if two products are added
        assertTrue(items.contains(laptop)); // Check if laptop is in the cart
        assertTrue(items.contains(dongle)); // Check if dongle is in the cart
    }

    /**
     * Test case for viewing cart items.
     */
    @Test
    void viewCart() {
        Product laptop = new Product("Microphone", 10000);
        Product dongle = new Product("Dongle", 1500);

        // Add products to the cart
        cart.addProduct(laptop);
        cart.addProduct(dongle);

        // Redirect console output to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call viewCart method to print cart items
        cart.viewCart();

        // Expected output string
        String expectedOutput = "Cart items:\n- Microphone: PHP10000.0\n- Dongle: PHP1500.0";

        // Assertions
        assertEquals(expectedOutput.trim(), outContent.toString().trim()); // Compare actual output with expected output
    }

    /**
     * Test case for calculating total price of cart items.
     */
    @Test
    void calculateTotal() {
        Product laptop = new Product("Microphone", 10000);
        Product dongle = new Product("Dongle", 1500);

        // Add products to the cart
        cart.addProduct(laptop);
        cart.addProduct(dongle);

        // Redirect console output to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call calculateTotal method to print total price
        cart.calculateTotal();

        // Expected output string
        String expectedOutput = "Total price: PHP11500.0";

        // Assertions
        assertEquals(expectedOutput.trim(), outContent.toString().trim()); // Compare actual output with expected output
    }

}
