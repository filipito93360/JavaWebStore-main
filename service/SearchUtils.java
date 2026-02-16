package JavaWebStore.service;

import JavaWebStore.model.Product;
import java.util.ArrayList;

public class SearchUtils {

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

    public static Product linearSearchByPrice(ArrayList<Product> products, double price) {
        for (Product p : products) {
            if (p.getPrice() == price) return p;
        }
        return null;
    }

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
