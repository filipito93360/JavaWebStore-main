package JavaWebStore.model;

import JavaWebStore.interfaces.Discountable;

public abstract class Product implements Discountable {

    protected String productID;
    protected String name;
    protected double price;
    protected String description;

    public Product(String productID, String name, double price, String description) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return "[" + getCategory() + "] " + name + " - $" + price;
    }
}