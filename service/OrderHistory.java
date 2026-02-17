package JavaWebStore.service;

import JavaWebStore.model.Order;
import java.util.ArrayList;

/**
 * This class is representing the history of orders a person have done in our OnlineStore
 */

public class OrderHistory {
    
    private ArrayList<Order> orders;

    /**
     * Default constructor of the OrderHistory class. It initializes an empty list of orders
     */

    public OrderHistory() {
        orders = new ArrayList<>();
    }

    /**
     * Method to add an order to the OrderHistory Class
     * @param order the order just made by the customer that has to be added to the OrderHistory's list
     */

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order saved successfully.");
    }

    /**
     * Methods that display all the Orders contained in the OrderHistory's list
     */

    public void displayAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No past orders.");
            return;
        }

        for (Order order : orders) order.displayOrder();
    }
}
