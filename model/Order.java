package JavaWebStore.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    
    private String orderID;
    private ArrayList<Product> items;
    private double totalAmount;
    private String paymentMethod;
    private LocalDateTime orderDate;

    public Order(String orderID, ArrayList<Product> items, double totalAmount, String paymentMethod) {
        this.orderID = orderID;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.orderDate = LocalDateTime.now();
    }

    public String getOrderID() {
        return orderID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

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
