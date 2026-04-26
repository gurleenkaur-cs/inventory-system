import java.util.Scanner;

public class InventoryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        // Add some demo products to start
        inv.addProduct("Wireless Mouse",   "Electronics", 19.99, 25);
        inv.addProduct("USB-C Cable",      "Electronics",  9.99,  3);
        inv.addProduct("Notebook",         "Stationery",   4.49, 50);
        inv.addProduct("Pens Pack",        "Stationery",   3.99,  2);
        inv.addProduct("Hand Sanitizer",   "Health",       5.99, 18);
        inv.addProduct("Instant Noodles",  "Grocery",      1.29, 100);

        boolean running = true;

        while (running) {
            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Update price");
            System.out.println("4. Restock or Sell");
            System.out.println("5. Search by name");
            System.out.println("6. Show all products");
            System.out.println("7. Show low stock alerts");
            System.out.println("8. Sort by price");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Product name: ");
                String name = sc.nextLine();
                System.out.print("Category: ");
                String category = sc.nextLine();
                System.out.print("Price: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.print("Quantity: ");
                int qty = Integer.parseInt(sc.nextLine());
                inv.addProduct(name, category, price, qty);

            } else if (choice == 2) {
                System.out.print("Enter product ID to remove: ");
                int id = Integer.parseInt(sc.nextLine());
                inv.removeProduct(id);

            } else if (choice == 3) {
                System.out.print("Enter product ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("New price: ");
                double price = Double.parseDouble(sc.nextLine());
                inv.updatePrice(id, price);

            } else if (choice == 4) {
                System.out.print("Enter product ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.println("Positive number = restock | Negative = sell");
                System.out.print("Amount: ");
                int amount = Integer.parseInt(sc.nextLine());
                inv.updateQuantity(id, amount);

            } else if (choice == 5) {
                System.out.print("Search keyword: ");
                String keyword = sc.nextLine();
                inv.searchByName(keyword);

            } else if (choice == 6) {
                inv.showAll();

            } else if (choice == 7) {
                inv.showLowStock();

            } else if (choice == 8) {
                inv.sortByPrice();

            } else if (choice == 0) {
                System.out.println("Goodbye!");
                running = false;
            }
        }

        sc.close();
    }
}

