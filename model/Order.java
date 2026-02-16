package JavaWebStore.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The class Order represents a list of product stocked as an order, it can be paid by credit card or with PayPal
 */

public class Order {
    
    private String orderID;
    private ArrayList<Product> items;
    private double totalAmount;
    private String paymentMethod;
    private LocalDateTime orderDate;

    /**
     * Initialisation Constructor of the Order class
     * @param orderID ID of the Order (unique)
     * @param items List of the products of the orders
     * @param totalAmount Total amount needed to pay the order
     * @param paymentMethod Either paypal or a credit card
     */

    public Order(String orderID, ArrayList<Product> items, double totalAmount, String paymentMethod) {
        this.orderID = orderID;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.orderDate = LocalDateTime.now();
    }

    /**
     * Getter of the id
     * @return
     */

    public String getOrderID() {
        return orderID;
    }

    /**
     * Getter of the total amount required to pay
     * @return
     */

    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Getter of the paymentMethod
     * @return
     */

    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Getter of the date
     * @return
     */

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    /**
     * Method to diplay the order's info
     */

    public void displayOrder() {
        System.out.println("\n===== ORDER =====");
        System.out.println("Order ID: " + orderID);
        System.out.println("Date: " + orderDate);
        System.out.println("Payment: " + paymentMethod);
        System.out.println("Items:");

        for (Product p : items) System.out.println("- " + p);

        System.out.println("Total: $" + totalAmount);
        System.out.println("=================\n");
    }

}
