package JavaWebStore.model;

import JavaWebStore.interfaces.Discountable;

/**
 * Parent abstract class for the different types of products our store needs
 */

public abstract class Product implements Discountable {

    protected String productID;
    protected String name;
    protected double price;
    protected String description;

    /**
     * Initialisation constructor of the Product class
     * @param productID product ID
     * @param name Product's name
     * @param price Products's price
     * @param description Product's description
     */

    public Product(String productID, String name, double price, String description) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * Getter of the id
     * @return
     */

    public String getProductID() {
        return productID;
    }

    /**
     * Getter of the name
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * Getter of the price
     * @return
     */

    public double getPrice() {
        return price;
    }

    /**
     * Setter of the price
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter of the category
     * @return
     */

    public abstract String getCategory();

    /**
     * ToString method to represents what is a product
     * @return
     */

    @Override
    public String toString() {
        return "[" + getCategory() + "] " + name + " - $" + price;
    }
}