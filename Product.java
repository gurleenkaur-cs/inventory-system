public class Product {

    int id;
    String name;
    String category;
    double price;
    int quantity;

    public Product(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public void printProduct() {
        System.out.println("ID: " + id + " | Name: " + name + " | Category: " + category
                + " | Price: $" + price + " | Quantity: " + quantity);
    }
}
