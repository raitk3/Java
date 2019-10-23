package ee.taltech.iti0202.stock.product;
import ee.taltech.iti0202.stock.exceptions.StockException;

public class Product {
    int queue = 1;
    String name;
    Integer price;
    public Product(String name, int price) throws StockException {
        this.name = name;
        this.price = price;
        int id = queue;
    }

    public static int getNextId() {
        return this.getId() + 1;
    }

    public int getId() {
        return this.queue;
    }

    public String getName() {
        return productName;
    }

    public int getPrice() {
        return productPrice;
    }
}