package JavaWebStore.model;

/**
 * Class meant to be a feedback class for the customer
 */

public class ProductReview {
    private String productID;
    private String userName;
    private String productName;
    private String reviewMessage;
    private double grade;

    /**
     * Initialisation Constructor for the ProductReview class
     * @param productID ID of the reviewed product
     * @param userName Name of the user making the review
     * @param productName Name of the product reviewed
     * @param reviewMessage Message of the user to make the review
     * @param grade Grade from the user's point of view
     */

    public ProductReview(String productID, String userName, String productName, String reviewMessage, double grade) {
        this.productID = productID;
        this.userName = userName;
        this.productName = productName;
        this.reviewMessage = reviewMessage;
        this.grade = grade;
    }

    /**
     * Same constructor but with a Product object
     * @param product a product, it contains the id and the name of the product
     * @param userName Name of the user making the review
     * @param reviewMessage essage of the user to make the review
     * @param grade Grade from the user's point of view
     */

    public ProductReview(Product product, String userName, String reviewMessage, double grade) {
        this.productID = product.getProductID();
        this.userName = userName;
        this.productName = product.getName();
        this.reviewMessage = reviewMessage;
        this.grade = grade;
    }

    /**
     * Function to make a review
     * @param review Message of the user
     * @param grade Grade given by the user
     */

    public void makeAReview(String review, double grade) {
        this.reviewMessage = review;
        this.grade = grade;
    }

    /**
     * Same but without grade
     * @param review Message of the user
     */

    public void makeAReview(String review) {
        this.reviewMessage = review;
    }
}
