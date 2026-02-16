package JavaWebStore.model;

public class ProductReview {
    private String productID;
    private String userName;
    private String productName;
    private String reviewMessage;
    private double grade;

    public ProductReview(String productID, String userName, String productName, String reviewMessage, double grade) {
        this.productID = productID;
        this.userName = userName;
        this.productName = productName;
        this.reviewMessage = reviewMessage;
        this.grade = grade;
    }

    public ProductReview(Product product, String userName, String reviewMessage, double grade) {
        this.productID = product.getProductID();
        this.userName = userName;
        this.productName = product.getName();
        this.reviewMessage = reviewMessage;
        this.grade = grade;
    }

    public void makeAReview(String review, double grade) {
        this.reviewMessage = review;
        this.grade = grade;
    }
    public void makeAReview(String review) {
        this.reviewMessage = review;
    }
}
