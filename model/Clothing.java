package JavaWebStore.model;

public class Clothing extends Product {
    
    private String size;
    private String material;

    public Clothing(String productID, String name, double price, String description, String size, String material) {
        super(productID, name, price, description);
        this.size = size;
        this.material = material;
    }

    @Override
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}
