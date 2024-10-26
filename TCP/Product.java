package TCP;
import java.io.*;
public class Product implements Serializable{
    private static final long serialVersionUID = 20231107;
    private int id, discount;
    private double price;
    private String name;
    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", discount=" + discount + ", price=" + price + ", name=" + name + '}';
    }
}
