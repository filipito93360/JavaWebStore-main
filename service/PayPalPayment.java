package JavaWebStore.service;

import JavaWebStore.interfaces.Payment;
import JavaWebStore.exceptions.OnlineStoreException;

/**
 * Another way of paying an order: the PayPalPayment class
 *
 */

public class PayPalPayment implements Payment {
    
    private String email;

    /**
     * Initialisation constructor of the PayPalPayment class
     * @param email the email of the user
     */

    public PayPalPayment(String email) {
        this.email = email;
    }

    /**
     * Pay method implemented from the Payment interface, throws OnlineStoreException
     * @param amount The amount that needs to be paid
     * @return A boolean (true if zero exception throwed)
     * @throws OnlineStoreException The general exception for our store (various messages)
     */

    @Override
    public boolean pay(double amount) throws OnlineStoreException {
        
        if (email == null || !email.contains("@")) throw new OnlineStoreException("Invalid PayPal email.");

        if (amount <= 0) throw new OnlineStoreException("Invalid payment amount.");

        System.out.println("Processing PayPal payment of $" + amount + "...");
        System.out.println("Payment successful!");

        return true;
    }
}
