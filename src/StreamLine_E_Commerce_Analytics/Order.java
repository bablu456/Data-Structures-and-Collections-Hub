package StreamLine_E_Commerce_Analytics;

import java.security.PublicKey;

public class Order {
    private int id;
    private String product;
    private double price;
    private String status;   // Delivered, Shipped, Pending

    public Order(int id, String product, double price, String status) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.status = status;
    }

    public String getProduct() {
        return product;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return "Order ID: " + id + ", Product: " + product + ", Price: $" + price + ", Status: " + status;
    }
}
