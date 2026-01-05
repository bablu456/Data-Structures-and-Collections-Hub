package MiniECommerceFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private String name;
    private String category;
    private double price;

    // constructor made for intialize the objects
    public Product(String name, String category, double price){
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " :₹" + price;
    }
}
interface DiscountCalculator {
    double applyDiscount(double price);
}

 class Main{
    public static void main(String[] args){

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 50000));
        products.add(new Product("Shoes", "Fashion", 2000));
        products.add(new Product("Mobile", "Electronics", 15000));
        products.add(new Product("T-Shirt", "Fashion", 500));

        System.out.println("--- 1. Using Interface & Lambda ---");

        DiscountCalculator festiveOffer = (price) -> price * 0.90;

        double oldPrice = 50000;
        double newPrice = festiveOffer.applyDiscount(oldPrice);
        System.out.println("Discounted Price for Laptop: ₹" + newPrice);

        System.out.println("\n--- 2. Using Streams (The Modern Power) ---");


        List<String> electronicsGadgets = products.stream()
                .filter(p -> p.getCategory().equals("Electronis"))
                .map(p -> p.getName())
                .collect(Collectors.toUnmodifiableList());

        electronicsGadgets.forEach(System.out::println);

    }
}
