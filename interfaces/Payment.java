package JavaWebStore.interfaces;

import JavaWebStore.exceptions.OnlineStoreException;

public interface Payment {
    boolean pay(double amount) throws OnlineStoreException;
}
