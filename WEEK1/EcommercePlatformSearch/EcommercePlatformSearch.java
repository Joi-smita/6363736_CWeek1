package EcommercePlatformSearch;

import java.util.Arrays;
import java.util.Comparator;

public class  EcommercePlatformSearch{

    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int id, String name, String cat) {
            this.productId = id;
            this.productName = name;
            this.category = cat;
        }

        public String toString() {
            return "[" + productId + ", " + productName + ", " + category + "]";
        }
    }

   
    static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) return p;
        }
        return null;
    }

    
    static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0, high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedProducts[mid].productId == targetId)
                return sortedProducts[mid];
            else if (sortedProducts[mid].productId < targetId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // Step 3: Data Setup
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "T-Shirt", "Clothing"),
            new Product(103, "Book", "Education"),
            new Product(104, "Mouse", "Electronics"),
            new Product(102, "Shoes", "Footwear")
        };

        // Linear Search (unsorted)
        System.out.println("Linear Search:");
        Product result1 = linearSearch(products, 103);
        System.out.println(result1 != null ? "Found: " + result1 : "Not found");

        // Binary Search (sort first by productId)
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        System.out.println("\nBinary Search (after sorting):");
        Product result2 = binarySearch(products, 103);
        System.out.println(result2 != null ? "Found: " + result2 : "Not found");

        System.out.println("\nTime Complexity:");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n) [Requires sorted array]");
        System.out.println("\n Recommendation: Use Binary Search for large, sorted product data.");
    }
}
