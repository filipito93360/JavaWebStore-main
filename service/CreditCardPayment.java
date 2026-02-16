package JavaWebStore.service;

import JavaWebStore.interfaces.Payment;
import JavaWebStore.exceptions.OnlineStoreException;

public class CreditCardPayment implements Payment {
    
    private String cardNumber;
    private String cardHolder;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolder, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) throws OnlineStoreException {
        
        if (cardNumber == null || cardNumber.length() != 16) throw new OnlineStoreException("Invalid credit card number.");

        if (cvv == null || cvv.length() != 3) throw new OnlineStoreException("Invalid CVV.");

        if (amount <= 0) throw new OnlineStoreException("Invalid payment amount.");

        System.out.println("Processing credit card payment of $" + amount + "...");
        System.out.println("Payment successful!");

        return true;
    }
}
