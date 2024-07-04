package com.vashtibauson.api;
import com.stripe.Stripe;
import com.stripe.model.Balance;

public class StripeApiChecker {
    public static void main(String[] args) {
        // Set your Stripe API key
        String apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc"; // Replace with your actual Stripe Secret key

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