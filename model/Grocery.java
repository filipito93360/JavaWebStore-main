package JavaWebStore.model;

import java.time.LocalDate;

/**
 * The class Grocery, extended from Product, permits to represent food on our online store
 */

public class Grocery extends Product {
    
    private LocalDate expirationDate;
    private String category;

    /**
     * Initialisation constructor of the Grocery class
     * @param productID The Grocery's ID (G[1-50] in our store
     * @param name Grocery's name
     * @param price Grocery's price
     * @param description Grocery's description
     * @param expirationDate Grocery's expirationDate
     * @param category Grocery's category
     */

    public Grocery(String productID, String name, double price, String description, LocalDate expirationDate, String category) {
        super(productID, name, price, description);
        this.expirationDate = expirationDate;
        this.category = category;
    }

    /**
     * Method to apply a discount on the grocery
     * @param percentage the percentage of the discount
     */

    @Override
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    /**
     * Returns the groceries category
     * @return The Grocery String
     */

    @Override
    public String getCategory() {
        return "Grocery";
    }
}
