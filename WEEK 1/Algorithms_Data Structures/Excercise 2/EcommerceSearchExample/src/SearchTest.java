public class SearchTest {

    public static void main(String[] args) {

        Product[] products = {

                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Shoes", "Fashion"),
                new Product(103, "Phone", "Electronics"),
                new Product(102, "Watch", "Accessories"),
                new Product(104, "Bag", "Fashion")

        };

        System.out.println("----- Linear Search -----");

        Product result1 = SearchOperations.linearSearch(products, 103);

        if (result1 != null) {
            result1.display();
        } else {
            System.out.println("Product Not Found");
        }

        SearchOperations.sortProducts(products);

        System.out.println("\n----- Binary Search -----");

        Product result2 = SearchOperations.binarySearch(products, 103);

        if (result2 != null) {
            result2.display();
        } else {
            System.out.println("Product Not Found");
        }

    }
}