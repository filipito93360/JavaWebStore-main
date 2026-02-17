package JavaWebStore.ui;

import JavaWebStore.model.*;
import JavaWebStore.service.*;
import JavaWebStore.interfaces.Payment;
import JavaWebStore.exceptions.OnlineStoreException;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main menu used in main to permit the user to do all the actions linked with the store
 */

public class MainMenu {

    private ArrayList<Product> products;
    private ShoppingCart cart;
    private OrderHistory history;
    private Scanner scanner;

    /**
     * Default Constructor initializing the attributes of the MainMenu class
     */

    public MainMenu() {
        products = new ArrayList<>();
        cart = new ShoppingCart();
        history = new OrderHistory();
        scanner = new Scanner(System.in);
        try{
            seedProducts();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    /**
     * Method that creates the products list with a .csv file
     * @throws FileNotFoundException occurs when the path precised leads to no file for the computer (the root can be the root of the project on IntelliJ)
     */

    private void seedProducts() throws FileNotFoundException {
        String csvFile = "ui/products.csv"; // Le chemin vers ton fichier
        String line = "";
        String csvSplitBy = ",";
        File file = new File(csvFile);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            String[] data = line.split(csvSplitBy);
            switch(line.charAt(0)){
                case 'C':
                    products.add(new Clothing(data[0], data[2], Double.parseDouble(data[3]), data[4], data[4], data[5]));
                    break;
                case 'E':
                    products.add(new Electronics(data[0], data[2], Double.parseDouble(data[3]), data[4], Integer.parseInt(data[6]), data[5]));
                    break;
                case 'G':
                    products.add(new Grocery(data[0], data[1], Double.parseDouble(data[2]), data[4], LocalDate.now().plusDays(Integer.parseInt(data[4])), data[5]));
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    /**
     * Method to display all the menu's options
     */

    public void start() {
        while (true) {

            System.out.println("\n==== ONLINE STORE ====");
            System.out.println("1. Browse Products");
            System.out.println("2. Search Products");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Order History");
            System.out.println("0. Exit");

            System.out.println("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> browseProducts();
                case 2 -> searchProduct();
                case 3 -> cart.displayCart();
                case 4 -> checkout();
                case 5 -> history.displayAllOrders();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * Method to browse the store's products
     */

    private void browseProducts() {

        System.out.println("\n--- Products ---");

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }

        System.out.println("Select product to add to cart (0 to cancel): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= products.size()) {
            cart.addProduct(products.get(choice - 1));
        }
    }

    /**
     * Method to search products in the store
     */

    private void searchProduct() {

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        int found = 0;
        found = SearchUtils.linearSearchByName(products, name);

        if (found != 0) System.out.println("Found " + found + " Products.");
        else System.out.println("Product not found.");
    }

    /**
     * Method to do the checkout option that includes choosing the payment method, etc.
     */

    private void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");

        int method = scanner.nextInt();
        scanner.nextLine();

        try {

            Payment payment = null;
            
            if (method == 1) {
                System.out.println("Card number (16 digits): ");
                String card = scanner.nextLine();

                System.out.println("Card holder: ");
                String holder = scanner.nextLine();

                System.out.println("CVV (3 digits): ");
                String cvv = scanner.nextLine();

                payment = new CreditCardPayment(card, holder, cvv);
            } else if (method == 2) {
                System.out.println("PayPal email: ");
                String email = scanner.nextLine();

                payment = new PayPalPayment(email);
            } else {
                System.out.println("Invalid method.");
                return;
            }

            Order order = cart.checkout(payment, "ORD" + System.currentTimeMillis());
            history.addOrder(order);
            System.out.println("Order completed successfully!");
        } catch (OnlineStoreException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }
    
}
