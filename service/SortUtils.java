package JavaWebStore.service;

import JavaWebStore.model.Product;
import java.util.ArrayList;

public class SortUtils {
    
    public static void bubbleSortByPrice(ArrayList<Product> products) {
        int n = products.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (products.get(j).getPrice() > products.get(j+1).getPrice()) {

                    Product temp = products.get(j);
                    products.set(j, products.get(j+1));
                    products.set(j+1, temp);
                }
            }
        }
    }

    public static void insertionSortByName(ArrayList<Product> products) {

        for (int i = 1; i < products.size(); i++) {

            Product key = products.get(i);
            int j = i - 1;

            while (j >= 0 && products.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                products.set(j+1, products.get(j));
                j--;
            }

            products.set(j+1, key);
        }
    }

    public static void selectionSortByPrice(ArrayList<Product> products) {

        for (int i = 0; i < products.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < products.size(); j++) {

                if (products.get(j).getPrice() < products.get(minIndex).getPrice()) {
                    minIndex = j;
                }
            }

            Product temp = products.get(i);
            products.set(i, products.get(minIndex));
            products.set(minIndex, temp);
        }
    }
}
