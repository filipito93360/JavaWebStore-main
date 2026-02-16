package JavaWebStore.model;

/**
 * The class Clothing, extended from Product, is a representation of Clothing in our online web strore
 */

public class Clothing extends Product {
    
    private String size;
    private String material;

    /**
     * Initialisation constructor of the Clothing Class
     * @param productID unique ID of a clothing Product (C[1-25] for our project)
     * @param name clothing's name
     * @param price clothing's price
     * @param description clothing's description
     * @param size clothing's size
     * @param material matériaux du vêtement
     */

    public Clothing(String productID, String name, double price, String description, String size, String material) {
        super(productID, name, price, description);
        this.size = size;
        this.material = material;
    }

    /**
     * Méthod to apply a discount to the price
     * @param percentage percentage of the discount
     */

    @Override
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    /**
     * Function to retrieve the category of a clothing
     * @return The category with a String
     */

    @Override
    public String getCategory() {
        return "Clothing";
    }
}
