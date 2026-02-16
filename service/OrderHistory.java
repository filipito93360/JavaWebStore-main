package JavaWebStore.service;

import JavaWebStore.model.Order;
import java.util.ArrayList;

public class OrderHistory {
    
    private ArrayList<Order> orders;

    public OrderHistory() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order saved successfully.");
    }

    public void displayAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No past orders.");
            return;
        }

        for (Order order : orders) order.displayOrder();
    }
}
