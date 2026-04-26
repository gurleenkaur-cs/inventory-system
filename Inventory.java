import java.util.ArrayList;

public class Inventory {

    ArrayList<Product> products = new ArrayList<>();
    int nextId = 1;

    // Add a new product
    public void addProduct(String name, String category, double price, int quantity) {
        Product p = new Product(nextId, name, category, price, quantity);
        products.add(p);
        nextId++;
        System.out.println("Product added: " + name);
    }

    // Remove product by ID
    public void removeProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).id == id) {
                System.out.println("Removed: " + products.get(i).name);
                products.remove(i);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    // Update price by ID
    public void updatePrice(int id, double newPrice) {
        for (Product p : products) {
            if (p.id == id) {
                p.price = newPrice;
                System.out.println("Price updated for: " + p.name);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    // Restock or sell (use negative number to sell)
    public void updateQuantity(int id, int amount) {
        for (Product p : products) {
            if (p.id == id) {
                p.quantity += amount;
                System.out.println("Quantity updated for: " + p.name + " | New Qty: " + p.quantity);
                if (p.quantity <= 5) {
                    System.out.println("WARNING: Low stock on " + p.name);
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }

    // Search by name keyword
    public void searchByName(String keyword) {
        boolean found = false;
        for (Product p : products) {
            if (p.name.toLowerCase().contains(keyword.toLowerCase())) {
                p.printProduct();
                found = true;
            }
        }
        if (!found) System.out.println("No products found.");
    }

    // Show all products
    public void showAll() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n===== ALL PRODUCTS =====");
        for (Product p : products) {
            p.printProduct();
        }
    }

    // Show low stock items (quantity 5 or less)
    public void showLowStock() {
        System.out.println("\n===== LOW STOCK ALERTS =====");
        boolean found = false;
        for (Product p : products) {
            if (p.quantity <= 5) {
                p.printProduct();
                found = true;
            }
        }
        if (!found) System.out.println("All products are well stocked!");
    }

    // Sort products by price (low to high) using bubble sort
    public void sortByPrice() {
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).price > products.get(j + 1).price) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sorted by price (low to high):");
        showAll();
    }
}
