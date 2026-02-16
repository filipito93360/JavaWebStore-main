package JavaWebStore.model;

public class Electronics extends Product {
    
    private int warrantyPeriod;
    private String band;

    public Electronics(String productID, String name, double price, String description, int warrantyPeriod, String band) {
        super(productID, name, price, description);
        this.warrantyPeriod = warrantyPeriod;
        this.band = band;
    }

    @Override
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
