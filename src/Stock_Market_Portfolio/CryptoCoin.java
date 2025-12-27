package Stock_Market_Portfolio;

public class CryptoCoin {
    private String name;
    private double price;
    private String symbol;
    private String Category;

    // Constructor to initialize all fields
    public CryptoCoin(String name, double price, String symbol, String category) {
        this.name = name;
        this.price = price;
        this.symbol = symbol;
        Category = category;
    }
    // Getters for all fields

    @Override
    public String toString() {
        return symbol + "$" + price;
    }

    public double getPrice() {
        return price;
    }
    public String getSymbol() {
        return symbol;
    }

    public String getCategory() {
        return Category;
    }
}
