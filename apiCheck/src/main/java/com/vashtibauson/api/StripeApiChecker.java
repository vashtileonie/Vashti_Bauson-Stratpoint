package com.vashtibauson.api;

import com.stripe.Stripe;
import com.stripe.model.Balance;
import com.stripe.exception.StripeException;

public class StripeApiChecker {
    public static void main(String[] args) {
        // Set your Stripe API key

        // Fetch Stripe secret key from environment variable
        String stripeSecretKey = System.getenv("STRIPE_SECRET_KEY");

        // Check if the secret key is null or empty
        if (stripeSecretKey == null || stripeSecretKey.isEmpty()) {
            System.out.println("Stripe secret key is not set. Please set the STRIPE_SECRET_KEY environment variable.");
            return;
        }

        // Set the Stripe secret key
        Stripe.apiKey = stripeSecretKey;

        try {

            Balance balance = Balance.retrieve();
            System.out.println("Available balance: " + balance.getAvailable().get(0).getAmount() + " " + balance.getAvailable().get(0).getCurrency());
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }
}