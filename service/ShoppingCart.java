package JavaWebStore.service;

import JavaWebStore.model.Product;
import java.util.ArrayList;
import JavaWebStore.interfaces.Payment;
import JavaWebStore.exceptions.OnlineStoreException;
import JavaWebStore.model.Order;

public class ShoppingCart {

    private ArrayList<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeProduct(String productID) {
        items.removeIf(p -> p.getProductID().equals(productID));
        System.out.println("Product removed from cart.");
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) total += p.getPrice();
        return total;
    }

    public double calculateTotalRecursive() {
        return calculateRecursive(0);
    }

    private double calculateRecursive(int index) {
        if (index >= items.size()) return 0;
        return items.get(index).getPrice() + calculateRecursive(index + 1);
    }

    public void clearCart() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (Product p : items) System.out.println(p);

        System.out.println("Total: $" + calculateTotal());
    }

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
