package TCP;
import java.io.*;
public class Laptop implements Serializable {
    private static final long serialVersionUID = 20150711;
    private int id;
    private String code, name;
    private int quantity;
    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}