package JavaWebStore.service;

import JavaWebStore.model.Product;
import java.util.ArrayList;

/**
 * The SearchUtils class is meant to be a toolbox of searching tools to find product available in our store
 */

public class SearchUtils {

    /**
     * Method to search the product by name (it displays all the items that contains the name),
     * be specific if you want detailed results
     * @param products The list of products of our store
     * @param name The name entered by the user
     * @return Return an int, the number of items found
     */

    public static int linearSearchByName(ArrayList<Product> products, String name) {
        int c = 0;
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println("Product found: " + p);
                c++;
            }
        }
        return c;
    }

    /**
     * Same method but by price (not in the menu yet)
     * @param products The list of products available at the store
     * @param price the price provided by the user
     * @return Return the firt product that has a corresponding price, null if none found
     */

    public static Product linearSearchByPrice(ArrayList<Product> products, double price) {
        for (Product p : products) {
            if (p.getPrice() == price) return p;
        }
        return null;
    }

    /**
     * We're searching only one precise name with binary search
     * @param products the list of products available in our store
     * @param name the product's name entered by the user
     * @return returns the first product that has exactly the name wanted, null if none found
     */

    public static Product binarySearchByName(ArrayList<Product> products, String name) {
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products.get(mid).getName().compareToIgnoreCase(name);
            if (comparison == 0) return products.get(mid);
            else if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }
    
}
