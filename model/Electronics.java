package JavaWebStore.model;

/**
 * The class Electronics, Extended from Product, is a representation of all the electronics our store sells.
 */

public class Electronics extends Product {
    
    private int warrantyPeriod;
    private String brand;

    /**
     * Initialisation constructor of the Electronics class
     * @param productID The ID of the Electronics (E[1-25] for our store)
     * @param name Electronic's name
     * @param price Electronic's price
     * @param description Electronic's description
     * @param warrantyPeriod Electronic's warranty period
     * @param brand Electronic's brand
     */

    public Electronics(String productID, String name, double price, String description, int warrantyPeriod, String brand) {
        super(productID, name, price, description);
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    /**
     * Method to apply a discount on the price of the Electronic
     * @param percentage the percentage of the discount
     */

    @Override
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    /**
     * Returns the Electronics category
     * @return The Electronics String
     */

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
