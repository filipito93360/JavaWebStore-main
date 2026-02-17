package JavaWebStore.service;

import JavaWebStore.interfaces.Payment;
import JavaWebStore.exceptions.OnlineStoreException;

/**
 * Class that represents all the information of a credit card to use it when paying
 */

public class CreditCardPayment implements Payment {
    
    private String cardNumber;
    private String cardHolder;
    private String cvv;

    /**
     * Initialisation Constructor of the class CreditCardPayment
     * @param cardNumber the card's number
     * @param cardHolder the name of the card's holder
     * @param cvv the card's cvv code
     */

    public CreditCardPayment(String cardNumber, String cardHolder, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }

    /**
     * Pay method overrided from the pay method of the Payment interface, can throw the OnlineStoreException
     * @param amount The amount that is being paid
     * @return returns a boolean that is either true or not based if we throwed an exception
     * @throws OnlineStoreException The Exception created for ou OnlineStore, verifying the integrity of the card number
     */

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
