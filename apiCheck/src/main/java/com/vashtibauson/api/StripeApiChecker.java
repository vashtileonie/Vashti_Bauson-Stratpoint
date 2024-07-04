package com.vashtibauson.api;

import com.stripe.Stripe;
import com.stripe.model.Balance;

public class StripeApiChecker {
    public static void main(String[] args) {
        // Set your Stripe API key
        String apiKey = "sk_test_51PYhYURoq8wyEEyAN6FXGGPXkeXfDwl0akW8QpCCHANnYQKiwUAZAemn0vcrmzvU7493L6bFaSPVniHzULzwM2Ov00SIOnBc3X";
        try {
            // Initialize the Stripe API with your key
            Stripe.apiKey = apiKey;

            // Fetch the balance
            Balance balance = Balance.retrieve();

            // Print the balance details
            System.out.println("Stripe API is working! Balance: " + balance);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Stripe API is not working. Error: " + e.getMessage());
        }
    }
}