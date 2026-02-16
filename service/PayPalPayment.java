package JavaWebStore.service;

import JavaWebStore.interfaces.Payment;
import JavaWebStore.exceptions.OnlineStoreException;

public class PayPalPayment implements Payment {
    
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) throws OnlineStoreException {
        
        if (email == null || !email.contains("@")) throw new OnlineStoreException("Invalid PayPal email.");

        if (amount <= 0) throw new OnlineStoreException("Invalid payment amount.");

        System.out.println("Processing PayPal payment of $" + amount + "...");
        System.out.println("Payment successful!");

        return true;
    }
}
