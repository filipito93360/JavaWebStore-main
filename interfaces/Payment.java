package JavaWebStore.interfaces;

import JavaWebStore.exceptions.OnlineStoreException;

/**
 * Payment interface implementad by CrediCardPayment and PayPalPayment classes
 */

public interface Payment {
    boolean pay(double amount) throws OnlineStoreException;
}
