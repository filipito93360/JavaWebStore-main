package JavaWebStore.model;

import java.time.LocalDate;

public class Grocery extends Product {
    
    private LocalDate expirationDate;
    private String category;

    public Grocery(String productID, String name, double price, String description, LocalDate expirationDate, String category) {
        super(productID, name, price, description);
        this.expirationDate = expirationDate;
        this.category = category;
    }

    @Override
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    @Override
    public String getCategory() {
        return "Grocery";
    }
}
