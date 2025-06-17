import java.util.*;
class Product {
    String name;
    double price;
    double rating;
    Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
    public String toString() {
        return "Product Name: " + name + ", Price: $" + price + ", Rating: " + rating + "★";
    }
}
public class ECommerceApp {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- E-Commerce System ---");
            System.out.println("1. Display Products (Low to High Price)");
            System.out.println("2. Display Products (High to Low Price)");
            System.out.println("3. Add Product");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Update Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayProducts(true);
                    break;
                case 2:
                    displayProducts(false);
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    updateProduct();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    static void displayProducts(boolean lowToHigh) {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        products.sort((p1, p2) -> {
            if (lowToHigh)
                return Double.compare(p1.price, p2.price);
            else
                return Double.compare(p2.price, p1.price);
        });
        System.out.println("\n--- Product List ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }
    static void addProduct() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Rating (out of 5): ");
        double rating = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        products.add(new Product(name, price, rating));
        System.out.println("Product added successfully.");
    }

    static void searchProduct() {
        System.out.print("Enter Product Name to Search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.println("Product Found: " + p);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }
    static void updateProduct() {
        System.out.print("Enter Product Name to Update: ");
        String name = scanner.nextLine();
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.print("Enter New Price: ");
                p.price = scanner.nextDouble();
                System.out.print("Enter New Rating: ");
                p.rating = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
}