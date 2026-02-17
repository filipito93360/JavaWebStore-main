package JavaWebStore.service;

import JavaWebStore.model.Product;
import java.util.ArrayList;
import JavaWebStore.interfaces.Payment;
import JavaWebStore.exceptions.OnlineStoreException;
import JavaWebStore.model.Order;

/**
 * the class shopping cart represents a shopping cart that empties itself when an order is passed.
 * It's like a temporary list that's added to the order object when the order is passed.
 */

public class ShoppingCart {

    private ArrayList<Product> items;

    /**
     * Default constructor that initializes an empty list when the ShoppingCart's instance is created
     */

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * Method to add a product in the Cart
     * @param product the product that's being added to the cart
     */

    public void addProduct(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    /**
     * Method used to remove an object of an order
     * @param productID th id of the object that we want to remove
     */

    public void removeProduct(String productID) {
        items.removeIf(p -> p.getProductID().equals(productID));
        System.out.println("Product removed from cart.");
    }

    /**
     * Getter of the products list
     * @return the list of products of the cart
     */

    public ArrayList<Product> getItems() {
        return items;
    }

    /**
     * Method to calculate the total price of an order involving the ShoppingCart's instance
     * @return
     */

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) total += p.getPrice();
        return total;
    }

    /**
     * Same method but with a recursive approach
     * @return the total sum of the prices of the products
     */

    public double calculateTotalRecursive() {
        return calculateRecursive(0);
    }

    /**
     * Same method but by ignoring some object (not approved to use, prefer the calculateTotalRecursive)
     * @param index The index we start from
     * @return the sum of the products that have an index equal or superior to the index argument
     */

    private double calculateRecursive(int index) {
        if (index >= items.size()) return 0;
        return items.get(index).getPrice() + calculateRecursive(index + 1);
    }

    /**
     * Method to remove all products from the cart.
     */

    public void clearCart() {
        items.clear();
    }

    /**
     * Method to check if the cart is empty or not
     * @return boolean true if empty, false otherwise
     */

    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Method to display all the products of the cart
     */

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (Product p : items) System.out.println(p);

        System.out.println("Total: $" + calculateTotal());
    }

    /**
     * Method to make the checkout of the cart that generates an Order object
     * @param payment A payment method chose by the user
     * @param orderID The id of the order
     * @return The Order created with the infos
     * @throws OnlineStoreException the exception occurs when the cart is empty or if the payment fails
     */

    public Order checkout(Payment payment, String orderID) throws OnlineStoreException{

        if (isEmpty()) throw new OnlineStoreException("Cannot checkout an empty cart.");

        double total = calculateTotal();

        if (payment.pay(total)) {
            Order order = new Order(orderID, items, total, payment.getClass().getSimpleName());
            clearCart();
            return order;
        }

        throw new OnlineStoreException("Payment failed.");
    }
}
